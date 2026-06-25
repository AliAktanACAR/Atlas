package atlas.math;

import java.util.Objects;

/**
 * Immutable two-dimensional vector.
 */
public final class Vector2 {

    public static final Vector2 ZERO = new Vector2(0.0, 0.0);
    public static final Vector2 UNIT_X = new Vector2(1.0, 0.0);
    public static final Vector2 UNIT_Y = new Vector2(0.0, 1.0);

    private final double x;
    private final double y;

    public Vector2() {
        this(0.0, 0.0);
    }

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /* ---------- Getters ---------- */

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /* ---------- Basic Operations ---------- */

    public Vector2 add(Vector2 other) {
        Objects.requireNonNull(other);
        return new Vector2(x + other.x, y + other.y);
    }

    public Vector2 subtract(Vector2 other) {
        Objects.requireNonNull(other);
        return new Vector2(x - other.x, y - other.y);
    }

    public Vector2 multiply(double scalar) {
        return new Vector2(x * scalar, y * scalar);
    }

    public Vector2 divide(double scalar) {
        if (MathUtil.epsilonEquals(scalar, 0.0)) {
            throw new ArithmeticException("Division by zero.");
        }

        return new Vector2(x / scalar, y / scalar);
    }

    public Vector2 negate() {
        return new Vector2(-x, -y);
    }

    /* ---------- Vector Math ---------- */

    public double dot(Vector2 other) {
        Objects.requireNonNull(other);
        return x * other.x + y * other.y;
    }

    /**
     * Returns the z-component of the 2D cross product.
     */
    public double cross(Vector2 other) {
        Objects.requireNonNull(other);
        return x * other.y - y * other.x;
    }

    public double magnitudeSquared() {
        return x * x + y * y;
    }

    public double magnitude() {
        return Math.sqrt(magnitudeSquared());
    }

    public Vector2 normalize() {

        double magnitude = magnitude();

        if (MathUtil.epsilonEquals(magnitude, 0.0)) {
            return ZERO;
        }

        return divide(magnitude);
    }

    public double distance(Vector2 other) {
        Objects.requireNonNull(other);
        return subtract(other).magnitude();
    }

    public double distanceSquared(Vector2 other) {
        Objects.requireNonNull(other);
        return subtract(other).magnitudeSquared();
    }

    public double angle() {
        return Math.atan2(y, x);
    }

    public double angleTo(Vector2 other) {
        Objects.requireNonNull(other);

        return Math.atan2(
                cross(other),
                dot(other)
        );
    }

    public Vector2 rotate(double radians) {

        double cos = Math.cos(radians);
        double sin = Math.sin(radians);

        return new Vector2(
                x * cos - y * sin,
                x * sin + y * cos
        );
    }

    public Vector2 project(Vector2 onto) {

        Objects.requireNonNull(onto);

        double denominator = onto.magnitudeSquared();

        if (MathUtil.epsilonEquals(denominator, 0.0)) {
            return ZERO;
        }

        return onto.multiply(dot(onto) / denominator);
    }

    public Vector2 lerp(Vector2 other, double t) {

        Objects.requireNonNull(other);

        return new Vector2(
                MathUtil.lerp(x, other.x, t),
                MathUtil.lerp(y, other.y, t)
        );
    }

    public Vector2 midpoint(Vector2 other) {
        Objects.requireNonNull(other);

        return new Vector2(
                (x + other.x) / 2.0,
                (y + other.y) / 2.0
        );
    }

    /* ---------- Utility ---------- */

    public boolean isZero() {
        return MathUtil.epsilonEquals(x, 0.0)
                && MathUtil.epsilonEquals(y, 0.0);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Vector2 other))
            return false;

        return MathUtil.epsilonEquals(x, other.x)
                && MathUtil.epsilonEquals(y, other.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("Vector2[x=%.6f, y=%.6f]", x, y);
    }
}

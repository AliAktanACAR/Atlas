package atlas.math;

import java.util.Objects;

/**
 * Represents a 2D rotation.
 *
 * <p>Angles are stored in radians.</p>
 */
public final class Rotation2D {

    private final double radians;

    public Rotation2D() {
        this(0.0);
    }

    public Rotation2D(double radians) {
        this.radians = normalize(radians);
    }

    public static Rotation2D fromRadians(double radians) {
        return new Rotation2D(radians);
    }

    public static Rotation2D fromDegrees(double degrees) {
        return new Rotation2D(Math.toRadians(degrees));
    }

    public double getRadians() {
        return radians;
    }

    public double getDegrees() {
        return Math.toDegrees(radians);
    }

    public double getCos() {
        return Math.cos(radians);
    }

    public double getSin() {
        return Math.sin(radians);
    }

    public Vector2 rotate(Vector2 vector) {
        Objects.requireNonNull(vector, "Vector cannot be null.");

        return vector.rotate(radians);
    }

    public Rotation2D plus(Rotation2D other) {
        Objects.requireNonNull(other, "Rotation cannot be null.");

        return new Rotation2D(
                radians + other.radians
        );
    }

    public Rotation2D minus(Rotation2D other) {
        Objects.requireNonNull(other, "Rotation cannot be null.");

        return new Rotation2D(
                radians - other.radians
        );
    }

    public Rotation2D times(double scalar) {
        return new Rotation2D(
                radians * scalar
        );
    }

    public Rotation2D div(double scalar) {
        if (MathUtil.epsilonEquals(scalar, 0.0)) {
            throw new ArithmeticException("Division by zero.");
        }

        return new Rotation2D(
                radians / scalar
        );
    }

    public Rotation2D inverse() {
        return new Rotation2D(-radians);
    }

    /**
     * Returns the smallest signed angular difference
     * from this rotation to another.
     */
    public double difference(Rotation2D other) {
        Objects.requireNonNull(other, "Rotation cannot be null.");

        return normalize(
                other.radians - radians
        );
    }

    private static double normalize(double angle) {
        double result =
                Math.IEEEremainder(
                        angle,
                        MathConstants.TWO_PI
                );

        if (result <= -Math.PI) {
            result += MathConstants.TWO_PI;
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Rotation2D other)) {
            return false;
        }

        return MathUtil.epsilonEquals(
                radians,
                other.radians
        );
    }

    @Override
    public int hashCode() {
        long rounded =
                Math.round(
                        radians / MathConstants.EPSILON
                );

        return Long.hashCode(rounded);
    }

    @Override
    public String toString() {
        return String.format(
                "Rotation2D(%.3f°)",
                getDegrees()
        );
    }
}

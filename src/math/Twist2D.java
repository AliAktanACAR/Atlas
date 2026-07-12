package atlas.math;

import java.util.Objects;

public final class Twist2D {

    private final double dx;
    private final double dy;
    private final double dTheta;

    /**
     * Creates a new Twist2D.
     *
     * @param dx Forward movement.
     * @param dy Sideways movement.
     * @param dTheta Change in heading (radians).
     */
    public Twist2D(double dx, double dy, double dTheta) {
        this.dx = dx;
        this.dy = dy;
        this.dTheta = dTheta;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public double getDTheta() {
        return dTheta;
    }

    public Twist2D plus(Twist2D other) {
        return new Twist2D(
                dx + other.dx,
                dy + other.dy,
                dTheta + other.dTheta
        );
    }

    public Twist2D minus(Twist2D other) {
        return new Twist2D(
                dx - other.dx,
                dy - other.dy,
                dTheta - other.dTheta
        );
    }

    public Twist2D times(double scalar) {
        return new Twist2D(
                dx * scalar,
                dy * scalar,
                dTheta * scalar
        );
    }

    public Twist2D div(double scalar) {
        if (scalar == 0.0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }

        return new Twist2D(
                dx / scalar,
                dy / scalar,
                dTheta / scalar
        );
    }

    public double norm() {
        return Math.hypot(dx, dy);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Twist2D other)) return false;

        return Double.compare(dx, other.dx) == 0
                && Double.compare(dy, other.dy) == 0
                && Double.compare(dTheta, other.dTheta) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dx, dy, dTheta);
    }

    @Override
    public String toString() {
        return String.format(
                "Twist2D(dx=%.3f, dy=%.3f, dTheta=%.3f)",
                dx,
                dy,
                dTheta
        );
    }
}

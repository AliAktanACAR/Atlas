package atlas.math;

import java.util.Objects;

/**
 * Represents a robot pose in a 2D field coordinate system.
 *
 * <p>A pose consists of an x/y position and a heading.</p>
 */
public final class Pose2D {

    private final Vector2 position;
    private final Rotation2D rotation;

    public Pose2D() {
        this(Vector2.ZERO, new Rotation2D());
    }

    public Pose2D(double x, double y, double headingRadians) {
        this(new Vector2(x, y), new Rotation2D(headingRadians));
    }

    public Pose2D(Vector2 position, Rotation2D rotation) {
        this.position = Objects.requireNonNull(position, "Position cannot be null.");
        this.rotation = Objects.requireNonNull(rotation, "Rotation cannot be null.");
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rotation2D getRotation() {
        return rotation;
    }

    public double getHeadingRadians() {
        return rotation.getRadians();
    }

    public double getHeadingDegrees() {
        return rotation.getDegrees();
    }

    public Pose2D plus(Twist2D twist) {
        Objects.requireNonNull(twist, "Twist cannot be null.");

        Vector2 fieldDelta = new Vector2(
                twist.getDx(),
                twist.getDy()
        ).rotate(rotation.getRadians());

        return new Pose2D(
                position.add(fieldDelta),
                rotation.plus(new Rotation2D(twist.getDTheta()))
        );
    }

    public Pose2D transformBy(Transform2D transform) {
        Objects.requireNonNull(transform, "Transform cannot be null.");

        Vector2 translated =
                position.add(rotation.rotate(transform.getTranslation()));

        return new Pose2D(
                translated,
                rotation.plus(transform.getRotation())
        );
    }

    public Transform2D relativeTo(Pose2D other) {
        Objects.requireNonNull(other, "Pose cannot be null.");

        Vector2 translation = position
                .subtract(other.position)
                .rotate(-other.rotation.getRadians());

        Rotation2D rotationDelta =
                other.rotation.inverse().plus(rotation);

        return new Transform2D(
                translation,
                rotationDelta
        );
    }

    public double distance(Pose2D other) {
        Objects.requireNonNull(other, "Pose cannot be null.");

        return position.distance(other.position);
    }

    public Pose2D withPosition(double x, double y) {
        return new Pose2D(
                x,
                y,
                rotation.getRadians()
        );
    }

    public Pose2D withRotation(Rotation2D newRotation) {
        return new Pose2D(
                position,
                newRotation
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Pose2D other)) {
            return false;
        }

        return position.equals(other.position)
                && rotation.equals(other.rotation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, rotation);
    }

    @Override
    public String toString() {
        return String.format(
                "Pose2D(x=%.3f, y=%.3f, heading=%.3f°)",
                getX(),
                getY(),
                getHeadingDegrees()
        );
    }
}

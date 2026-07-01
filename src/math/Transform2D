package atlas.math;

import java.util.Objects;

public final class Transform2D {

    private final Vector2 translation;
    private final Rotation2D rotation;

    /**
     * Creates a new transform.
     *
     * @param translation Translation component.
     * @param rotation Rotation component.
     */
    public Transform2D(Vector2 translation, Rotation2D rotation) {
        this.translation = Objects.requireNonNull(translation, "Translation cannot be null.");
        this.rotation = Objects.requireNonNull(rotation, "Rotation cannot be null.");
    }

    /**
     * Creates a transform from x, y and heading.
     *
     * @param x Translation in x.
     * @param y Translation in y.
     * @param rotation Rotation.
     */
    public Transform2D(double x, double y, Rotation2D rotation) {
        this(new Vector2(x, y), rotation);
    }

    public Vector2 getTranslation() {
        return translation;
    }

    public Rotation2D getRotation() {
        return rotation;
    }

    public Transform2D plus(Transform2D other) {
        return new Transform2D(
                translation.plus(other.translation),
                rotation.plus(other.rotation)
        );
    }

    public Transform2D minus(Transform2D other) {
        return new Transform2D(
                translation.minus(other.translation),
                rotation.minus(other.rotation)
        );
    }

    public Transform2D times(double scalar) {
        return new Transform2D(
                translation.times(scalar),
                rotation.times(scalar)
        );
    }

    public Transform2D div(double scalar) {
        if (scalar == 0.0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }

        return new Transform2D(
                translation.div(scalar),
                rotation.div(scalar)
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Transform2D other)) return false;

        return translation.equals(other.translation)
                && rotation.equals(other.rotation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(translation, rotation);
    }

    @Override
    public String toString() {
        return String.format(
                "Transform2D(translation=%s, rotation=%s)",
                translation,
                rotation
        );
    }
}

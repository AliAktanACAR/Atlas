package atlas.sensors;

/**
 * Represents a generic rotational encoder.
 *
 * <p>Hardware-specific encoders can implement this interface.</p>
 */
public interface Encoder {

    /**
     * Returns the current encoder position in degrees.
     */
    double getPositionDegrees();

    /**
     * Returns the current encoder velocity in degrees per second.
     */
    double getVelocityDegreesPerSecond();

    /**
     * Resets the encoder position to zero.
     */
    void reset();

    /**
     * Returns the current encoder position in rotations.
     */
    default double getPositionRotations() {
        return getPositionDegrees() / 360.0;
    }

    /**
     * Returns the current encoder velocity in rotations per second.
     */
    default double getVelocityRotationsPerSecond() {
        return getVelocityDegreesPerSecond() / 360.0;
    }
}

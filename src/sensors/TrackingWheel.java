package atlas.sensors;

import atlas.math.Units;

/**
 * Represents a passive tracking wheel used for robot localization.
 *
 * <p>A tracking wheel converts encoder rotation into linear distance.</p>
 */
public class TrackingWheel {

    private final Encoder encoder;

    private final double wheelDiameter;
    private final double offset;

    /**
     * Creates a tracking wheel.
     *
     * @param encoder encoder connected to the wheel
     * @param wheelDiameter wheel diameter
     * @param offset distance from the robot's tracking center
     */
    public TrackingWheel(
            Encoder encoder,
            double wheelDiameter,
            double offset
    ) {
        if (encoder == null) {
            throw new IllegalArgumentException(
                    "Encoder cannot be null."
            );
        }

        if (wheelDiameter <= 0.0) {
            throw new IllegalArgumentException(
                    "Wheel diameter must be greater than zero."
            );
        }

        this.encoder = encoder;
        this.wheelDiameter = wheelDiameter;
        this.offset = offset;
    }

    /**
     * Returns the encoder used by this wheel.
     */
    public Encoder getEncoder() {
        return encoder;
    }

    /**
     * Returns the wheel diameter.
     */
    public double getWheelDiameter() {
        return wheelDiameter;
    }

    /**
     * Returns the wheel offset from the tracking center.
     */
    public double getOffset() {
        return offset;
    }

    /**
     * Returns the current wheel distance
     * based on encoder rotation.
     */
    public double getDistance() {
        return Units.encoderDegreesToDistance(
                encoder.getPositionDegrees(),
                wheelDiameter
        );
    }

    /**
     * Returns the wheel velocity in distance per second.
     */
    public double getVelocity() {
        return Units.rotationsToDistance(
                encoder.getVelocityDegreesPerSecond() / 360.0,
                wheelDiameter
        );
    }

    /**
     * Resets the encoder position.
     */
    public void reset() {
        encoder.reset();
    }
}

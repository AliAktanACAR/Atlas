package atlas.sensors;

/**
 * Represents a generic inertial measurement unit.
 */
public interface IMUSensor {

    /**
     * Returns the robot heading in degrees.
     */
    double getHeadingDegrees();

    /**
     * Returns the robot heading in radians.
     */
    double getHeadingRadians();

    /**
     * Returns angular velocity around the vertical axis
     * in degrees per second.
     */
    double getAngularVelocityDegreesPerSecond();

    /**
     * Resets the heading to zero.
     */
    void resetHeading();

    /**
     * Returns whether the sensor is calibrated.
     */
    boolean isCalibrated();
}

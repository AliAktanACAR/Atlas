package atlas.math;

public final class Units {

    private Units() {
        throw new UnsupportedOperationException("Utility class");
    }

    /* ---------------- Angle ---------------- */

    public static double degreesToRadians(double degrees) {
        return degrees * MathConstants.DEG_TO_RAD;
    }

    public static double radiansToDegrees(double radians) {
        return radians * MathConstants.RAD_TO_DEG;
    }

    /* ---------------- Length ---------------- */

    public static double inchesToMillimeters(double inches) {
        return inches * 25.4;
    }

    public static double millimetersToInches(double millimeters) {
        return millimeters / 25.4;
    }

    public static double inchesToCentimeters(double inches) {
        return inches * 2.54;
    }

    public static double centimetersToInches(double centimeters) {
        return centimeters / 2.54;
    }

    public static double centimetersToMeters(double centimeters) {
        return centimeters / 100.0;
    }

    public static double metersToCentimeters(double meters) {
        return meters * 100.0;
    }

    public static double millimetersToMeters(double millimeters) {
        return millimeters / 1000.0;
    }

    public static double metersToMillimeters(double meters) {
        return meters * 1000.0;
    }

    /* ---------------- Rotation ---------------- */

    public static double rotationsToDegrees(double rotations) {
        return rotations * 360.0;
    }

    public static double degreesToRotations(double degrees) {
        return degrees / 360.0;
    }

    public static double rotationsToRadians(double rotations) {
        return rotations * MathConstants.TWO_PI;
    }

    public static double radiansToRotations(double radians) {
        return radians / MathConstants.TWO_PI;
    }

    /* ---------------- Wheel ---------------- */

    public static double wheelCircumference(double diameter) {
        return diameter * MathConstants.PI;
    }

    public static double rotationsToDistance(double rotations, double wheelDiameter) {
        return rotations * wheelCircumference(wheelDiameter);
    }

    public static double distanceToRotations(double distance, double wheelDiameter) {
        return distance / wheelCircumference(wheelDiameter);
    }

    public static double encoderDegreesToDistance(double encoderDegrees, double wheelDiameter) {
        return rotationsToDistance(encoderDegrees / 360.0, wheelDiameter);
    }

    public static double distanceToEncoderDegrees(double distance, double wheelDiameter) {
        return distanceToRotations(distance, wheelDiameter) * 360.0;
    }

    /* ---------------- Velocity ---------------- */

    public static double rpmToDegreesPerSecond(double rpm) {
        return rpm * 6.0;
    }

    public static double degreesPerSecondToRPM(double degreesPerSecond) {
        return degreesPerSecond / 6.0;
    }

    public static double rpmToRadiansPerSecond(double rpm) {
        return rpm * MathConstants.TWO_PI / 60.0;
    }

    public static double radiansPerSecondToRPM(double radiansPerSecond) {
        return radiansPerSecond * 60.0 / MathConstants.TWO_PI;
    }

}

package atlas.math;

public final class MathUtil {

    private MathUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Limits a value between a minimum and maximum.
     */
    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    /**
     * Returns true if two values are approximately equal.
     */
    public static boolean epsilonEquals(double a, double b) {
        return Math.abs(a - b) < MathConstants.EPSILON;
    }

    /**
     * Returns true if two values are approximately equal using a custom epsilon.
     */
    public static boolean epsilonEquals(double a, double b, double epsilon) {
        return Math.abs(a - b) < epsilon;
    }

    /**
     * Linearly interpolates between two values.
     */
    public static double lerp(double start, double end, double t) {
        return start + (end - start) * t;
    }

    /**
     * Maps a value from one range to another.
     */
    public static double map(double value,
                             double inMin,
                             double inMax,
                             double outMin,
                             double outMax) {

        if (epsilonEquals(inMin, inMax)) {
            throw new IllegalArgumentException("Input range cannot be zero.");
        }

        return outMin + ((value - inMin) / (inMax - inMin)) * (outMax - outMin);
    }

    /**
     * Returns the sign of a number.
     */
    public static int sign(double value) {
        if (value > 0) return 1;
        if (value < 0) return -1;
        return 0;
    }

    /**
     * Squares a number.
     */
    public static double square(double value) {
        return value * value;
    }

    /**
     * Cubes a number.
     */
    public static double cube(double value) {
        return value * value * value;
    }

    /**
     * Returns the average of two numbers.
     */
    public static double average(double a, double b) {
        return (a + b) / 2.0;
    }

    /**
     * Applies a joystick deadband.
     */
    public static double deadband(double value, double deadband) {
        return Math.abs(value) > deadband ? value : 0.0;
    }

    /**
     * Normalizes a value between 0 and 1.
     */
    public static double normalize(double value, double min, double max) {
        if (epsilonEquals(min, max)) {
            throw new IllegalArgumentException("Range cannot be zero.");
        }

        return (value - min) / (max - min);
    }

    /**
     * Restricts a value to the range [0, 1].
     */
    public static double saturate(double value) {
        return clamp(value, 0.0, 1.0);
    }

    /**
     * Returns the absolute difference between two values.
     */
    public static double difference(double a, double b) {
        return Math.abs(a - b);
    }

    /**
     * Checks whether a value is within a range.
     */
    public static boolean isBetween(double value, double min, double max) {
        return value >= min && value <= max;
    }

    /**
     * Returns the maximum of three values.
     */
    public static double max(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }

    /**
     * Returns the minimum of three values.
     */
    public static double min(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }
}

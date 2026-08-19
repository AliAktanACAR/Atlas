package atlas.math;

public final class MathUtil {

    private MathUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static double clamp(
            double value,
            double min,
            double max
    ) {
        return Math.max(
                min,
                Math.min(max, value)
        );
    }

    public static boolean epsilonEquals(
            double a,
            double b
    ) {
        return Math.abs(a - b)
                < MathConstants.EPSILON;
    }

    public static boolean epsilonEquals(
            double a,
            double b,
            double epsilon
    ) {
        return Math.abs(a - b) < epsilon;
    }

    public static double lerp(
            double start,
            double end,
            double t
    ) {
        return start + (end - start) * t;
    }

    public static double map(
            double value,
            double inMin,
            double inMax,
            double outMin,
            double outMax
    ) {
        if (epsilonEquals(inMin, inMax)) {
            throw new IllegalArgumentException(
                    "Input range cannot be zero."
            );
        }

        return outMin
                + ((value - inMin) / (inMax - inMin))
                * (outMax - outMin);
    }

    public static int sign(double value) {
        if (value > 0) return 1;
        if (value < 0) return -1;
        return 0;
    }

    public static double square(double value) {
        return value * value;
    }

    public static double cube(double value) {
        return value * value * value;
    }

    public static double average(
            double a,
            double b
    ) {
        return (a + b) / 2.0;
    }

    public static double deadband(
            double value,
            double deadband
    ) {
        return Math.abs(value) > deadband
                ? value
                : 0.0;
    }

    public static double normalize(
            double value,
            double min,
            double max
    ) {
        if (epsilonEquals(min, max)) {
            throw new IllegalArgumentException(
                    "Range cannot be zero."
            );
        }

        return (value - min) / (max - min);
    }

    public static double saturate(double value) {
        return clamp(
                value,
                0.0,
                1.0
        );
    }

    public static double difference(
            double a,
            double b
    ) {
        return Math.abs(a - b);
    }

    public static boolean isBetween(
            double value,
            double min,
            double max
    ) {
        return value >= min
                && value <= max;
    }

    public static double max(
            double a,
            double b,
            double c
    ) {
        return Math.max(
                a,
                Math.max(b, c)
        );
    }

    public static double min(
            double a,
            double b,
            double c
    ) {
        return Math.min(
                a,
                Math.min(b, c)
        );
    }

    /**
     * Wraps an angle to [-pi, pi).
     */
    public static double normalizeRadians(
            double radians
    ) {
        double result =
                Math.IEEEremainder(
                        radians,
                        MathConstants.TWO_PI
                );

        if (result >= Math.PI) {
            result -= MathConstants.TWO_PI;
        }

        return result;
    }

    /**
     * Wraps an angle to [-180, 180) degrees.
     */
    public static double normalizeDegrees(
            double degrees
    ) {
        double result = degrees % 360.0;

        if (result >= 180.0) {
            result -= 360.0;
        }

        if (result < -180.0) {
            result += 360.0;
        }

        return result;
    }

    /**
     * Returns the shortest signed difference
     * from the first angle to the second.
     */
    public static double angleDifferenceRadians(
            double from,
            double to
    ) {
        return normalizeRadians(to - from);
    }

    /**
     * Interpolates between two values
     * while keeping t between 0 and 1.
     */
    public static double lerpClamped(
            double start,
            double end,
            double t
    ) {
        return lerp(
                start,
                end,
                saturate(t)
        );
    }
}

package atlas.control;

/**
 * A trapezoidal motion profile.
 *
 * <p>The profile consists of three possible phases:</p>
 *
 * <ul>
 *     <li>Acceleration</li>
 *     <li>Constant velocity</li>
 *     <li>Deceleration</li>
 * </ul>
 *
 * <p>If the target is too close to reach the requested maximum
 * velocity, the profile automatically becomes triangular.</p>
 */
public class TrapezoidProfile
        implements MotionProfile {

    private final double startPosition;
    private final double startVelocity;

    private final double targetPosition;
    private final double targetVelocity;

    private final double maxVelocity;
    private final double maxAcceleration;

    private final double direction;

    private final double accelerationTime;
    private final double cruiseTime;
    private final double decelerationTime;

    private final double accelerationDistance;
    private final double cruiseDistance;

    private final double totalTime;

    /**
     * Creates a trapezoidal motion profile.
     *
     * @param startPosition starting position
     * @param startVelocity starting velocity
     * @param targetPosition target position
     * @param targetVelocity target velocity
     * @param maxVelocity maximum allowed velocity
     * @param maxAcceleration maximum allowed acceleration
     */
    public TrapezoidProfile(
            double startPosition,
            double startVelocity,
            double targetPosition,
            double targetVelocity,
            double maxVelocity,
            double maxAcceleration
    ) {
        if (maxVelocity <= 0.0) {
            throw new IllegalArgumentException(
                    "Maximum velocity must be greater than zero."
            );
        }

        if (maxAcceleration <= 0.0) {
            throw new IllegalArgumentException(
                    "Maximum acceleration must be greater than zero."
            );
        }

        this.startPosition = startPosition;
        this.startVelocity = startVelocity;
        this.targetPosition = targetPosition;
        this.targetVelocity = targetVelocity;

        this.maxVelocity = Math.abs(maxVelocity);
        this.maxAcceleration = Math.abs(maxAcceleration);

        double distance =
                targetPosition - startPosition;

        direction =
                distance >= 0.0 ? 1.0 : -1.0;

        double distanceMagnitude =
                Math.abs(distance);

        double initialVelocity =
                Math.abs(startVelocity);

        double finalVelocity =
                Math.abs(targetVelocity);

        /*
         * Velocity needed to reach the requested maximum
         * velocity from the starting velocity.
         */
        double accelTime =
                Math.max(
                        0.0,
                        (this.maxVelocity - initialVelocity)
                                / this.maxAcceleration
                );

        double decelTime =
                Math.max(
                        0.0,
                        (this.maxVelocity - finalVelocity)
                                / this.maxAcceleration
                );

        double accelDistance =
                initialVelocity * accelTime
                + 0.5 * this.maxAcceleration
                * accelTime * accelTime;

        double decelDistance =
                finalVelocity * decelTime
                + 0.5 * this.maxAcceleration
                * decelTime * decelTime;

        double remainingDistance =
                distanceMagnitude
                - accelDistance
                - decelDistance;

        /*
         * If there is not enough distance for a cruise phase,
         * calculate the peak velocity instead.
         */
        if (remainingDistance < 0.0) {

            double peakVelocitySquared =
                    (
                            2.0
                            * this.maxAcceleration
                            * distanceMagnitude
                            + initialVelocity * initialVelocity
                            + finalVelocity * finalVelocity
                    ) / 2.0;

            double peakVelocity =
                    Math.sqrt(
                            Math.max(
                                    0.0,
                                    peakVelocitySquared
                            )
                    );

            peakVelocity =
                    Math.min(
                            peakVelocity,
                            this.maxVelocity
                    );

            accelTime =
                    Math.max(
                            0.0,
                            (
                                    peakVelocity
                                    - initialVelocity
                            ) / this.maxAcceleration
                    );

            decelTime =
                    Math.max(
                            0.0,
                            (
                                    peakVelocity
                                    - finalVelocity
                            ) / this.maxAcceleration
                    );

            remainingDistance = 0.0;
        }

        accelerationTime = accelTime;

        cruiseTime =
                remainingDistance / this.maxVelocity;

        decelerationTime = decelTime;

        accelerationDistance =
                initialVelocity * accelerationTime
                + 0.5 * this.maxAcceleration
                * accelerationTime
                * accelerationTime;

        cruiseDistance =
                this.maxVelocity * cruiseTime;

        totalTime =
                accelerationTime
                + cruiseTime
                + decelerationTime;
    }

    @Override
    public double getPosition(double time) {

        double t =
                clamp(
                        time,
                        0.0,
                        totalTime
                );

        double initialVelocity =
                Math.abs(startVelocity);

        double position;

        if (t <= accelerationTime) {

            position =
                    initialVelocity * t
                    + 0.5 * maxAcceleration
                    * t * t;

        } else if (
                t <= accelerationTime + cruiseTime
        ) {

            double cruiseTimeElapsed =
                    t - accelerationTime;

            position =
                    accelerationDistance
                    + maxVelocity
                    * cruiseTimeElapsed;

        } else {

            double decelerationElapsed =
                    t
                    - accelerationTime
                    - cruiseTime;

            double finalVelocity =
                    Math.abs(targetVelocity);

            position =
                    accelerationDistance
                    + cruiseDistance
                    + maxVelocity
                    * decelerationElapsed
                    - 0.5
                    * maxAcceleration
                    * decelerationElapsed
                    * decelerationElapsed;

            /*
             * Correct the final position so numerical
             * errors do not accumulate.
             */
            if (t >= totalTime) {
                position =
                        Math.abs(
                                targetPosition
                                - startPosition
                        );
            }
        }

        return startPosition
                + direction * position;
    }

    @Override
    public double getVelocity(double time) {

        double t =
                clamp(
                        time,
                        0.0,
                        totalTime
                );

        double velocity;

        if (t <= accelerationTime) {

            velocity =
                    Math.abs(startVelocity)
                    + maxAcceleration * t;

        } else if (
                t <= accelerationTime + cruiseTime
        ) {

            velocity = maxVelocity;

        } else {

            double elapsed =
                    t
                    - accelerationTime
                    - cruiseTime;

            velocity =
                    maxVelocity
                    - maxAcceleration * elapsed;

            velocity =
                    Math.max(
                            Math.abs(targetVelocity),
                            velocity
                    );
        }

        if (t >= totalTime) {
            velocity =
                    Math.abs(targetVelocity);
        }

        return direction * velocity;
    }

    @Override
    public double getAcceleration(double time) {

        double t =
                clamp(
                        time,
                        0.0,
                        totalTime
                );

        if (t < accelerationTime) {
            return direction * maxAcceleration;
        }

        if (
                t <
                accelerationTime + cruiseTime
        ) {
            return 0.0;
        }

        if (t < totalTime) {
            return -direction * maxAcceleration;
        }

        return 0.0;
    }

    @Override
    public double getTotalTime() {
        return totalTime;
    }

    public double getAccelerationTime() {
        return accelerationTime;
    }

    public double getCruiseTime() {
        return cruiseTime;
    }

    public double getDecelerationTime() {
        return decelerationTime;
    }

    public double getMaxVelocity() {
        return maxVelocity;
    }

    public double getMaxAcceleration() {
        return maxAcceleration;
    }

    public double getStartPosition() {
        return startPosition;
    }

    public double getTargetPosition() {
        return targetPosition;
    }

    public double getStartVelocity() {
        return startVelocity;
    }

    public double getTargetVelocity() {
        return targetVelocity;
    }

    private double clamp(
            double value,
            double min,
            double max
    ) {
        return Math.max(
                min,
                Math.min(max, value)
        );
    }
}

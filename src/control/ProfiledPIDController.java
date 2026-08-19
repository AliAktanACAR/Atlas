package atlas.control;

/**
 * PID controller whose setpoint follows a motion profile.
 *
 * <p>This allows a mechanism to move toward a target while
 * respecting velocity and acceleration constraints.</p>
 */
public class ProfiledPIDController {

    private final PIDController pidController;

    private double maxVelocity;
    private double maxAcceleration;

    private double goal;

    private double currentPosition;
    private double currentVelocity;

    private double elapsedTime;

    private TrapezoidProfile profile;

    private double tolerance = 0.0;

    /**
     * Creates a profiled PID controller.
     *
     * @param kP proportional gain
     * @param kI integral gain
     * @param kD derivative gain
     * @param maxVelocity maximum profile velocity
     * @param maxAcceleration maximum profile acceleration
     */
    public ProfiledPIDController(
            double kP,
            double kI,
            double kD,
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

        pidController =
                new PIDController(
                        kP,
                        kI,
                        kD
                );

        this.maxVelocity =
                maxVelocity;

        this.maxAcceleration =
                maxAcceleration;
    }

    /**
     * Sets the final target position.
     *
     * @param goal target position
     */
    public void setGoal(
            double goal
    ) {
        this.goal = goal;

        createProfile();
    }

    /**
     * Calculates controller output.
     *
     * @param measurement current position
     * @return PID output
     */
    public double calculate(
            double measurement
    ) {
        return calculate(
                measurement,
                0.0
        );
    }

    /**
     * Calculates controller output using
     * position and measured velocity.
     *
     * @param measurement current position
     * @param velocity current velocity
     * @return PID output
     */
    public double calculate(
            double measurement,
            double velocity
    ) {
        currentPosition =
                measurement;

        currentVelocity =
                velocity;

        if (profile == null) {
            createProfile();
        }

        double desiredPosition =
                profile.getPosition(elapsedTime);

        pidController.setSetpoint(
                desiredPosition
        );

        double output =
                pidController.calculate(
                        measurement
                );

        elapsedTime += 0.02;

        return output;
    }

    /**
     * Resets the controller.
     */
    public void reset(
            double position
    ) {
        currentPosition =
                position;

        currentVelocity = 0.0;

        elapsedTime = 0.0;

        pidController.reset();

        createProfile();
    }

    /**
     * Sets the allowed output range.
     */
    public void setOutputLimits(
            double minOutput,
            double maxOutput
    ) {
        pidController.setOutputLimits(
                minOutput,
                maxOutput
        );
    }

    /**
     * Sets the position tolerance.
     */
    public void setTolerance(
            double tolerance
    ) {
        this.tolerance =
                Math.abs(tolerance);

        pidController.setTolerance(
                tolerance
        );
    }

    /**
     * Returns whether the controller
     * has reached its goal.
     */
    public boolean atGoal() {

        return Math.abs(
                goal - currentPosition
        ) <= tolerance
                && Math.abs(
                        currentVelocity
                ) <= tolerance;
    }

    /**
     * Returns the current profiled setpoint.
     */
    public double getSetpoint() {

        if (profile == null) {
            return currentPosition;
        }

        return profile.getPosition(
                elapsedTime
        );
    }

    /**
     * Returns the current desired velocity.
     */
    public double getSetpointVelocity() {

        if (profile == null) {
            return 0.0;
        }

        return profile.getVelocity(
                elapsedTime
        );
    }

    /**
     * Returns the target position.
     */
    public double getGoal() {
        return goal;
    }

    /**
     * Returns maximum profile velocity.
     */
    public double getMaxVelocity() {
        return maxVelocity;
    }

    /**
     * Returns maximum profile acceleration.
     */
    public double getMaxAcceleration() {
        return maxAcceleration;
    }

    /**
     * Updates motion constraints.
     */
    public void setConstraints(
            double maxVelocity,
            double maxAcceleration
    ) {
        if (maxVelocity <= 0.0
                || maxAcceleration <= 0.0) {
            throw new IllegalArgumentException(
                    "Motion constraints must be greater than zero."
            );
        }

        this.maxVelocity =
                maxVelocity;

        this.maxAcceleration =
                maxAcceleration;

        createProfile();
    }

    private void createProfile() {

        profile =
                new TrapezoidProfile(
                        currentPosition,
                        currentVelocity,
                        goal,
                        0.0,
                        maxVelocity,
                        maxAcceleration
                );

        elapsedTime = 0.0;
    }
}

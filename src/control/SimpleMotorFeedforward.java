package atlas.control;

/**
 * Feedforward model for a motor-driven mechanism.
 *
 * <p>
 * The model is:
 *
 * output = kS * sign(velocity)
 *        + kV * velocity
 *        + kA * acceleration
 * </p>
 */
public class SimpleMotorFeedforward
        implements Feedforward {

    private double kS;
    private double kV;
    private double kA;

    /**
     * Creates a simple motor feedforward controller.
     *
     * @param kS static friction gain
     * @param kV velocity gain
     * @param kA acceleration gain
     */
    public SimpleMotorFeedforward(
            double kS,
            double kV,
            double kA
    ) {
        this.kS = kS;
        this.kV = kV;
        this.kA = kA;
    }

    /**
     * Calculates feedforward output for a velocity.
     *
     * @param velocity desired velocity
     * @return required feedforward output
     */
    @Override
    public double calculate(
            double velocity
    ) {
        if (velocity == 0.0) {
            return 0.0;
        }

        return kS * Math.signum(velocity)
                + kV * velocity;
    }

    /**
     * Calculates feedforward output for a
     * velocity and acceleration.
     *
     * @param velocity desired velocity
     * @param acceleration desired acceleration
     * @return required feedforward output
     */
    @Override
    public double calculate(
            double velocity,
            double acceleration
    ) {
        if (velocity == 0.0
                && acceleration == 0.0) {
            return 0.0;
        }

        double staticTerm =
                velocity == 0.0
                        ? 0.0
                        : kS * Math.signum(velocity);

        return staticTerm
                + kV * velocity
                + kA * acceleration;
    }

    /**
     * Returns the static gain.
     */
    public double getKS() {
        return kS;
    }

    /**
     * Returns the velocity gain.
     */
    public double getKV() {
        return kV;
    }

    /**
     * Returns the acceleration gain.
     */
    public double getKA() {
        return kA;
    }

    /**
     * Updates all feedforward gains.
     */
    public void setGains(
            double kS,
            double kV,
            double kA
    ) {
        this.kS = kS;
        this.kV = kV;
        this.kA = kA;
    }

    /**
     * Calculates the maximum velocity
     * achievable for a given output.
     *
     * <p>
     * This assumes acceleration is zero.
     * </p>
     */
    public double maxVelocity(
            double output
    ) {
        if (kV == 0.0) {
            throw new ArithmeticException(
                    "Velocity gain cannot be zero."
            );
        }

        double sign =
                Math.signum(output);

        if (sign == 0.0) {
            return 0.0;
        }

        return (
                output - kS * sign
        ) / kV;
    }

    /**
     * Calculates the acceleration required
     * to reach a desired output.
     */
    public double calculateAcceleration(
            double velocity,
            double output
    ) {
        if (kA == 0.0) {
            throw new ArithmeticException(
                    "Acceleration gain cannot be zero."
            );
        }

        double staticTerm =
                velocity == 0.0
                        ? 0.0
                        : kS * Math.signum(velocity);

        return (
                output
                - staticTerm
                - kV * velocity
        ) / kA;
    }
}

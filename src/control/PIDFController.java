package atlas.control;

/**
 * PID controller with an additional feedforward term.
 *
 * <p>
 * The controller calculates:
 *
 * output = kP * error
 *        + kI * integral
 *        + kD * derivative
 *        + kF * feedforward
 * </p>
 */
public class PIDFController {

    private double kP;
    private double kI;
    private double kD;
    private double kF;

    private double setpoint;

    private double previousError;
    private double integral;

    private double minOutput = -1.0;
    private double maxOutput = 1.0;

    private double integralLimit =
            Double.POSITIVE_INFINITY;

    private double tolerance = 0.0;

    public PIDFController(
            double kP,
            double kI,
            double kD,
            double kF
    ) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.kF = kF;
    }

    /**
     * Calculates controller output.
     *
     * @param measurement current measured value
     * @return controller output
     */
    public double calculate(
            double measurement
    ) {
        double error =
                setpoint - measurement;

        integral += error;

        if (Math.abs(integral) > integralLimit) {
            integral = Math.copySign(
                    integralLimit,
                    integral
            );
        }

        double derivative =
                error - previousError;

        double output =
                kP * error
                + kI * integral
                + kD * derivative
                + kF * setpoint;

        previousError = error;

        return clamp(
                output,
                minOutput,
                maxOutput
        );
    }

    /**
     * Calculates output using a new setpoint.
     */
    public double calculate(
            double measurement,
            double setpoint
    ) {
        this.setpoint = setpoint;

        return calculate(measurement);
    }

    public void setSetpoint(
            double setpoint
    ) {
        this.setpoint = setpoint;
    }

    public double getSetpoint() {
        return setpoint;
    }

    public double getError(
            double measurement
    ) {
        return setpoint - measurement;
    }

    public void setPIDF(
            double kP,
            double kI,
            double kD,
            double kF
    ) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.kF = kF;
    }

    public void setOutputLimits(
            double minOutput,
            double maxOutput
    ) {
        if (minOutput >= maxOutput) {
            throw new IllegalArgumentException(
                    "Minimum output must be less than maximum output."
            );
        }

        this.minOutput = minOutput;
        this.maxOutput = maxOutput;
    }

    public void setIntegralLimit(
            double limit
    ) {
        this.integralLimit =
                Math.abs(limit);
    }

    public void setTolerance(
            double tolerance
    ) {
        this.tolerance =
                Math.abs(tolerance);
    }

    public boolean atSetpoint(
            double measurement
    ) {
        return Math.abs(
                getError(measurement)
        ) <= tolerance;
    }

    public void reset() {
        previousError = 0.0;
        integral = 0.0;
    }

    public double getKP() {
        return kP;
    }

    public double getKI() {
        return kI;
    }

    public double getKD() {
        return kD;
    }

    public double getKF() {
        return kF;
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

package atlas.control;

public class PIDController {

    private double kP;
    private double kI;
    private double kD;

    private double setpoint;

    private double error;
    private double previousError;
    private double integral;
    private double derivative;

    private double minOutput = -1.0;
    private double maxOutput = 1.0;

    private double integralLimit = Double.POSITIVE_INFINITY;
    private double tolerance = 0.0;

    public PIDController(double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    public double calculate(double measurement) {

        error = setpoint - measurement;

        integral += error;

        if (Math.abs(integral) > integralLimit) {
            integral = Math.copySign(integralLimit, integral);
        }

        derivative = error - previousError;

        double output =
                (kP * error)
              + (kI * integral)
              + (kD * derivative);

        output = clamp(output, minOutput, maxOutput);

        previousError = error;

        return output;
    }

    public double calculate(double measurement, double setpoint) {
        this.setpoint = setpoint;
        return calculate(measurement);
    }

    public void reset() {
        error = 0.0;
        previousError = 0.0;
        integral = 0.0;
        derivative = 0.0;
    }

    public boolean atSetpoint() {
        return Math.abs(error) <= tolerance;
    }

    public void setPID(double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = Math.abs(tolerance);
    }

    public void setOutputLimits(double minOutput, double maxOutput) {
        if (minOutput >= maxOutput) {
            throw new IllegalArgumentException("Minimum output must be less than maximum output.");
        }

        this.minOutput = minOutput;
        this.maxOutput = maxOutput;
    }

    public void setIntegralLimit(double limit) {
        this.integralLimit = Math.abs(limit);
    }

    public double getSetpoint() {
        return setpoint;
    }

    public double getError() {
        return error;
    }

    public double getIntegral() {
        return integral;
    }

    public double getDerivative() {
        return derivative;
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

    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }
}

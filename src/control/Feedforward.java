package atlas.control;

/**
 * Represents a generic feedforward controller.
 */
public interface Feedforward {

    /**
     * Calculates the feedforward output
     * for a desired velocity.
     *
     * @param velocity desired velocity
     * @return feedforward output
     */
    double calculate(double velocity);

    /**
     * Calculates the feedforward output
     * for a desired velocity and acceleration.
     *
     * @param velocity desired velocity
     * @param acceleration desired acceleration
     * @return feedforward output
     */
    default double calculate(
            double velocity,
            double acceleration
    ) {
        return calculate(velocity);
    }
}

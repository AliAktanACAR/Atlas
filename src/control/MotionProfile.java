package atlas.control;

/**
 * Represents a one-dimensional motion profile.
 *
 * <p>A motion profile describes position, velocity and acceleration
 * over time while respecting motion constraints.</p>
 */
public interface MotionProfile {

    /**
     * Returns the position at the given time.
     *
     * @param time time in seconds
     * @return position
     */
    double getPosition(double time);

    /**
     * Returns the velocity at the given time.
     *
     * @param time time in seconds
     * @return velocity
     */
    double getVelocity(double time);

    /**
     * Returns the acceleration at the given time.
     *
     * @param time time in seconds
     * @return acceleration
     */
    double getAcceleration(double time);

    /**
     * Returns the total duration of the profile.
     *
     * @return profile duration in seconds
     */
    double getTotalTime();

    /**
     * Returns whether the profile has finished.
     *
     * @param time current time in seconds
     * @return true if the profile is complete
     */
    default boolean isFinished(double time) {
        return time >= getTotalTime();
    }

    /**
     * Returns the final position of the profile.
     */
    default double getFinalPosition() {
        return getPosition(getTotalTime());
    }

    /**
     * Returns the final velocity of the profile.
     */
    default double getFinalVelocity() {
        return getVelocity(getTotalTime());
    }
}

package atlas.examples;

import atlas.math.Pose2D;
import atlas.math.Rotation2D;
import atlas.math.Vector2;

public final class MathExample {

    private MathExample() {}

    public static void main(String[] args) {

        Pose2D pose = new Pose2D(
                new Vector2(24.0, 12.0),
                Rotation2D.fromDegrees(90.0)
        );

        Vector2 target =
                new Vector2(48.0, 12.0);

        System.out.println(
                "Distance: "
                + pose.getPosition().distance(target)
        );

        System.out.println(
                "Pose: " + pose
        );
    }
}

# What is Odometry?

## Introduction

Odometry is the process of estimating a robot's position and orientation by measuring the movement of its wheels and sensors over time.

In robotics, odometry is one of the most fundamental localization methods because it allows a robot to determine where it is on a field without relying on external systems such as GPS or cameras.

A robot using odometry continuously tracks its movement and updates its estimated position, commonly referred to as its **pose**.

A pose consists of:

* X Position
* Y Position
* Heading (Orientation)

Together, these values describe the robot's location and direction at any given moment.

---

## Why is Odometry Important?

Without localization, a robot has no understanding of its position relative to the environment.

Odometry enables robots to:

* Navigate autonomously
* Follow predefined paths
* Drive to target locations
* Track movement accurately
* Execute complex autonomous routines

For competitive robotics, odometry is often the foundation of advanced autonomous systems.

---

## Basic Principle

The core idea behind odometry is simple:

1. Measure wheel movement.
2. Measure robot rotation.
3. Calculate position changes.
4. Update the robot's estimated pose.

By repeating this process many times per second, the robot can maintain a continuous estimate of its location.

---

## Pose Representation

A robot's pose is commonly represented as:

```text
Pose = (x, y, θ)
```

Where:

* x = Horizontal position
* y = Vertical position
* θ = Heading angle

Example:

```text
Pose = (24.5, 36.2, 90°)
```

This indicates that the robot is located at coordinates (24.5, 36.2) and facing 90 degrees.

---

## Advantages

* Fast calculations
* High update rate
* No external infrastructure required
* Relatively simple implementation
* Widely used in robotics

---

## Limitations

Odometry is not perfect.

Small measurement errors accumulate over time and may cause the estimated position to drift from the robot's actual position.

Common error sources include:

* Wheel slip
* Uneven surfaces
* Sensor noise
* Mechanical imperfections

For this reason, odometry is often combined with other localization systems.

---

## Conclusion

Odometry is the foundation of modern robot localization. By continuously measuring movement and rotation, a robot can estimate its position and orientation in real time.

Many advanced navigation systems, including path following and autonomous navigation frameworks, rely on accurate odometry as their primary source of position information.


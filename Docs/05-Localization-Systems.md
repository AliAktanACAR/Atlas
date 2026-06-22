# 🛰️ Localization Systems

## Introduction

Before a robot can navigate, follow paths, or perform autonomous actions, it must first answer a fundamental question:

```text
Where am I?
```

The process of determining a robot's position and orientation is called **localization**.

Modern robots rarely rely on a single sensor. Instead, they combine multiple localization systems to improve accuracy and reliability.

A robot's estimated state is commonly represented as:

```math
Pose = (x,y,\theta)
```

Where:

* x = horizontal position
* y = vertical position
* θ = heading

The challenge is obtaining these values accurately in a constantly changing environment.

---

# 📍 Odometry

## Principle

Odometry estimates position by measuring wheel movement.

```text
Wheel Rotation
       ↓
 Distance Traveled
       ↓
 Position Estimate
```

Typical sensors:

* Encoders
* Tracking Wheels
* Rotation Sensors

Advantages:

✅ Fast

✅ Cheap

✅ High update frequency

✅ Easy to implement

Disadvantages:

❌ Drift accumulates over time

❌ Sensitive to wheel slip

❌ Cannot self-correct

Error growth can be approximated as:

```math
E(t)
=
E_0
+
\int_0^t e(\tau)d\tau
```

Meaning small errors continuously accumulate.

---

# 🧭 IMU (Inertial Measurement Unit)

## Principle

An IMU estimates orientation and motion using:

* Accelerometers
* Gyroscopes
* Magnetometers

Typical measurements:

```math
\omega_x,\omega_y,\omega_z
```

Angular velocity

```math
a_x,a_y,a_z
```

Linear acceleration

An IMU can provide highly accurate heading information:

```math
\theta(t)
=
\theta_0
+
\int_0^t \omega(\tau)d\tau
```

Advantages:

✅ Excellent rotational measurements

✅ Fast updates

✅ No wheel contact required

Disadvantages:

❌ Gyro drift

❌ Sensor noise

❌ Acceleration integration errors

---

# 🌍 GPS

## Principle

GPS determines location using signals from satellites.

```text
Satellite A
      \
       \
Satellite B ---- Robot
       /
      /
Satellite C
```

The receiver calculates position through trilateration.

Typical output:

```math
(x,y,z)
```

Advantages:

✅ Global positioning

✅ No wheel measurements required

✅ Long-range operation

Disadvantages:

❌ Poor indoor performance

❌ Limited precision

❌ Signal interruptions

GPS is unsuitable for most competitive robotics environments.

---

# 📷 Visual Localization

## Principle

A camera observes the environment and extracts features.

```text
Camera
   ↓
Feature Detection
   ↓
Feature Matching
   ↓
Position Estimate
```

Common techniques:

* Visual Odometry
* AprilTags
* ArUco Markers
* SLAM

Example feature tracking:

```math
Feature_A(t)
\rightarrow
Feature_A(t+\Delta t)
```

By measuring feature movement, the robot estimates its own movement.

Advantages:

✅ Can self-correct

✅ Works without wheel contact

✅ Rich environmental information

Disadvantages:

❌ Computationally expensive

❌ Sensitive to lighting

❌ Requires image processing

---

# 📡 LiDAR Localization

## Principle

LiDAR measures distance using laser pulses.

```text
Laser Pulse
      ↓
Object Reflection
      ↓
Distance Measurement
```

Distance calculation:

```math
d
=
\frac{ct}{2}
```

Where:

* c = speed of light
* t = round-trip travel time

LiDAR generates a point cloud:

```math
P=
\{p_1,p_2,p_3,...,p_n\}
```

Advantages:

✅ Extremely accurate

✅ Excellent obstacle detection

✅ Reliable mapping

Disadvantages:

❌ Expensive

❌ High computational cost

❌ Rare in educational robotics

---

# 🗺️ SLAM

## Simultaneous Localization and Mapping

One of the most advanced localization techniques.

The robot simultaneously:

1. Builds a map
2. Determines its position

```text
Unknown World
      ↓
Create Map
      ↓
Locate Robot
      ↓
Improve Map
```

Mathematically:

```math
P(X_t,M|Z_{1:t},U_{1:t})
```

Where:

* X = robot state
* M = map
* Z = sensor observations
* U = control inputs

SLAM is widely used in:

* Autonomous vehicles
* Research robotics
* Exploration robots

---

# 🔗 Sensor Fusion

No localization system is perfect.

Modern robots combine multiple systems.

Example:

```text
Odometry
     +
 IMU
     +
 Camera
     +
 LiDAR
     ↓
 Sensor Fusion
     ↓
 Better Localization
```

The goal is to reduce uncertainty.

A simplified estimate:

```math
Pose_{final}
=
w_1Pose_{odom}
+
w_2Pose_{imu}
+
w_3Pose_{vision}
```

Where:

```math
w_1+w_2+w_3=1
```

More advanced systems use:

* Kalman Filters
* Extended Kalman Filters
* Particle Filters

---

# ⚖️ Comparison

| System   | Accuracy  | Cost   | Speed     | Drift    |
| -------- | --------- | ------ | --------- | -------- |
| Odometry | Medium    | Low    | Very High | High     |
| IMU      | Medium    | Low    | Very High | Medium   |
| GPS      | Medium    | Medium | High      | Low      |
| Vision   | High      | Medium | Medium    | Low      |
| LiDAR    | Very High | High   | Medium    | Very Low |

---

# 🎯 Conclusion

Localization is not a single technology but a collection of techniques used to estimate a robot's position.

Odometry provides fast and simple localization.

IMUs provide orientation.

GPS provides global position.

Vision and LiDAR provide environmental awareness.

Modern autonomous systems achieve the best results by combining multiple localization methods through sensor fusion.

Understanding these systems is essential for developing advanced autonomous robots and serves as the foundation for path planning, navigation, and motion control.


# 🧮 Math Behind Atlas

## Introduction

At first glance, robotics appears to be a field dominated by motors, sensors, and hardware.

In reality, modern robotics is fundamentally a branch of applied mathematics.

Every major subsystem inside Atlas is built upon mathematical principles.

```text
Localization
      ↓
Geometry
      ↓
Linear Algebra
      ↓
Trigonometry
      ↓
Calculus
      ↓
Control Theory
```

Without mathematics, a robot cannot determine:

* Where it is
* How fast it is moving
* How much it should turn
* Which path it should follow

This document provides an overview of the mathematical concepts used throughout Atlas.

---

# 📐 Coordinate Systems

Everything begins with coordinates.

A robot's pose is represented as:

```math
Pose=(x,y,\theta)
```

Where:

```math
x
```

represents horizontal position,

```math
y
```

represents vertical position,

and

```math
\theta
```

represents heading.

Example:

```math
Pose=(24,18,90^\circ)
```

The robot is located at:

```text
X = 24
Y = 18
```

while facing:

```text
90°
```

---

# 📏 Distance Formula

Robots constantly calculate distances.

Suppose:

```math
P_1=(x_1,y_1)
```

and

```math
P_2=(x_2,y_2)
```

The distance between them:

```math
d=
\sqrt{
(x_2-x_1)^2
+
(y_2-y_1)^2
}
```

Example:

```math
P_1=(0,0)
```

```math
P_2=(3,4)
```

```math
d=5
```

This equation appears throughout:

* Odometry
* Path Planning
* Pure Pursuit
* Localization

---

# 🔺 Trigonometry

Robots rarely move perfectly along the X or Y axis.

Movement is often decomposed into components.

Given:

```math
d
```

and

```math
\theta
```

we compute:

```math
x=d\cos\theta
```

```math
y=d\sin\theta
```

Example:

```math
d=20
```

```math
\theta=45^\circ
```

Then:

```math
x=14.14
```

```math
y=14.14
```

This process converts heading information into field movement.

---

# 🧭 Angle Mathematics

Heading calculations appear constantly.

Conversion:

```math
180^\circ=\pi\ rad
```

General formula:

```math
Radians
=
Degrees
\times
\frac{\pi}{180}
```

Example:

```math
90^\circ
=
\frac{\pi}{2}
```

Most robotics libraries internally use radians.

---

# ➡️ Vectors

A vector contains both magnitude and direction.

Example:

```math
\vec v
=
\begin{bmatrix}
3\\
4
\end{bmatrix}
```

Magnitude:

```math
|\vec v|
=
\sqrt{
3^2+4^2
}
=
5
```

Vectors are used extensively in:

* Motion planning
* Localization
* Computer Vision
* Sensor Fusion

---

# 🔄 Rotation Matrices

One of the most important concepts in robotics.

A rotation matrix rotates coordinates.

```math
R(\theta)
=
\begin{bmatrix}
\cos\theta & -\sin\theta\\
\sin\theta & \cos\theta
\end{bmatrix}
```

Transforming a point:

```math
P'
=
R(\theta)P
```

This allows Atlas to convert:

```text
Robot Coordinates
        ↓
Field Coordinates
```

and vice versa.

---

# 🛞 Differential Drive Kinematics

Most robots use differential drive systems.

Linear velocity:

```math
v
=
\frac{v_L+v_R}{2}
```

Angular velocity:

```math
\omega
=
\frac{v_R-v_L}{W}
```

Where:

```math
W
```

is track width.

These equations determine how wheel motion affects robot movement.

---

# ⚙️ Calculus

Calculus describes changing systems.

Velocity:

```math
v
=
\frac{dx}{dt}
```

Acceleration:

```math
a
=
\frac{dv}{dt}
```

Position:

```math
x
=
\int v\,dt
```

These relationships appear throughout robotics.

---

# 📈 Numerical Integration

Robots cannot solve continuous equations perfectly.

Instead:

```math
x_{new}
=
x_{old}
+
v\Delta t
```

This process is called numerical integration.

Odometry systems repeatedly apply this equation hundreds of times per second.

---

# 🎯 PID Mathematics

PID Control is based on:

```math
u(t)
=
K_Pe(t)
+
K_I\int e(t)dt
+
K_D\frac{de}{dt}
```

Where:

```math
e(t)
```

represents error.

PID combines:

* Present error
* Past error
* Future trend

to produce control output.

---

# 🔗 Probability and Statistics

Sensor Fusion introduces uncertainty.

Measurements are often modeled:

```math
x
\sim
N(\mu,\sigma^2)
```

Where:

```math
\mu
```

is the mean,

and

```math
\sigma^2
```

is variance.

This allows robots to reason about noisy sensors.

---

# 📊 Covariance Matrices

Sensor uncertainty is represented:

```math
P=
\begin{bmatrix}
\sigma_x^2 & 0 & 0\\
0 & \sigma_y^2 & 0\\
0 & 0 & \sigma_\theta^2
\end{bmatrix}
```

Covariance matrices are fundamental to:

* Kalman Filters
* Sensor Fusion
* State Estimation

---

# 🗺️ Curvature

Pure Pursuit uses curvature.

```math
\kappa
=
\frac{2y}{L_d^2}
```

Where:

```math
L_d
```

is lookahead distance.

Radius:

```math
R
=
\frac{1}{\kappa}
```

Large curvature:

```text
Sharp Turn
```

Small curvature:

```text
Gentle Turn
```

---

# 🌳 Graph Theory

Path Planning frequently models environments as graphs.

```text
A──B──C

│  │  │

D──E──F
```

Algorithms such as:

* Dijkstra
* A*
* RRT

operate on these structures.

Graph theory enables robots to find routes through complex environments.

---

# 🎓 Mathematics Used In Atlas

| Topic          | Application       |
| -------------- | ----------------- |
| Geometry       | Localization      |
| Trigonometry   | Position Updates  |
| Linear Algebra | Transformations   |
| Calculus       | Motion Estimation |
| Probability    | Sensor Fusion     |
| Statistics     | Noise Modeling    |
| Control Theory | PID               |
| Graph Theory   | Path Planning     |
| Kinematics     | Robot Motion      |

---

# 🚀 Conclusion

Atlas is more than a collection of robotics algorithms.

It is a practical application of mathematics to autonomous systems.

Every position estimate, every path calculation, every control loop, and every navigation decision ultimately relies on mathematical principles.

Understanding these concepts provides the foundation necessary to build accurate, reliable, and intelligent robotic systems.


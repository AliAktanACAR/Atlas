# ⚙️ How Odometry Works

## The Mathematical Foundation of Robot Localization

Modern odometry is built upon a combination of geometry, trigonometry, linear algebra, and kinematics.

The purpose of an odometry system is to estimate the pose of a robot:

```text
Pose = (x, y, θ)
```

Where:

* x = position along the X axis
* y = position along the Y axis
* θ = robot heading

The challenge is that the robot never directly measures x or y.

Instead, it measures wheel movement.

The entire objective of odometry is therefore:

```text
Wheel Movement
        ↓
 Local Motion
        ↓
 Global Motion
        ↓
 Updated Pose
```

---

# 1. Tracking Wheel Measurements

A standard three-wheel odometry system consists of:

```text
              Forward

                 ↑

                 |

        ΔL       |       ΔR

      ●----------●----------●

                 |

                 |

                ΔS
```

The tracking wheels provide three independent measurements:

```math
\Delta L
```

Left wheel displacement

```math
\Delta R
```

Right wheel displacement

```math
\Delta S
```

Lateral wheel displacement

These values are collected every update cycle.

---

# 2. Deriving Robot Rotation

Consider a robot rotating around an instantaneous center of curvature.

During rotation:

```text
Left Wheel  → Longer Arc

Right Wheel → Shorter Arc
```

Using the arc length equation:

```math
s=r\theta
```

We can express both wheel paths as:

```math
\Delta L=(r+s_L)\Delta\theta
```

```math
\Delta R=(r-s_R)\Delta\theta
```

Subtracting the equations:

```math
\Delta L-\Delta R
=
(s_L+s_R)\Delta\theta
```

Rearranging:

```math
\boxed{
\Delta\theta=
\frac{\Delta L-\Delta R}
{s_L+s_R}
}
```

This equation is one of the most important relationships in wheel odometry.

It converts encoder measurements directly into rotational motion.

---

# 3. Arc Approximation

Many beginners assume that robots move in straight lines.

They do not.

Every movement can be approximated as a tiny arc.

```text
          .
       .     .
     .         .
   .             .
 ●-----------------●
```

The smaller the update interval:

```math
\Delta t \rightarrow 0
```

the more accurate this approximation becomes.

This concept is the basis of continuous pose estimation.

---

# 4. Local Displacement Vector

Once rotation has been calculated, we determine translation.

The robot first computes movement in its own coordinate frame.

```math
\Delta d_l=
\begin{bmatrix}
\Delta x_l \\
\Delta y_l
\end{bmatrix}
```

This vector describes movement relative to the robot itself.

Not the field.

Not the world.

Only the robot.

---

# 5. Rotation Matrices

Local coordinates must be transformed into global coordinates.

For this we use a rotation matrix:

```math
R(\theta)
=
\begin{bmatrix}
\cos\theta & -\sin\theta\\
\sin\theta & \cos\theta
\end{bmatrix}
```

Applying the transformation:

```math
\Delta d_g
=
R(\theta)
\Delta d_l
```

Expanding:

```math
\Delta x_g
=
\Delta x_l\cos\theta
-
\Delta y_l\sin\theta
```

```math
\Delta y_g
=
\Delta x_l\sin\theta
+
\Delta y_l\cos\theta
```

The robot now knows how its local movement affects its position on the field.

---

# 6. Pose Integration

The new pose is obtained through integration.

```math
x_{new}
=
x_{old}
+
\Delta x_g
```

```math
y_{new}
=
y_{old}
+
\Delta y_g
```

```math
\theta_{new}
=
\theta_{old}
+
\Delta\theta
```

Or in matrix form:

```math
\begin{bmatrix}
x\\
y\\
\theta
\end{bmatrix}_{new}
=
\begin{bmatrix}
x\\
y\\
\theta
\end{bmatrix}_{old}
+
\begin{bmatrix}
\Delta x\\
\Delta y\\
\Delta\theta
\end{bmatrix}
```

---

# 7. Sources of Error

Real-world systems are never perfect.

Errors arise from:

* Wheel slip
* Sensor quantization
* Mechanical backlash
* Bearing friction
* Uneven surfaces
* Encoder noise

The accumulated error can be represented as:

```math
E_{total}
=
E_{encoder}
+
E_{slip}
+
E_{mechanical}
+
E_{sensor}
```

Over time:

```math
E_{total}
\propto
t
```

which explains why odometry drift increases during long runs.

---

# Conclusion

Although odometry appears to be a simple encoder-based system, it is fundamentally a real-time localization algorithm built upon:

* Geometry
* Trigonometry
* Matrix Transformations
* Kinematics
* Numerical Integration

Every update cycle reconstructs the robot's position from sensor measurements, allowing autonomous systems to understand where they are and where they should move next.


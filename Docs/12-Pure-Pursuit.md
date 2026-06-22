# 🎯 Pure Pursuit

## Introduction

Once a robot knows where it is and can control its motion using PID, a new challenge emerges:

```text
How can the robot follow an entire path?
```

Driving to a single point is relatively simple.

Following a smooth path through multiple points is significantly more difficult.

Consider the following route:

```text
Start ●────────●────────● Goal
```

A naïve solution would be:

```text
Drive To Point A
      ↓
Drive To Point B
      ↓
Drive To Point C
```

However, this often produces:

* Sharp turns
* Sudden acceleration changes
* Unnatural movement
* Longer travel times

Pure Pursuit was developed to solve this problem.

---

# What Is Pure Pursuit?

Pure Pursuit is a path-following algorithm used in robotics and autonomous vehicles.

Instead of driving directly to the next waypoint, the robot continuously selects a target point ahead of its current position.

```text
Robot ●──────○ Target Point
               \
                \
                 Path
```

The robot "chases" this target point.

As the robot moves, the target point moves as well.

This creates smooth and natural path following.

---

# Core Idea

The Pure Pursuit algorithm repeatedly performs:

```text
Current Position
        ↓
Find Lookahead Point
        ↓
Calculate Curvature
        ↓
Generate Motion
        ↓
Repeat
```

The robot never attempts to reach the final goal directly.

Instead, it continuously follows a moving target.

---

# Path Representation

A path is typically represented as a series of waypoints.

```text
P₀ → P₁ → P₂ → P₃ → P₄
```

Each waypoint can be written as:

```math
P_i=(x_i,y_i)
```

Example:

```math
P_1=(10,5)
```

```math
P_2=(30,15)
```

```math
P_3=(50,40)
```

The complete path becomes:

```math
Path=
\{P_1,P_2,P_3,\dots,P_n\}
```

---

# Lookahead Distance

The most important parameter in Pure Pursuit is the lookahead distance.

```math
L_d
```

This distance determines how far ahead the robot searches for a target.

```text
Robot ●------○

      Ld
```

The target point must satisfy:

```math
Distance(Robot,Target)=L_d
```

This means the robot always aims for a point located exactly one lookahead distance ahead.

---

# Finding The Lookahead Point

Suppose the robot position is:

```math
R=(x_r,y_r)
```

A circle is drawn around the robot.

```math
(x-x_r)^2+(y-y_r)^2=L_d^2
```

The path is then intersected with this circle.

```text
          Path

     -----------○

          /
         /
        /

      ● Robot
```

The intersection becomes the lookahead point.

```math
Target=(x_t,y_t)
```

---

# Transforming Into Robot Coordinates

The target point initially exists in field coordinates.

To simplify calculations, it is transformed into robot coordinates.

Robot pose:

```math
(x_r,y_r,\theta)
```

Transformation:

```math
x'
=
(x_t-x_r)\cos\theta
+
(y_t-y_r)\sin\theta
```

```math
y'
=
-(x_t-x_r)\sin\theta
+
(y_t-y_r)\cos\theta
```

The target now exists relative to the robot.

---

# Curvature Calculation

Pure Pursuit computes a curvature value.

Curvature describes how sharply the robot should turn.

```math
\kappa
=
\frac{2y'}{L_d^2}
```

Where:

* κ = curvature
* y' = lateral offset
* Ld = lookahead distance

Interpretation:

```text
Large Curvature
      ↓
Sharp Turn
```

```text
Small Curvature
      ↓
Gentle Turn
```

---

# Radius Of Curvature

Curvature and turning radius are related.

```math
R=\frac{1}{\kappa}
```

Example:

```math
\kappa=0.2
```

```math
R=5
```

A larger radius produces smoother motion.

---

# Differential Drive Example

Suppose:

```math
v=40
```

robot velocity.

Wheel velocities become:

```math
v_L
=
v
\left(
1-\frac{W\kappa}{2}
\right)
```

```math
v_R
=
v
\left(
1+\frac{W\kappa}{2}
\right)
```

Where:

* W = track width

These values are sent to the drivetrain.

---

# Why Pure Pursuit Works

Instead of forcing the robot to reach exact waypoints:

```text
Waypoint
    ↓
Waypoint
    ↓
Waypoint
```

Pure Pursuit creates:

```text
Smooth Curve
```

The robot continuously adjusts its trajectory.

This reduces:

* Oscillations
* Abrupt turns
* Path discontinuities

---

# Lookahead Tuning

Choosing:

```math
L_d
```

is critical.

### Small Lookahead

```math
L_d \downarrow
```

Advantages:

✅ High accuracy

Disadvantages:

❌ Oscillation

❌ Aggressive steering

---

### Large Lookahead

```math
L_d \uparrow
```

Advantages:

✅ Smooth motion

✅ Stable control

Disadvantages:

❌ Corner cutting

❌ Reduced precision

---

# Pure Pursuit And Odometry

Pure Pursuit depends heavily on localization.

The algorithm continuously requires:

```math
Pose=(x,y,\theta)
```

Without accurate odometry:

```text
Wrong Position
      ↓
Wrong Lookahead Point
      ↓
Wrong Curvature
      ↓
Poor Path Following
```

This is why path following and localization are inseparable.

---

# Pure Pursuit In Competitive Robotics

Applications include:

### Autonomous Navigation

```text
Start
  ↓
Follow Path
  ↓
Goal
```

### Multi-Objective Routines

```text
Score
  ↓
Collect
  ↓
Score
  ↓
Park
```

### Dynamic Motion

```text
Robot
   ↓
Smooth Curves
   ↓
Higher Efficiency
```

Many advanced VEX, FTC, and FRC teams use Pure Pursuit as a foundation for autonomous path following.

---

# Advantages

✅ Smooth trajectories

✅ Continuous steering

✅ Easy implementation

✅ Computationally efficient

✅ Works well with odometry

---

# Limitations

❌ Requires accurate localization

❌ Requires path generation

❌ Corner cutting may occur

❌ Not globally optimal

---

# Comparison

| Method             | Smoothness | Complexity | Accuracy |
| ------------------ | ---------- | ---------- | -------- |
| Drive To Point     | Low        | Very Low   | Medium   |
| Waypoint Following | Medium     | Low        | Medium   |
| Pure Pursuit       | High       | Medium     | High     |

---

# Conclusion

Pure Pursuit is one of the most widely used path-following algorithms in robotics.

By continuously selecting a lookahead point and steering toward it, the robot follows smooth trajectories instead of rigid waypoint-to-waypoint motion.

Combined with odometry, PID control, and accurate localization, Pure Pursuit provides a powerful framework for autonomous navigation and serves as the foundation for many modern robotic path-following systems.


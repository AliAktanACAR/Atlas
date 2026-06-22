# 🛞 Tracking Wheels

## Introduction

Tracking wheels are specialized passive wheels used exclusively for localization.

Unlike drivetrain wheels, tracking wheels do not generate motion.

Their only purpose is to measure motion as accurately as possible.

```text
Drive Wheels
     ↓
Move Robot

Tracking Wheels
     ↓
Measure Motion
```

A tracking wheel system allows a robot to estimate its position with significantly greater accuracy than relying solely on drivetrain motor encoders.

---

# Why Not Use Drive Wheels?

Many beginners attempt to calculate odometry using only drivetrain encoders.

While this may work under ideal conditions, real robots experience:

* Wheel slip
* Uneven terrain
* Mechanical flex
* Impacts with objects
* Rapid acceleration

Consider a drivetrain wheel spinning while the robot is pinned against a wall.

```text
Motor Power = 100%

Wheel Rotation = Yes

Robot Movement = No
```

The encoder reports movement even though the robot has not moved.

This introduces localization error.

Tracking wheels are designed to minimize these effects.

---

# Dead Wheels

Tracking wheels are often called:

```text
Dead Wheels
```

because they are not connected to a motor.

A dead wheel spins freely as the robot moves.

```text
      Encoder
         │
         ▼

     ┌───────┐
     │ Wheel │
     └───────┘

         ▲
         │

      Floor
```

The encoder measures wheel rotation and converts it into linear displacement.

---

# Why Omni Wheels?

Most tracking systems use omni wheels.

```text
Standard Wheel ❌

Omni Wheel ✅
```

An omni wheel contains small rollers around its circumference.

```text
      /////////
    ///     ///
   ///     ///
    ///     ///
      /////////
```

Advantages:

✅ Low friction

✅ Reduced scrubbing

✅ Better measurement accuracy

✅ Less lateral resistance

Because localization accuracy is critical, omni wheels have become the industry standard for tracking systems.

---

# Measuring Distance

Each encoder reports wheel rotation.

Distance traveled can be calculated:

```math
Distance
=
Rotation
\times
Circumference
```

Wheel circumference:

```math
C = 2\pi r
```

Therefore:

```math
d
=
\frac{\theta}{360}
\times
2\pi r
```

Where:

* d = distance traveled
* θ = wheel rotation in degrees
* r = wheel radius

This conversion is performed every update cycle.

---

# Two Wheel Odometry

The simplest practical odometry system consists of:

```text
       Forward

          ↑

          │

      Vertical

          ●

          │

──────── Robot ────────

          │

          ●

     Horizontal
```

Sensors:

* Vertical tracking wheel
* Horizontal tracking wheel
* IMU

Measurements:

```text
Vertical Wheel
     ↓
Forward Motion

Horizontal Wheel
     ↓
Sideways Motion

IMU
     ↓
Heading
```

Advantages:

✅ Lightweight

✅ Simple

✅ Easy to implement

Disadvantages:

❌ Dependent on IMU accuracy

❌ Heading errors affect position estimation

This configuration is extremely popular in VEX V5.

---

# Three Wheel Odometry

Three-wheel odometry removes the dependence on IMU heading measurements.

Typical configuration:

```text
          Forward

             ↑

   Left ●────┼────● Right

             │

             │

             ●

            Back
```

Measurements:

```text
Left Wheel
Right Wheel
Back Wheel
```

The left and right wheels determine rotation.

The back wheel measures lateral movement.

---

# Tracking Center

One of the most important concepts in odometry is the tracking center.

```text
        Robot

   ┌─────────────┐
   │             │
   │      ●      │
   │             │
   └─────────────┘

     Tracking Center
```

All position calculations are performed relative to this point.

The tracking center does not need to be a physical component.

It is simply a reference location used by the mathematics.

Most teams choose:

* Robot center
* Center of rotation
* Geometric center

---

# Wheel Offsets

Tracking wheels are positioned at specific distances from the tracking center.

```text
sL = Left Wheel Offset

sR = Right Wheel Offset

sS = Side Wheel Offset
```

These distances are critical.

Even small measurement errors can produce significant localization drift.

Example:

```text
Actual Offset  = 7.00 in

Configured Offset = 7.25 in
```

The resulting rotational calculations will be incorrect.

Precise measurement is therefore essential.

---

# The Independence Principle

One of the most surprising results in odometry theory is that a tracking wheel can move along its measurement axis without affecting the mathematics.

```text
Valid

●────────────●────────────●
```

As long as the wheel remains on the same measurement axis, the localization equations remain unchanged.

Only the perpendicular distance to the tracking center matters.

This property gives engineers significant flexibility when designing tracking systems.

---

# Sources of Tracking Error

Even the best tracking systems are imperfect.

Common error sources include:

* Wheel compression
* Bearing friction
* Loose mounting hardware
* Bent shafts
* Encoder quantization
* Surface irregularities

Total localization error can be approximated:

```math
E_{total}
=
E_{wheel}
+
E_{encoder}
+
E_{mounting}
+
E_{surface}
```

Reducing these sources is often more important than improving software.

---

# Design Recommendations

A high-quality tracking system should:

✅ Use omni wheels

✅ Minimize friction

✅ Use rigid mounts

✅ Measure offsets precisely

✅ Avoid wheel slip

✅ Update odometry frequently

Many successful competitive robotics teams dedicate significant engineering effort to tracking wheel design because localization accuracy directly impacts autonomous performance.

---

# Conclusion

Tracking wheels form the foundation of modern wheel-based odometry systems.

Although they appear mechanically simple, their placement, geometry, and measurement accuracy have a direct impact on localization performance.

A well-designed tracking system transforms raw wheel rotations into reliable position estimates, enabling advanced autonomous navigation and motion control algorithms.


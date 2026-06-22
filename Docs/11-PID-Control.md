# 🎯 PID Control

## Introduction

Knowing a robot's position is only half of the problem.

The second challenge is controlling the robot.

Suppose a robot is located at:

```math
x=0
```

and we want it to reach:

```math
x=100
```

How should the motors be controlled?

A simple solution might be:

```text
Motor Power = 100%
```

However, this approach creates problems:

* Overshoot
* Oscillation
* Slow response
* Inaccuracy

Modern robotics solves this problem using feedback control systems.

The most common controller is:

# PID Control

---

# What Is Feedback?

A feedback system continuously compares:

```text
Desired State
      ↓
Current State
      ↓
Error
```

The controller uses this error to generate a correction.

Mathematically:

```math
Error
=
Target
-
Current
```

Example:

```math
Target=100
```

```math
Current=80
```

```math
Error=20
```

The robot still needs to move forward.

---

# The PID Equation

The complete PID equation is:

```math
u(t)
=
K_Pe(t)
+
K_I\int e(t)dt
+
K_D\frac{de(t)}{dt}
```

Where:

* u(t) = controller output
* e(t) = error
* KP = proportional gain
* KI = integral gain
* KD = derivative gain

This single equation forms the foundation of countless robotic control systems.

---

# Understanding The Error

Everything in PID begins with error.

```math
e(t)
=
r(t)-y(t)
```

Where:

* r(t) = target value
* y(t) = measured value

The controller attempts to drive:

```math
e(t)
\rightarrow
0
```

A perfect controller would eventually produce:

```math
Target
=
Current
```

and therefore:

```math
Error=0
```

---

# Proportional Control (P)

The proportional term responds directly to error.

```math
P=K_Pe
```

Example:

```math
K_P=2
```

```math
Error=10
```

Output:

```math
P=20
```

If the error doubles:

```math
Error=20
```

Output:

```math
P=40
```

The larger the error, the stronger the correction.

### Advantages

✅ Fast response

✅ Simple implementation

### Problems

❌ Steady-state error

❌ Oscillations

❌ Overshoot

---

# Integral Control (I)

The integral term accumulates past errors.

```math
I
=
K_I
\int e(t)dt
```

Suppose a robot remains:

```math
2in
```

away from the target.

The proportional term may become too small to eliminate the remaining error.

The integral term solves this problem by accumulating error over time.

```text
Error
  ↓
Accumulation
  ↓
More Correction
```

Advantages:

✅ Eliminates steady-state error

Disadvantages:

❌ Overshoot

❌ Integral windup

---

# Integral Windup

One of the most common PID problems is integral windup.

Imagine:

```text
Robot Against Wall

Target Not Reached

Error Continues
```

The integral term keeps growing.

```math
\int e(t)dt
\rightarrow
\infty
```

Eventually:

```math
I
\gg
P
```

When the robot finally becomes free, it may surge violently.

Most modern PID implementations limit the integral term.

---

# Derivative Control (D)

The derivative term predicts future behavior.

```math
D
=
K_D
\frac{de}{dt}
```

Instead of measuring error itself, it measures:

```text
How Fast Error Is Changing
```

Example:

```math
Error:
50 → 30 → 10
```

The derivative detects rapid improvement.

As a result:

```math
D<0
```

and the controller begins slowing down.

Advantages:

✅ Reduces overshoot

✅ Improves stability

✅ Dampens oscillations

---

# Complete PID Behavior

The three terms work together:

```text
P → React

I → Correct

D → Predict
```

or

```text
P → Present

I → Past

D → Future
```

This interpretation is often used in control theory.

---

# Example Calculation

Suppose:

```math
Error=10
```

```math
K_P=2
```

```math
K_I=0.5
```

```math
K_D=1
```

Integral:

```math
\int e(t)dt
=
8
```

Derivative:

```math
\frac{de}{dt}
=
-2
```

Controller output:

```math
u
=
(2)(10)
+
(0.5)(8)
+
(1)(-2)
```

```math
u
=
20+4-2
```

```math
u=22
```

The controller sends an output of 22 units.

---

# PID In Robotics

PID controllers appear everywhere.

### Drive Straight

```text
Target Distance
       ↓
PID
       ↓
Motor Output
```

### Turn To Angle

```text
Target Heading
        ↓
PID
        ↓
Turn Power
```

### Arm Control

```text
Target Position
        ↓
PID
        ↓
Motor Voltage
```

### Flywheel Velocity

```text
Target RPM
      ↓
PID
      ↓
Motor Output
```

---

# PID Tuning

Selecting gains is known as tuning.

```math
K_P
```

Too High:

❌ Oscillation

Too Low:

❌ Slow response

---

```math
K_I
```

Too High:

❌ Overshoot

Too Low:

❌ Residual error

---

```math
K_D
```

Too High:

❌ Noisy output

Too Low:

❌ Poor damping

Finding the correct balance is one of the most important tasks in control engineering.

---

# PID and Odometry

In Atlas, odometry and PID work together.

```text
Odometry
     ↓
Current Pose
     ↓
PID Controller
     ↓
Motor Commands
```

Odometry answers:

```text
Where am I?
```

PID answers:

```text
How do I reach my target?
```

Together they form the foundation of autonomous navigation.

---

# Advantages

✅ Simple

✅ Fast

✅ Reliable

✅ Easy to implement

✅ Widely used

---

# Limitations

❌ Requires tuning

❌ Not optimal

❌ Struggles with highly nonlinear systems

❌ Sensitive to noise

---

# Conclusion

PID Control is one of the most important algorithms in robotics and control engineering.

By combining proportional, integral, and derivative terms, a PID controller can accurately regulate position, velocity, heading, and countless other system variables.

Although more advanced controllers exist, PID remains the most widely used control algorithm in modern robotics due to its simplicity, effectiveness, and versatility.


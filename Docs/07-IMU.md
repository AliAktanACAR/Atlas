# 🧭 IMU (Inertial Measurement Unit)

## Introduction

An Inertial Measurement Unit (IMU) is an electronic device used to measure a robot's motion and orientation.

Modern robotics systems rely heavily on IMUs because they provide information that wheel encoders alone cannot measure accurately.

An IMU allows a robot to estimate:

* Orientation
* Angular velocity
* Linear acceleration
* Rotational motion

In localization systems, the IMU is often responsible for determining the robot's heading.

```math id="g5zyjw"
\theta
```

Without reliable heading estimation, accurate navigation becomes extremely difficult.

---

# What Does An IMU Contain?

A modern IMU is typically composed of multiple sensors.

```text id="u9o4q8"
      IMU

       │

 ┌─────┼─────┐

 ▼     ▼     ▼

Gyro Accel Magnetometer
```

Each sensor contributes different information.

---

# Gyroscope

The gyroscope measures angular velocity.

```math id="c4zhmy"
\omega
=
\frac{d\theta}{dt}
```

Where:

* ω = angular velocity
* θ = orientation

Units:

```text id="r8vzdc"
Degrees/Second

or

Radians/Second
```

Example:

```math id="1m59z2"
\omega
=
90^\circ/s
```

After:

```math id="9du23o"
t=2s
```

The robot rotates:

```math id="5nhg6y"
\theta
=
\omega t
=
180^\circ
```

The gyroscope is the primary sensor used for robot heading estimation.

---

# Accelerometer

The accelerometer measures linear acceleration.

```math id="edx5v6"
a
=
\frac{dv}{dt}
```

Units:

```text id="zw4tbg"
m/s²
```

An accelerometer detects:

* Forward acceleration
* Sideways acceleration
* Vertical acceleration

Typical output:

```math id="h3c55h"
(a_x,a_y,a_z)
```

Example:

```math id="vmmp8v"
(1.2,0.3,9.81)
```

The value:

```math id="vjw3n6"
9.81
```

represents Earth's gravitational acceleration.

---

# Magnetometer

Some IMUs also include a magnetometer.

A magnetometer measures Earth's magnetic field.

```text id="70lm8k"
North
  ↑

West ← → East

  ↓

South
```

This allows the robot to estimate compass direction.

Advantages:

✅ Absolute heading reference

Disadvantages:

❌ Sensitive to motors

❌ Sensitive to electrical noise

❌ Sensitive to metal structures

For competitive robotics, magnetometers are rarely used.

---

# Determining Heading

The primary reason odometry systems use IMUs is heading estimation.

Suppose a robot begins facing:

```math id="6sppr6"
0^\circ
```

The gyroscope measures:

```math id="zl3i54"
90^\circ/s
```

for:

```math id="w86vpi"
3s
```

Then:

```math id="lm35ti"
\theta
=
0
+
90\times3
=
270^\circ
```

The robot is now facing:

```math id="rk9mzo"
270^\circ
```

This process is known as integration.

---

# Angular Integration

Heading is obtained by integrating angular velocity.

```math id="up4bj8"
\theta(t)
=
\theta_0
+
\int_0^t \omega(\tau)d\tau
```

Where:

* θ₀ = initial heading
* ω = angular velocity

This equation is fundamental to IMU localization.

---

# Why IMUs Drift

IMUs are not perfect.

Every sensor measurement contains noise.

Suppose the real value is:

```math id="jlwm0z"
90^\circ/s
```

but the sensor reports:

```math id="zyi0bx"
90.2^\circ/s
```

The error:

```math id="vxfcnr"
0.2^\circ/s
```

appears insignificant.

However after:

```math id="l7xtqj"
60s
```

the accumulated error becomes:

```math id="6ahf07"
12^\circ
```

This phenomenon is called drift.

---

# Accelerometer Drift

Position estimation from accelerometers is even more difficult.

Velocity:

```math id="x6hll4"
v
=
\int a(t)dt
```

Position:

```math id="22x1dk"
x
=
\int v(t)dt
```

Combining:

```math id="mgb9kh"
x
=
\int
\int
a(t)
\,dt\,dt
```

This double integration amplifies noise dramatically.

Even tiny sensor errors can produce large position errors.

This is why robots rarely rely solely on accelerometers for localization.

---

# IMU and Odometry

One of the most common localization systems combines:

```text id="2cz36s"
Tracking Wheels
      +
      IMU
```

Tracking wheels measure:

```math id="qmnkcg"
\Delta x
```

```math id="mkv8y2"
\Delta y
```

The IMU measures:

```math id="w9a4t1"
\Delta\theta
```

Together they form:

```math id="5vhq6l"
Pose
=
(x,y,\theta)
```

This approach is widely used in:

* VEX V5
* FTC
* FRC

because it provides an excellent balance between simplicity and accuracy.

---

# Sensor Fusion

Modern systems rarely trust a single sensor.

Instead they combine:

```text id="l5gw0v"
Odometry
    +
 IMU
    +
 Vision
```

to produce a better estimate.

A simplified fusion model:

```math id="5lh7qd"
Pose_{final}
=
w_1Pose_{odom}
+
w_2Pose_{imu}
```

Where:

```math id="gv6c8u"
w_1+w_2=1
```

Real systems often use:

* Kalman Filters
* Extended Kalman Filters
* Particle Filters

to perform this process.

---

# IMU in Competitive Robotics

In VEX and FRC, IMUs are commonly used for:

### Turn To Angle

```math id="3fef9h"
Target=90^\circ
```

### Heading Hold

```math id="fxm8pf"
\theta_{target}
=
\theta_{current}
```

### Two Wheel Odometry

```text id="s9iw7y"
Vertical Wheel

Horizontal Wheel

IMU
```

### Autonomous Navigation

```text id="jkw1cs"
Current Pose
      ↓
Calculate Error
      ↓
Drive To Target
```

Without accurate heading information, these systems become unreliable.

---

# Advantages and Limitations

## Advantages

✅ High update frequency

✅ Excellent rotational measurements

✅ Lightweight

✅ Easy integration

✅ Widely available

---

## Limitations

❌ Drift

❌ Sensor noise

❌ Temperature sensitivity

❌ Integration errors

❌ Cannot provide absolute position

---

# Conclusion

The IMU is one of the most important sensors in modern robotics.

By measuring rotational and linear motion, it provides critical information about robot orientation and movement.

Although IMUs suffer from drift and noise, they remain an essential component of localization systems and are commonly combined with odometry, vision, and other sensors to achieve reliable autonomous navigation.


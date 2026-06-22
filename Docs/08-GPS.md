# 🌍 GPS (Global Positioning System)

## Introduction

The Global Positioning System (GPS) is a satellite-based navigation system capable of determining the position, velocity, and time of a receiver anywhere on Earth.

GPS is one of the most widely used localization technologies in modern engineering and serves as the foundation of navigation systems used in:

* Cars
* Aircraft
* Ships
* Smartphones
* Autonomous Vehicles
* Agricultural Machinery
* Surveying Equipment

Unlike odometry, GPS does not estimate position from movement.

Instead, it determines position using signals transmitted by satellites orbiting Earth.

---

# 🛰️ The GPS Constellation

GPS consists of a network of satellites continuously orbiting Earth.

```text
             Satellite

                 ●


      ●                     ●

  Satellite             Satellite


                 🌍
                Earth


      ●                     ●

  Satellite             Satellite
```

Each satellite continuously broadcasts:

* Its position
* The current time
* Navigation data

A GPS receiver listens to these signals and calculates its own position.

---

# How GPS Works

The fundamental idea is surprisingly simple.

Every satellite broadcasts:

```text
Position
+
Timestamp
```

The receiver compares:

```text
Time Sent

vs

Time Received
```

The difference represents signal travel time.

Distance can then be calculated:

```math
d = ct
```

Where:

* d = distance
* c = speed of light
* t = travel time

Because radio waves travel at the speed of light, even tiny timing errors can create large position errors.

---

# 📐 Trilateration

GPS uses trilateration rather than triangulation.

Suppose a receiver measures distance from a single satellite.

```text
Satellite

    ●

Distance = r
```

The receiver could be anywhere on a sphere.

```math
(x-x_1)^2+(y-y_1)^2+(z-z_1)^2=r^2
```

A second satellite creates another sphere.

The receiver must lie at the intersection.

A third satellite narrows the possibilities further.

A fourth satellite resolves timing errors and produces a unique solution.

This process is called:

# Trilateration

---

# Why Four Satellites?

Many people assume three satellites are enough.

In practice, GPS receivers require at least four satellites.

Unknown variables:

```math
x
```

```math
y
```

```math
z
```

```math
t
```

Where:

* x = position
* y = position
* z = altitude
* t = clock error

Four unknowns require four equations.

Therefore:

```text
Minimum Satellites = 4
```

---

# GPS Accuracy

Consumer GPS systems typically achieve:

```text
3m – 10m
```

accuracy.

High-end systems may achieve:

```text
1m
```

or better.

Advanced RTK GPS systems can achieve:

```text
1cm – 2cm
```

accuracy.

Typical accuracy comparison:

| System       | Accuracy |
| ------------ | -------- |
| Standard GPS | 3m – 10m |
| DGPS         | <1m      |
| RTK GPS      | 1-2cm    |

---

# Sources of Error

GPS measurements are affected by numerous error sources.

## Atmospheric Delay

Signals must pass through:

* Ionosphere
* Troposphere

This changes signal speed.

---

## Multipath Reflection

Signals may bounce off:

* Buildings
* Vehicles
* Metal structures

```text
Satellite

   ↓

Building

  ↙ ↘

Receiver
```

The receiver may process the reflected signal rather than the direct signal.

---

## Clock Error

GPS relies on extremely accurate timing.

A timing error of:

```math
1\mu s
```

produces approximately:

```math
300m
```

of distance error.

This demonstrates why GPS satellites use atomic clocks.

---

## Satellite Geometry

Satellite placement also affects accuracy.

Good geometry:

```text
      ●

●           ●

      X

●           ●
```

Poor geometry:

```text
● ● ● ●

     X
```

The first configuration produces significantly better localization.

---

# GPS in Robotics

GPS is extremely useful for:

* Outdoor robots
* Autonomous tractors
* Delivery vehicles
* Self-driving cars
* Drones

Example state estimate:

```math
State=
(x,y,z)
```

The robot continuously updates this state as new GPS measurements arrive.

---

# Why GPS Is Rare In Competitive Robotics

GPS is rarely used in:

* VEX
* FTC
* FRC

Reasons:

❌ Indoor environments

❌ Weak satellite visibility

❌ Insufficient accuracy

❌ Small field sizes

For example:

```text
Robot Error = ±3m

Field Size ≈ 3m
```

The error may be larger than the field itself.

Therefore competitive robotics typically relies on:

* Odometry
* IMUs
* Vision Systems

instead of GPS.

---

# GPS and Sensor Fusion

GPS alone is rarely sufficient.

Modern navigation systems combine:

```text
GPS
 +
 IMU
 +
 Odometry
 +
 Vision
```

to create a more accurate position estimate.

A simplified fusion model:

```math
Pose_{final}
=
w_1GPS
+
w_2IMU
+
w_3Odometry
```

where:

```math
w_1+w_2+w_3=1
```

In practice, Kalman Filters are commonly used.

---

# Advantages and Limitations

## Advantages

✅ Global coverage

✅ Absolute positioning

✅ No wheel contact required

✅ Excellent for large environments

✅ Essential for outdoor navigation

---

## Limitations

❌ Poor indoor performance

❌ Signal blockage

❌ Atmospheric errors

❌ Multipath interference

❌ Lower accuracy than local sensors

---

# Conclusion

GPS is one of the most important localization technologies ever developed.

By measuring distances to multiple satellites and applying trilateration, a receiver can determine its position anywhere on Earth.

Although GPS is unsuitable for most competitive robotics applications, it remains a critical component of autonomous vehicles, drones, surveying systems, and modern navigation infrastructure.

In advanced robotic systems, GPS is often combined with odometry, IMUs, and vision systems to achieve reliable localization.


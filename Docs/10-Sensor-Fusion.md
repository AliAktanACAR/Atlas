# 🔗 Sensor Fusion

## Introduction

No sensor is perfect.

Every localization system suffers from limitations:

```text id="x4nt9r"
Odometry      → Drift

IMU           → Noise

GPS           → Low Precision

Vision        → Lighting Problems

LiDAR         → High Cost
```

If a robot relies on only one sensor, localization errors become unavoidable.

Sensor Fusion is the process of combining information from multiple sensors to produce a more accurate estimate of the robot's state.

The goal is simple:

```text id="9b2tq2"
Multiple Imperfect Sensors
            ↓
     Better Estimate
```

---

# Why Sensor Fusion Exists

Consider a robot using only wheel odometry.

Initially:

```math id="rz26hv"
Pose=(x,y,\theta)
```

is estimated accurately.

However:

```math id="wlgv0d"
E(t)
=
E_0
+
\int_0^t e(\tau)d\tau
```

Small errors accumulate over time.

After a long match:

```text id="cxhz5r"
Real Position

      ≠

Estimated Position
```

The robot becomes lost.

Now imagine adding:

* IMU
* Vision
* GPS

The robot can continuously correct itself.

---

# State Estimation

Localization systems attempt to estimate the robot's state.

A simplified state vector:

```math id="f8q0p8"
X=
\begin{bmatrix}
x\\
y\\
\theta
\end{bmatrix}
```

More advanced systems include:

```math id="9a5p67"
X=
\begin{bmatrix}
x\\
y\\
\theta\\
v\\
\omega
\end{bmatrix}
```

Where:

* x = position
* y = position
* θ = heading
* v = velocity
* ω = angular velocity

The objective of sensor fusion is to estimate this state as accurately as possible.

---

# The Weighted Estimate

Suppose multiple sensors provide position estimates.

Odometry:

```math id="b0d93y"
P_{odom}
```

IMU:

```math id="l9z5m8"
P_{imu}
```

Vision:

```math id="v5u84h"
P_{vision}
```

A simple fusion model:

```math id="zqqpzy"
P=
w_1P_{odom}
+
w_2P_{imu}
+
w_3P_{vision}
```

Subject to:

```math id="j57hcc"
w_1+w_2+w_3=1
```

Where:

```math id="zb7eym"
w_i
```

represents confidence in each sensor.

Higher confidence means greater influence on the final estimate.

---

# Understanding Sensor Confidence

Not all sensors should be trusted equally.

Example:

```text id="vx2k68"
Odometry Error = ±0.5in

Vision Error = ±0.1in
```

Vision should contribute more heavily.

```math id="f0vj6x"
w_{vision}
>
w_{odom}
```

The fusion system continuously adjusts these weights.

This concept forms the basis of modern state estimation.

---

# Measurement Noise

Every sensor measurement contains uncertainty.

A measurement can be represented:

```math id="sc9x3m"
z=x+n
```

Where:

* z = measured value
* x = true value
* n = noise

Noise is often modeled:

```math id="qv1t7q"
n
\sim
N(0,\sigma^2)
```

This notation means:

* Mean error = 0
* Variance = σ²

Most sensor fusion algorithms are built around this assumption.

---

# Covariance

Covariance describes uncertainty.

A covariance matrix:

```math id="zh35vf"
P=
\begin{bmatrix}
\sigma_x^2 & 0 & 0\\
0 & \sigma_y^2 & 0\\
0 & 0 & \sigma_\theta^2
\end{bmatrix}
```

indicates confidence in each state variable.

Small covariance:

```math id="q01w65"
P
\rightarrow
0
```

means high confidence.

Large covariance:

```math id="xdmrpx"
P
\rightarrow
\infty
```

means low confidence.

---

# Prediction and Correction

Most sensor fusion systems operate in two stages.

## Prediction

Use previous information:

```math id="p0hjmk"
X_{k|k-1}
=
AX_{k-1}
+
BU_k
```

The robot predicts its future state.

---

## Correction

Use sensor measurements:

```math id="nvvg8u"
X_{k|k}
=
X_{k|k-1}
+
K(Z_k-HX_{k|k-1})
```

The robot corrects its prediction.

This cycle repeats continuously.

```text id="w9y9j5"
Predict
   ↓
Measure
   ↓
Correct
   ↓
Repeat
```

---

# Kalman Filter

The most famous sensor fusion algorithm is the Kalman Filter.

Developed by:

```text id="4vb18w"
Rudolf Kalman
```

in 1960.

The Kalman Filter:

* Predicts state
* Estimates uncertainty
* Corrects measurements
* Minimizes error

A simplified gain equation:

```math id="g3z50t"
K=
PH^T
(HPH^T+R)^{-1}
```

Where:

* K = Kalman Gain
* P = Covariance
* H = Measurement Model
* R = Measurement Noise

The Kalman Gain determines how much the system trusts a sensor.

---

# Extended Kalman Filter

Many robotic systems are nonlinear.

Example:

```math id="yb0cpk"
x'=v\cos\theta
```

```math id="dzpq1z"
y'=v\sin\theta
```

A standard Kalman Filter assumes linear equations.

The Extended Kalman Filter (EKF) solves this problem.

The EKF:

1. Linearizes nonlinear systems
2. Predicts robot motion
3. Incorporates sensor measurements

It is widely used in:

* Autonomous vehicles
* Drones
* SLAM systems
* Mobile robotics

---

# Sensor Fusion in Competitive Robotics

Most competition robots use a simplified fusion approach.

Typical setup:

```text id="tvmt6h"
Tracking Wheels
      +
      IMU
      +
   Vision
```

Tracking Wheels:

```text id="tl6t0y"
Fast Position Updates
```

IMU:

```text id="aydw8o"
Reliable Heading
```

Vision:

```text id="ucwbpj"
Error Correction
```

Together they provide significantly better localization than any individual sensor.

---

# Advantages

✅ Reduced drift

✅ Increased accuracy

✅ Better reliability

✅ Improved robustness

✅ Higher confidence estimates

---

# Limitations

❌ Increased complexity

❌ Higher computational cost

❌ More calibration required

❌ Additional sensors needed

---

# Conclusion

Sensor Fusion is one of the most important concepts in modern robotics.

Instead of trusting a single sensor, robots combine information from multiple sources to estimate their true state.

By merging odometry, IMUs, GPS, vision systems, and other sensors, robots can achieve localization performance that would be impossible using any individual sensor alone.

Nearly every advanced autonomous system developed today relies on sensor fusion in some form, making it a cornerstone of modern navigation and robotics.


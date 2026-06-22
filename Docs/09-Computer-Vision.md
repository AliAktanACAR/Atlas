# 👁️ Computer Vision

## Introduction

Computer Vision is the field of robotics and artificial intelligence that enables machines to interpret and understand visual information from the world.

Humans use eyes to determine:

* Position
* Direction
* Distance
* Object identity
* Motion

Robots achieve similar capabilities using cameras and computer vision algorithms.

```text
Camera
   ↓
Image Processing
   ↓
Feature Detection
   ↓
Localization
```

Modern autonomous systems increasingly rely on computer vision because it provides information that cannot be obtained from encoders, IMUs, or GPS alone.

---

# What Is An Image?

A digital image is simply a matrix of pixels.

A grayscale image can be represented as:

```math
I(x,y)
```

Where:

* x = horizontal coordinate
* y = vertical coordinate

Each pixel contains an intensity value.

Example:

```text
120 124 129
115 121 126
108 117 122
```

Color images contain three channels:

```math
(R,G,B)
```

Representing:

* Red
* Green
* Blue

A camera continuously produces these matrices for processing.

---

# The Localization Problem

A robot must answer:

```text
Where am I?
```

Unlike odometry, computer vision attempts to solve this problem using environmental information.

Instead of measuring wheel movement:

```text
Wheel Motion
    ↓
Position
```

Vision uses:

```text
Camera Image
     ↓
Visual Features
     ↓
Position Estimate
```

This allows localization even when wheels slip.

---

# Feature Detection

The first step in many vision systems is identifying visual features.

Features are points that can be reliably recognized between images.

Examples:

* Corners
* Edges
* Markers
* Textures

```text
+---------+
|         |
|   ■     |
|         |
+---------+
```

The corner becomes a feature point.

A feature can be represented as:

```math
f=(x,y)
```

Thousands of features may be detected in a single image.

---

# Feature Tracking

Once features are detected, they can be tracked across frames.

Suppose a feature moves:

```math
f_1=(120,80)
```

to

```math
f_2=(135,80)
```

The displacement becomes:

```math
\Delta f
=
f_2-f_1
```

Tracking many features simultaneously allows a robot to estimate its own movement.

This principle forms the basis of visual odometry.

---

# Visual Odometry

Visual odometry estimates motion using only camera data.

Instead of tracking wheel movement:

```text
Encoder
   ↓
Distance
```

we track image movement:

```text
Camera
   ↓
Feature Motion
   ↓
Robot Motion
```

The robot observes:

```math
f_i(t)
```

and

```math
f_i(t+\Delta t)
```

for many features.

The resulting motion estimate can be represented as:

```math
Pose=(x,y,\theta)
```

just like traditional odometry.

---

# Depth Estimation

One challenge in computer vision is determining depth.

A single image does not directly provide distance information.

Several techniques exist.

### Stereo Vision

Two cameras are used.

```text
Camera L      Camera R

    ●------------●
```

The difference between observations is called disparity.

```math
d=x_L-x_R
```

Distance can be estimated:

```math
Z=
\frac{fB}{d}
```

Where:

* Z = depth
* f = focal length
* B = camera separation
* d = disparity

---

# AprilTags

One of the most popular localization methods in robotics uses AprilTags.

An AprilTag is a special visual marker.

```text
┌─────────┐
│ █ ░ █ ░ │
│ ░ █ ░ █ │
│ █ █ ░ ░ │
└─────────┘
```

The robot detects:

* Position
* Orientation
* Tag ID

from a single image.

Advantages:

✅ Fast

✅ Accurate

✅ Easy implementation

This technology is widely used in:

* FRC
* FTC
* Research Robotics

---

# ArUco Markers

ArUco markers are similar to AprilTags.

Each marker contains:

```text
Unique ID
+
Geometric Pattern
```

The camera estimates:

```math
(x,y,z)
```

and

```math
(roll,pitch,yaw)
```

relative to the marker.

These markers are commonly used for:

* Indoor navigation
* Calibration
* Educational robotics

---

# Object Detection

Computer vision can also identify objects.

Modern systems use neural networks such as:

* YOLO
* SSD
* Faster R-CNN

The output is usually:

```text
Object
Confidence
Bounding Box
```

Example:

```text
Cube      98%
Cone      95%
Ball      97%
```

This allows robots to interact intelligently with their environment.

---

# Simultaneous Localization

Vision systems can estimate:

```math
Pose=(x,y,\theta)
```

without relying on wheel encoders.

Advantages:

✅ Works during wheel slip

✅ Detects environmental landmarks

✅ Can self-correct localization errors

Disadvantages:

❌ Computationally expensive

❌ Lighting dependent

❌ Camera calibration required

---

# Computer Vision in Competitive Robotics

Computer vision is becoming increasingly important in competitions.

Applications include:

### Target Alignment

```text
Robot
   ↓
Target Detection
   ↓
Automatic Alignment
```

### AprilTag Localization

```text
Camera
   ↓
Tag Detection
   ↓
Pose Estimation
```

### Game Piece Detection

```text
Camera
   ↓
Object Detection
   ↓
Pickup Routine
```

---

# Vision vs Odometry

| Property                | Vision    | Odometry  |
| ----------------------- | --------- | --------- |
| Drift                   | Low       | High      |
| Computational Cost      | High      | Low       |
| Speed                   | Medium    | Very High |
| Environmental Awareness | Excellent | None      |
| Lighting Dependence     | Yes       | No        |

The two systems are often combined rather than used independently.

---

# Vision + Odometry

A modern robot often uses:

```text
Odometry
    +
IMU
    +
Vision
```

to create a more reliable localization estimate.

Each system compensates for the weaknesses of the others.

```text
Odometry → Fast

IMU → Rotation

Vision → Correction
```

Together they provide significantly better localization than any individual sensor.

---

# The Future of Localization

As computing power continues to increase, computer vision is becoming one of the most important localization technologies in robotics.

Modern autonomous vehicles, drones, warehouse robots, and research platforms all rely heavily on visual information.

Many engineers believe that future localization systems will depend increasingly on computer vision and sensor fusion techniques.

---

# Conclusion

Computer vision allows robots to perceive and understand their environment through cameras and image processing algorithms.

By detecting features, tracking motion, estimating depth, and recognizing objects, vision systems can localize robots with remarkable accuracy.

Although more computationally demanding than odometry, computer vision provides environmental awareness and self-correction capabilities that make it one of the most powerful localization technologies available today.


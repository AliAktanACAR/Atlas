# 🌍 Atlas

**Advanced Odometry, Motion Control & Autonomous Navigation Library**

Atlas is an open-source robotics library focused on localization, motion control, and autonomous navigation for competitive robotics platforms such as VEX V5 and FRC.

The project is designed to provide reusable components for building autonomous robots, ranging from basic odometry to advanced path following algorithms.

---

# ✨ Features

### 📍 Localization

* Two Wheel Odometry
* Three Wheel Odometry
* IMU Integration
* Pose Estimation
* Real-Time Position Tracking

### 🎯 Motion Control

* PID Controllers
* Drive to Point
* Turn to Angle
* Motion Profiling

### 🗺️ Path Following

* Waypoints
* Path Generation
* Pure Pursuit *(planned)*
* Advanced Navigation Algorithms *(planned)*

---

# 🚀 Project Goals

Atlas is being developed as a modular robotics library that can be used in both educational projects and robotics competitions.

Current goals include:

* Accurate robot localization
* Reliable closed-loop motion control
* Expandable autonomous navigation
* Easy integration into robotics projects

The library is intended to be modular, well documented, and easy to extend as new algorithms are added.

---

# 🧮 Core Concepts

Atlas is built around several fundamental robotics concepts:

* Odometry
* Robot Kinematics
* Coordinate Transformations
* PID Control
* Motion Profiling
* Path Following
* Path Planning

---

# 📦 Project Structure

```text
atlas/
├── math/
├── odometry/
├── control/
├── path/
└── examples/
```

Each module is designed to be independent so that individual components can be used without requiring the entire library.

---

# 🎮 Supported Platforms

| Platform      | Support |
| ------------- | :-----: |
| VEX V5        |    ✅    |
| FRC           |    ✅    |
| Java Projects |    ✅    |

---

# 🛠 Development Roadmap

## Version 0.1

* [ ] Vector2D
* [ ] Pose2D
* [ ] PID Controller
* [ ] Three Wheel Odometry

## Version 0.2

* [ ] Two Wheel + IMU Odometry
* [ ] Drive to Point
* [ ] Turn to Angle

## Version 0.3

* [ ] Path Following
* [ ] Pure Pursuit

## Version 1.0

* [ ] Complete Autonomous Navigation Framework

---

# 📚 Documentation

The documentation is intended to introduce both the theory behind robot localization and the implementation used in Atlas.

|  #  | Topic                                                   | Description                        |
| :-: | ------------------------------------------------------- | ---------------------------------- |
|  01 | [What Is Odometry?](docs/01-What-Is-Odometry.md)        | Introduction to odometry           |
|  02 | [History Of Odometry](docs/02-History-Of-Odometry.md)   | Historical background              |
|  03 | [How Odometry Works](docs/03-How-Odometry-Works.md)     | Mathematical foundations           |
|  04 | [Applications](docs/04-Applications.md)                 | Practical applications             |
|  05 | [Localization Systems](docs/05-Localization-Systems.md) | Modern localization methods        |
|  06 | [Tracking Wheels](docs/06-Tracking-Wheels.md)           | Dead wheels, offsets, and geometry |
|  07 | [IMU](docs/07-IMU.md)                                   | Inertial Measurement Units         |
|  08 | [GPS](docs/08-GPS.md)                                   | Satellite positioning              |
|  09 | [Computer Vision](docs/09-Computer-Vision.md)           | Vision-based localization          |
|  10 | [Sensor Fusion](docs/10-Sensor-Fusion.md)               | Combining multiple sensors         |
|  11 | [PID Control](docs/11-PID-Control.md)                   | Closed-loop control                |
|  12 | [Pure Pursuit](docs/12-Pure-Pursuit.md)                 | Path following algorithm           |
|  13 | [Path Planning](docs/13-Path-Planning.md)               | Route generation                   |
|  14 | [Math Behind Atlas](docs/14-Math-Behind-Atlas.md)       | Mathematical reference             |

---

# 🗺️ Learning Path

```text
What Is Odometry?
        │
        ▼
History Of Odometry
        │
        ▼
How Odometry Works
        │
        ▼
Tracking Wheels
        │
        ▼
       IMU
        │
        ▼
       GPS
        │
        ▼
Computer Vision 
        │
        ▼
  Sensor Fusion
        │
        ▼
   PID Control
        │
        ▼
  Pure Pursuit
        │
        ▼
  Path Planning
        │
        ▼
Math Behind Atlas
```

---

## 📂 Source Layout

| Module                             | Description                                          |
| ---------------------------------- | ---------------------------------------------------- |
| [`math/`](src/math/)               | Mathematical utilities, vectors, poses, and geometry |
| [`sensors/`](src/sensors/)         | Sensor interfaces and hardware abstractions          |
| [`control/`](src/control/)         | Motion control algorithms and utilities              |
| [`pid/`](src/pid/)                 | PID controller implementations                       |
| [`goto/`](src/goto/)               | Drive-to-point and turn-to-angle algorithms          |
| [`purepursuit/`](src/purepursuit/) | Pure Pursuit path following                          |
| [`examples/`](src/examples/)       | Example projects and sample code                     |


---

# 🤝 Contributing

Contributions of any kind are welcome. If you find a bug, have an idea for an improvement, or would like to implement a new feature, feel free to open an issue or submit a pull request.

---

# 📄 License

This project is licensed under the Apache License 2.0.

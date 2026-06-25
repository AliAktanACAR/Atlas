# 🌍 Atlas

### Advanced Odometry, Motion Control & Autonomous Navigation Library

Atlas is an open-source robotics library designed for competitive robotics platforms such as VEX V5 and FRC.

Built around modern odometry principles, Atlas provides accurate robot localization, motion control algorithms, and a foundation for autonomous navigation systems.

---

## ✨ Features

### 📍 Localization
- 2 Wheel Odometry
- 3 Wheel Odometry
- Inertial Sensor Integration
- Pose Estimation
- Real-Time Position Tracking

### 🎯 Motion Control
- PID Controllers
- Drive To Point
- Turn To Angle
- Motion Profiling

### 🗺️ Path Following
- Waypoints
- Path Generation
- Pure Pursuit (Planned)
- Advanced Navigation Algorithms (Planned)

---

## 🚀 Why Atlas?

Most robotics projects stop at simple autonomous movement.

Atlas aims to provide a complete framework for:

- Accurate localization
- Reliable motion control
- Autonomous navigation
- Future path planning systems

The goal is to create a professional-grade robotics library that can be used in both educational and competitive robotics environments.

---

## 🧮 Core Concepts

Atlas is based on:

- Odometry
- Kinematics
- Coordinate Transformations
- PID Control Theory
- Path Planning Algorithms

---

## 📦 Planned Modules

```text
atlas/
├── math/
├── odometry/
├── control/
├── path/
└── examples/
```

---

## 🎮 Supported Platforms

| Platform | Support |
|-----------|----------|
| VEX V5 | ✅ |
| FRC | ✅ |
| Java Projects | ✅ |

---

## 🛠 Development Roadmap

### Version 0.1
- [ ] Vector2D
- [ ] Pose2D
- [ ] PID Controller
- [ ] Three Wheel Odometry

### Version 0.2
- [ ] Two Wheel + IMU Odometry
- [ ] Drive To Point
- [ ] Turn To Angle

### Version 0.3
- [ ] Path Following
- [ ] Pure Pursuit

### Version 1.0
- [ ] Full Autonomous Navigation Framework

---

## 📚 Documentation

Documentation and mathematical derivations will be available inside the `/docs` folder.

Topics include:

- Odometry Theory
- Coordinate Systems
- Arc-Based Position Tracking
- PID Tuning
- Motion Control

---
## 📚 Documentation

Atlas documentation is designed to guide readers from the fundamentals of localization to advanced autonomous navigation algorithms.

| #  | Topic                                                   | Description                                            |
| -- | ------------------------------------------------------- | ------------------------------------------------------ |
| 01 | [What Is Odometry?](docs/01-What-Is-Odometry.md)        | Introduction to odometry and localization              |
| 02 | [History Of Odometry](docs/02-History-Of-Odometry.md)   | Historical evolution of odometry systems               |
| 03 | [How Odometry Works](docs/03-How-Odometry-Works.md)     | Mathematical foundations of localization               |
| 04 | [Applications](docs/04-Applications.md)                 | Real-world uses of odometry and localization           |
| 05 | [Localization Systems](docs/05-Localization-Systems.md) | Overview of modern localization technologies           |
| 06 | [Tracking Wheels](docs/06-Tracking-Wheels.md)           | Dead wheels, geometry, offsets, and measurement theory |
| 07 | [IMU](docs/07-IMU.md)                                   | Inertial Measurement Units and heading estimation      |
| 08 | [GPS](docs/08-GPS.md)                                   | Satellite-based localization systems                   |
| 09 | [Computer Vision](docs/09-Computer-Vision.md)           | Vision-based robot localization                        |
| 10 | [Sensor Fusion](docs/10-Sensor-Fusion.md)               | Combining multiple localization systems                |
| 11 | [PID Control](docs/11-PID-Control.md)                   | Closed-loop control theory                             |
| 12 | [Pure Pursuit](docs/12-Pure-Pursuit.md)                 | Path following algorithms                              |
| 13 | [Path Planning](docs/13-Path-Planning.md)               | Route generation and navigation planning               |
| 14 | [Math Behind Atlas](docs/14-Math-Behind-Atlas.md)       | Mathematics used throughout the Atlas library          |

---

## 🗺️ Learning Path

```text
What Is Odometry?
        ↓
History Of Odometry
        ↓
How Odometry Works
        ↓
Tracking Wheels
        ↓
       IMU
        ↓
       GPS
        ↓
Computer Vision
        ↓
Sensor Fusion
        ↓
PID Control
        ↓
Pure Pursuit
        ↓
Path Planning
        ↓
Math Behind Atlas
```

---

## 🚀 Atlas Modules

```text
src/
│
├── math/
│
├── sensors/
│
├── control/
│
├── PID/
│
├── GoTo/
│
├── PurePursuit/
│
└── examples/
```

Each module is designed to be independent, reusable, and suitable for competitive robotics platforms such as VEX V5 and FRC.

## 🤝 Contributing

Contributions, suggestions, and improvements are welcome.

---

## 📄 License

Licensed under the Apache License 2.0.

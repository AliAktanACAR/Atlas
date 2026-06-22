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
- [ ] Two Wheel Odometry
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

Atlas documentation is organized from fundamental concepts to advanced localization and navigation systems.

| #  | Topic                                                       | Description                                       |
| -- | ----------------------------------------------------------- | ------------------------------------------------- |
| 01 | [What is Odometry?](docs/01-What-Is-Odometry.md)            | Introduction to odometry and robot localization   |
| 02 | [History of Odometry](docs/02-History-Of-Odometry.md)       | Historical development of odometry systems        |
| 03 | [How Odometry Works](docs/03-How-Odometry-Works.md)         | Mathematical foundations and localization theory  |
| 04 | [Applications of Odometry](docs/04-Applications.md)         | Real-world engineering applications               |
| 05 | [Localization Systems](docs/05-Localization-Systems.md)     | Overview of localization technologies             |
| 06 | [Tracking Wheels](docs/06-Tracking-Wheels.md)               | Dead wheels, geometry, and measurement theory     |
| 07 | [IMU](docs/07-IMU.md)                                       | Inertial Measurement Units and heading estimation |
| 08 | [Sensor Fusion](docs/08-Sensor-Fusion.md)                   | Combining multiple sensors for localization       |
| 09 | [GPS](docs/09-GPS.md)                                       | Global Positioning Systems                        |
| 10 | [Computer Vision](docs/10-Computer-Vision.md)               | Vision-based localization systems                 |
| 11 | [LiDAR](docs/11-LiDAR.md)                                   | Laser-based mapping and localization              |
| 12 | [SLAM](docs/12-SLAM.md)                                     | Simultaneous Localization and Mapping             |
| 13 | [PID Control](docs/13-PID-Control.md)                       | Feedback control systems                          |
| 14 | [Go To Point](docs/14-GoTo.md)                              | Coordinate-based robot navigation                 |
| 15 | [Pure Pursuit](docs/15-PurePursuit.md)                      | Path-following algorithms                         |
| 16 | [Motion Profiling](docs/16-Motion-Profiling.md)             | Velocity and acceleration planning                |
| 17 | [Path Planning](docs/17-Path-Planning.md)                   | Route generation algorithms                       |
| 18 | [Kalman Filter](docs/18-Kalman-Filter.md)                   | State estimation and filtering                    |
| 19 | [Extended Kalman Filter](docs/19-Extended-Kalman-Filter.md) | Nonlinear state estimation                        |
| 20 | [Atlas Architecture](docs/20-Atlas-Architecture.md)         | Internal library structure and design             |
| 21 | [API Reference](docs/21-API-Reference.md)                   | Atlas classes and usage examples                  |

---

### 🚀 Learning Path

```text
What is Odometry?
        ↓
History of Odometry
        ↓
How Odometry Works
        ↓
Tracking Wheels + IMU
        ↓
Localization Systems
        ↓
Sensor Fusion
        ↓
PID Control
        ↓
Go To Point
        ↓
Pure Pursuit
        ↓
Path Planning
```


## 🤝 Contributing

Contributions, suggestions, and improvements are welcome.

---

## 📄 License

Licensed under the Apache License 2.0.

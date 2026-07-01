# 🌍 Atlas

A Java robotics library focused on localization, motion control, and autonomous navigation.

Atlas is being developed for competitive robotics projects, with an emphasis on VEX V5 and FRC. The library provides reusable mathematical tools and control algorithms for building autonomous robots.

## Features

### Localization
- Two-wheel odometry
- Three-wheel odometry
- IMU integration
- Pose estimation
- Real-time position tracking

### Motion Control
- PID controller
- Drive to point
- Turn to angle
- Motion profiling

### Path Following
- Waypoints
- Path generation
- Pure Pursuit *(planned)*
- Additional navigation algorithms *(planned)*

## Why Atlas?

Many teams end up rewriting the same localization and control code for every season. Atlas is an attempt to collect those components into a reusable library.

The project focuses on:
- localization
- motion control
- autonomous navigation
- reusable robotics utilities

The long-term goal is to provide a clean and well-documented foundation for autonomous robotics projects.

## Core Concepts

Atlas is built around several robotics concepts:

- Odometry
- Kinematics
- Coordinate transformations
- PID control
- Path planning

## Project Structure

```text
src/
├── math/
├── sensors/
├── control/
├── PID/
├── GoTo/
├── PurePursuit/
└── examples/
```

## Supported Platforms

| Platform | Status |
|----------|--------|
| VEX V5 | ✅ |
| FRC | ✅ |
| Java Projects | ✅ |

## Roadmap

### v0.1

- [ ] Math library
- [ ] Pose2D
- [ ] PID controller
- [ ] Three-wheel odometry

### v0.2

- [ ] Two-wheel odometry
- [ ] Drive to point
- [ ] Turn to angle

### v0.3

- [ ] Path generation
- [ ] Pure Pursuit

### v1.0

- [ ] Autonomous navigation framework

## Documentation

Documentation is available in the `docs` directory.

Topics include:

- Odometry
- Tracking wheels
- IMU
- GPS
- Computer vision
- Sensor fusion
- PID control
- Pure Pursuit
- Path planning
- Mathematics used in Atlas

## Contributing

Issues, pull requests, and suggestions are welcome.

## License

Apache License 2.0

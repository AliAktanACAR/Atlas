# 🗺️ Path Planning

## Introduction

Odometry answers:

```text id="7jj8hy"
Where am I?
```

PID answers:

```text id="x6t6l7"
How do I move?
```

Pure Pursuit answers:

```text id="c11wo8"
How do I follow a path?
```

Path Planning answers an entirely different question:

```text id="zbljly"
What path should I take?
```

This distinction is critical.

A robot cannot follow a path until a path exists.

Path Planning is the process of generating a valid route between a start position and a goal position while satisfying environmental and mechanical constraints.

---

# The Navigation Problem

Consider a robot located at:

```math id="5gwn1u"
S=(x_s,y_s)
```

The goal is:

```math id="54jh54"
G=(x_g,y_g)
```

The simplest solution is:

```text id="jlwm4t"
Start ●────────────● Goal
```

However, real environments contain obstacles.

```text id="tljv9v"
Start ●

      ███████

          ██████

                 ● Goal
```

A direct route may be impossible.

The robot must find an alternative path.

---

# What Makes A Good Path?

A valid path should satisfy several requirements.

### Reachability

The path must connect:

```math id="c5g6x8"
S
\rightarrow
G
```

---

### Collision Avoidance

The path must avoid obstacles.

```math id="pd13fq"
Path
\cap
Obstacle
=
\emptyset
```

---

### Smoothness

Sharp turns should be minimized.

Large curvature changes produce:

* Wheel slip
* Instability
* Slower motion

---

### Efficiency

A shorter path generally reduces:

```math id="f3e5h7"
Time
```

and

```math id="8hr98w"
Energy
```

consumption.

---

# Configuration Space

One of the most important concepts in path planning is configuration space.

A robot's state can be represented as:

```math id="l8vkzk"
(x,y,\theta)
```

Each possible state becomes a point inside a larger mathematical space.

```text id="y8jlwm"
(x)

(y)

(θ)
```

The collection of all possible states forms the configuration space.

Path planning is the problem of finding a route through this space.

---

# Free Space and Obstacles

Configuration space is divided into:

### Free Space

```math id="j1crv7"
C_{free}
```

Locations where movement is possible.

---

### Occupied Space

```math id="xcmn9v"
C_{obs}
```

Locations occupied by obstacles.

The objective becomes:

```math id="0vmzlh"
Find\ Path
\subset
C_{free}
```

connecting start and goal.

---

# Graph-Based Planning

Many path planners convert the environment into a graph.

```text id="a0syk8"
A ----- B ----- C

|       |       |

D ----- E ----- F
```

Each node represents a possible position.

Each edge represents a possible movement.

The robot searches for the optimal route through this graph.

---

# Dijkstra's Algorithm

One of the earliest path planning algorithms.

The objective:

```math id="jytkqs"
Minimize
\sum Cost_i
```

The algorithm expands outward from the start node until the goal is found.

Advantages:

✅ Guaranteed shortest path

✅ Reliable

Disadvantages:

❌ Slow for large environments

---

# A* Search

A* improves upon Dijkstra by introducing a heuristic.

Evaluation function:

```math id="glkmt4"
f(n)
=
g(n)+h(n)
```

Where:

```math id="fq30mz"
g(n)
```

Actual cost from start.

```math id="ov6x65"
h(n)
```

Estimated cost to goal.

A* prioritizes nodes likely to lead toward the target.

Advantages:

✅ Faster

✅ Optimal

✅ Widely used

Applications:

* Robotics
* Games
* Autonomous navigation

---

# Sampling-Based Planning

For large or continuous spaces, graph methods become expensive.

Sampling-based planners generate random states.

Examples:

* PRM
* RRT
* RRT*

```text id="vf20qc"
Start ●

     \

       ●

          \

             ● Goal
```

Instead of searching every location, the planner explores representative samples.

---

# Rapidly Exploring Random Trees (RRT)

RRT builds a tree through free space.

```text id="vylj8s"
Start

  ├─●

  │  ├─●

  │  │  ├─●

  │  │  │
  │  │  └─●

  └──────● Goal
```

Each iteration:

1. Generate random point
2. Find nearest node
3. Extend tree
4. Repeat

Advantages:

✅ Works in complex environments

✅ Handles high-dimensional systems

Disadvantages:

❌ Path may be inefficient

❌ Requires smoothing

---

# Path Smoothing

Raw paths often contain abrupt transitions.

```text id="muh63p"
●────●

      │

      ●────●
```

Robots generally prefer smooth curves.

Techniques include:

* Bézier Curves
* Splines
* Polynomial Trajectories

---

# Bézier Curves

A quadratic Bézier curve:

```math id="juzsgk"
B(t)
=
(1-t)^2P_0
+
2(1-t)tP_1
+
t^2P_2
```

Where:

```math id="ctodl7"
0\le t\le1
```

Advantages:

✅ Smooth

✅ Continuous

✅ Easy to generate

Widely used in robotics and computer graphics.

---

# Splines

Splines connect waypoints smoothly.

```text id="ijv3pw"
Waypoint

   ●

      ●

         ●

            ●
```

The resulting path avoids sudden heading changes.

Popular spline types:

* Cubic Splines
* Quintic Splines
* Hermite Splines

---

# Path Planning vs Path Following

A common misconception is that Pure Pursuit performs path planning.

It does not.

Path Planning:

```text id="rr75g5"
Generate Path
```

Pure Pursuit:

```text id="8dclis"
Follow Path
```

They solve different problems.

A complete navigation stack requires both.

---

# Modern Navigation Pipeline

Most autonomous robots use:

```text id="1vd85t"
Localization
      ↓
Path Planning
      ↓
Path Generation
      ↓
Pure Pursuit
      ↓
PID Control
      ↓
Motors
```

Each layer depends on the previous layer.

---

# Competitive Robotics

Many VEX and FRC robots use simplified path planning.

Typical workflow:

```text id="v7sm2w"
Starting Position
        ↓
Generate Waypoints
        ↓
Create Curve
        ↓
Pure Pursuit
```

Advanced teams often generate trajectories before a match and execute them during autonomous periods.

---

# Future Directions

Modern research explores:

* Dynamic path planning
* Real-time obstacle avoidance
* Reinforcement learning
* Autonomous vehicle navigation
* Multi-robot coordination

These systems combine planning, localization, and control into a unified framework.

---

# Advantages

✅ Finds feasible routes

✅ Avoids obstacles

✅ Optimizes travel

✅ Improves autonomy

✅ Scales to complex environments

---

# Limitations

❌ Computationally expensive

❌ Requires environmental information

❌ Sensitive to map quality

❌ May require replanning

---

# Conclusion

Path Planning is the process of determining how a robot should travel from a start position to a goal while avoiding obstacles and satisfying motion constraints.

It serves as the bridge between localization and control, transforming a robot's understanding of the environment into actionable routes.

Together with odometry, sensor fusion, Pure Pursuit, and PID control, path planning forms one of the core pillars of autonomous robotics.


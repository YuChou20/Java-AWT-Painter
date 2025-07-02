# 🎨 Java AWT Painter

A simple drawing application built with Java AWT. It allows users to draw freehand lines, rectangles, and circles with selectable colors through a graphical interface and menu bar.

---
## Why build this?

This project was created to practice Java GUI development, particularly:

AWT's drawing capabilities with Graphics
Mouse and menu interaction
Real-time shape rendering and position tracking
It is ideal as a beginner-level project to explore how Java can be used to develop interactive desktop applications.
---
## ✨ Features

- 🖊️ **Freehand Drawing**: Draw with a pen tool by dragging the mouse.
- 🔲 **Rectangle Mode**: Click and drag to draw rectangles.
- ⚪ **Circle Mode**: Click and drag to draw ovals (ellipses).
- 🎨 **Color Selection**: Switch between black, red, green, and blue.
- 🧹 **Clear Canvas**: Use the "Clear" option to reset the canvas.
- 🖱️ **Mouse Interaction**: Supports both `MouseListener` and `MouseMotionListener` for drawing control.

---

## 🛠️ Technologies Used

- **Java AWT**: For GUI layout and drawing operations.
- **Event Handling**: Implements `MouseListener`, `MouseMotionListener`, and `ActionListener`.
- **MenuBar System**: Menu-based tool selection (draw mode and color options).
- **Custom Drawing Logic**: Manually calculates shape positioning based on cursor movement.

---
## Getting Started

### Requirements
Java 8 or above
### Run the program
```
javac painter.java
java painter
```

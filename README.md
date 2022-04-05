# 2048
My JavaFX implementation of the game 2048 following OOP principles and MVC design pattern.

# Description
2048 is a single-player sliding tile puzzle video game written by Italian web developer Gabriele Cirulli and published on GitHub. The objective of the game is to slide numbered tiles on a grid to combine them to create a tile with the number 2048.

# Gameplay
2048 is played on a plain 4×4 grid, with numbered tiles that slide when a player moves them using the four arrow keys. Every turn, a new tile randomly appears in an empty spot on the board with a value of either 2 or 4. Tiles slide as far as possible in the chosen direction until they are stopped by either another tile or the edge of the grid. If two tiles of the same number collide while moving, they will merge into a tile with the total value of the two tiles that collided. The resulting tile cannot merge with another tile again in the same move.

If a move causes three consecutive tiles of the same value to slide together, only the two tiles farthest along the direction of motion will combine. If all four spaces in a row or column are filled with tiles of the same value, a move parallel to that row/column will combine the first two and last two. A scoreboard on the upper-right keeps track of the user's score. The user's score starts at zero, and is increased whenever two tiles combine, by the value of the new tile.

The game is won when a tile with a value of 2048 appears on the board.

To move the numbers use the wasd keys or the up down left right keys

# Installation
Without a ssh key:
```
$ git clone https://github.com/alahyaoui/2048.git
```
With a ssh key:
```
$ git clone git@github.com:alahyaoui/2048.git
```

# Execution
Move to the project repository and execute
```
$ cd 2048/
$ mvn javafx:run
```
Nb: You need maven installed and added to your PATH environment variables.
If its not, download maven <a href="https://maven.apache.org/install.html">here</a>

# Author
- **Lahyaoui Ayoub**

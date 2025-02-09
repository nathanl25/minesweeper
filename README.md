# Project: Minesweeper

## Demo & Snippets

---

## Requirements / Purpose

- MVP
- To show understanding of Java through use of replicating minesweepper via the JVM
- To demonstrate awareness

---

## Build Steps

- how to build / run project
- use proper code snippets if there are any commands to run

---

## Design Goals / Approach

- Because the game uses logic based on a nested list I opted to have logic that is slightly more complicated but should have faster run times as I wanted to minimise the amount of times the program loops through the nested list. Because of this I opted for things like hashsets of remaining tiles for the win conditions rather than looping through to see what hasn't be revealed or recursion for revealing blank tiles.

---

## Features

- Coded in Java
- Uses a nested ArrayList of class instances for the gameboard
- Hash Set for remaining tiles
- Recursive DFS for revealing adjacent blank tiles

---

## Known issues

- Inputs currently are not sanitised

---

## Future Goals

- Add a hexagonal/triangular grid for minesweeper
- Format debug printing so that the debug print screen is done next the game print screen
- Have a mode to turn on or off debug mode
- Have the app be more robust in regards to parsing inputs
- Readability of code
- Breaking code into smaller sub-classes

---

## Change logs

### 07/02/2025 - Clean Up

### 06/02/2025 - Game Logic

- Implemented basic gameplay loop
- Introduced lose and win mechanics
- Implemented behaviour of automatic filling of blank tiles when selected

### 05/02/2025 - Board Setup

- Implemented logic for initialising board
- Implemented logic for randomising mine coordinates after selecting a starting tile
-

### 04/02/2025 - Board Printing

- Implementing printing of board, customised colours for numbered tiles
- Added letters and numbers to board printing

---

## What did you struggle with?

- Designing the grid and printing the grid
- Thinking of best practices in terms of optimisation

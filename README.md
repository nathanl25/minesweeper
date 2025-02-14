# Project: Minesweeper

## Demo & Snippets

---

## Requirements / Purpose

- To show understanding of Java through use of replicating minesweepper via the JVM

---

## Build Steps

```bash

cd src
javac ./App.java -d ../bin
cd ../bin
java App

```

---

## Design Goals / Approach

- Because the game uses a nested list I opted to have logic that is slightly more complicated but should have faster run times as I wanted to minimise the amount of times the program loops through the nested list. Because of this I opted for things like a HashSet for the remaining tiles for checking the win condition rather than looping through to see what hasn't be revealed as well as using recursion for revealing adjacent blank tiles.

---

## Features

- Coded in Java
- Uses a nested ArrayList of class instances for the gameboard
- Hash Set to track remaining tiles
- Recursive DFS for revealing adjacent blank tiles

---

## Known issues

- ~~Inputs currently are not sanitised~~ Game will prompt user for input until a valid input is entered

---

## Future Goals

- Add a hexagonal/triangular grid for minesweeper
- Format debug printing so that the debug print screen is done next the game print screen
- Have a mode to turn on or off debug mode
- Have the app be more robust in regards to parsing inputs
- Readability of code
- Breaking code into smaller sub-classes
- Have tests give weighted performance for shuffling a list, vs using a hashset for generating random numbers

---

## Change logs

### 14/02/2025 - Further Clean up

- Moved game initialisation to Game class
- Validated all forms of imput
- Added option to play again

### 07/02/2025 - Clean Up

- Added input validation for creating board dimensions

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

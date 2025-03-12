package com.rayan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Grid {

    private int gridSize;
    private char[][] contents;
    private List<Coordenate> coordenates = new ArrayList<Coordenate>();

    private enum Direction {
        HORIZONTAL, VERTICAL, DIAGONAL
    }

    private class Coordenate {
        int x;
        int y;

        public Coordenate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Grid(int gridSize) {
        this.gridSize = gridSize;
        contents = new char[this.gridSize][this.gridSize];

        // Initialize the grid with '_' characters
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                coordenates.add(new Coordenate(i, j));
                contents[i][j] = '_';
            }
        }
    }

    public void fillGrid(List<String> words) {
        Collections.shuffle(coordenates);
        for (String word : words) {
            for (Coordenate coordenate : coordenates) {
                int x = coordenate.x;
                int y = coordenate.y;
                Direction selectedDirection = getDirectionForFit(word, coordenate);
                if (selectedDirection != null) {
                    switch (selectedDirection) {
                        case HORIZONTAL:
                            for (char c : word.toCharArray()) {
                                contents[x][y++] = c;
                            }
                            break;
                        case VERTICAL:
                            for (char c : word.toCharArray()) {
                                contents[x++][y] = c;
                            }
                            break;
                        case DIAGONAL:
                            for (char c : word.toCharArray()) {
                                contents[x++][y++] = c;
                            }
                            break;
                    }
                    break;
                }
            }
        }

    }

    public void displayGrid() {
        // Print the populated grid
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.print(contents[i][j] + " ");
            }
            System.out.println();
        }
    }

    private Direction getDirectionForFit(String word, Coordenate coordenate) {
        List<Direction> directions = Arrays.asList(Direction.values());
        Collections.shuffle(directions);
        for (Direction direction : directions) {
            if (doesFits(word, coordenate, direction)) {
                return direction;
            }
        }
        return null;
    }

    private boolean doesFits(String word, Coordenate coordenate, Direction direction) {
        int wordLength = word.length();

        switch (direction) {
            case HORIZONTAL:
                // If word length above the grid size horizontal return false
                if (coordenate.y + wordLength > gridSize) return false;
                for (int i = 0; i < wordLength; i++) {
                    if (contents[coordenate.x][coordenate.y + i] != '_') return false;
                }
                break;
            case VERTICAL:
                if (coordenate.x + wordLength > gridSize) return false;
                for (int i = 0; i < wordLength; i++) {
                    if (contents[coordenate.x + i][coordenate.y] != '_') return false;
                }
                break;
            case DIAGONAL:
                if (coordenate.x + wordLength > gridSize || coordenate.y + wordLength > gridSize) return false;
                for (int i = 0; i < wordLength; i++) {
                    if (contents[coordenate.x + i][coordenate.y + i] != '_') return false;
                }
                break;
        }
        return true;
    }

}

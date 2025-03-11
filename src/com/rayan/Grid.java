package com.rayan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Grid {

    private int grdSize;
    private char[][] contents;
    private List<Coordenate> coordenates = new ArrayList<Coordenate>();


    private class Coordenate{
        int x;
        int y;
        public Coordenate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Grid(int gridSize) {
        this.grdSize = gridSize;
        contents = new char[grdSize][grdSize];

        // Initialize the grid with '_' characters
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                coordenates.add(new Coordenate(i, j));
                contents[i][j] = '_';
            }
        }
    }

    public void fillGrid(List<String> words) {
        // Place the first letter of each word at a random position in the grid
        for (String word : words) {
            Collections.shuffle(coordenates);
            for (Coordenate coordenate : coordenates) {
                int x = coordenate.x;
                int y = coordenate.y;
                if(doFits(word,coordenate)) {
                    for (char c : word.toCharArray()) {
                        contents[x][y++] = c;
                    }
                    break;
                }
            }
        }

    }

    public void displayGrid() {
        // Print the populated grid
        for (int i = 0; i < grdSize; i++) {
            for (int j = 0; j < grdSize; j++) {
                System.out.print(contents[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean doFits(String word, Coordenate coordenate) {
        if(coordenate.y + word.length() < grdSize) {
            for (int i = 0; i < word.length(); i++) {
                if (contents[coordenate.x][coordenate.y + i] != '_') return false;
            }
        }
        return true;
    }
}

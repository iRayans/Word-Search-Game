import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        final int GRID_SIZE = 10;
        char[][] grid = new char[GRID_SIZE][GRID_SIZE];

        // Initialize the grid with '_' characters
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = '_';
            }
        }
        List<String> words = Arrays.asList("ONE", "TWO", "THREE", "FOUR");

        // Place the first letter of each word at a random position in the grid
        for (String word : words) {
            // Generate random x and y coordinates within the grid
            int x = ThreadLocalRandom.current().nextInt(0, GRID_SIZE);
            int y = ThreadLocalRandom.current().nextInt(0, GRID_SIZE);
            // Set the first letter of the word at the randomly chosen position
            grid[x][y] = word.charAt(0);
        }

        // Print the populated grid
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
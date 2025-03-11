import com.rayan.Grid;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(10);
        List<String> words = Arrays.asList("ONE", "TWO", "THREE", "FOUR");

        grid.fillGrid(words);
        grid.displayGrid();


    }
}
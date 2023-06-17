package src;
import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        int numberOfRow;
        int numberOfColumn;

        Scanner puzzle = new Scanner(System.in);
        System.out.println("Can you give me the puzzle to solve?");
        System.out.println("Firstly, enter the number of rows");
        numberOfRow = puzzle.nextInt();
        System.out.println("Secondly, enter the number of columns");
        numberOfColumn = puzzle.nextInt();
        char grid[][] = new char[numberOfRow][numberOfColumn];
        System.out.println("Finally, enter the elements of the puzzle");
        for(int a = 0; a < numberOfRow; a++){
            for(int b =0; b < numberOfColumn; b++){
                grid[a][b] = puzzle.next().charAt(0);
            }
        }
        System.out.println("Puzzle is");
        for(int a = 0; a < numberOfRow; a++){
            for(int b =0; b < numberOfColumn; b++){
                System.out.print(grid[a][b] + " ");
            }
            System.out.println();
        }
        System.out.println(" ");
        System.out.println("Solution is: ");

        // Measure time before solving the puzzle
        long startTime = System.nanoTime();

        RulesForPuzzle rules1 = new RulesForPuzzle(numberOfRow, numberOfColumn, grid);
        TentsAndTreesPuzzle puzzle1 = new TentsAndTreesPuzzle(grid, rules1);
        char solution[][] = puzzle1.solvingPuzzle();
        for(int i = 0; i < solution.length; i++) {
            for(int j = 0; j < solution[i].length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
        // Measure time after solving the puzzle
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        double elapsedTimeInSeconds = (double) totalTime / 1_000_000_000.0;
        System.out.println("Elapsed time: " + elapsedTimeInSeconds + " seconds");
    }
}


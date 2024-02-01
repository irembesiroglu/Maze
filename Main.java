import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter maze file name: ");
        String mazeFileName = scanner.nextLine();

        List<String> maze = readMazeFromFile(mazeFileName);
        MazeGraph mazeSolver = new MazeGraph(maze);
        mazeSolver.solveMaze();

        scanner.close();
    }

    private static List<String> readMazeFromFile(String mazeFileName) {
        List<String> maze = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(mazeFileName))) {
            while (scanner.hasNextLine()) {
                maze.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Error reading the maze file: " + e.getMessage());
        }
        return maze;
    }
}

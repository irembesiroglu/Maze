import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MazeGraph {
	private final List<String> treasures;
    private final List<String> maze;
    private boolean[][] visited;
    private final int rows;
    private final int cols;

    public MazeGraph(List<String> maze) {
        this.treasures = new ArrayList<>();
        this.maze = maze;
        this.rows = maze.size();
        this.cols = maze.get(0).length();
        this.visited = new boolean[rows][cols];
    }

    public void solveMaze() {
        findTreasures(0, 0, "");
        printResults();
    }

    private void findTreasures(int row, int col, String path) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col]) {
            return;
        }

        char current = maze.get(row).charAt(col);

        // Mark the current position as visited
        visited[row][col] = true;

        if (current == 'E') {
            treasures.add(path + current);
        }

        // Explore adjacent cells
        exploreCell(row, col + 1, path + current);
        exploreCell(row + 1, col, path + current);
        exploreCell(row, col - 1, path + current);
        exploreCell(row - 1, col, path + current);

        // Unmark the current position to allow backtracking
        visited[row][col] = false;
    }

    private void exploreCell(int row, int col, String path) {
        if (row >= 0 && col >= 0 && row < rows && col < cols && !visited[row][col] &&
                (Character.isLowerCase(maze.get(row).charAt(col)) || maze.get(row).charAt(col) == 'E')) {
            findTreasures(row, col, path);
        }
    }

    private void printResults() {
        Collections.sort(treasures, Comparator.comparingInt(String::length));

        System.out.println(treasures.size() + " treasures are found.");
        if (treasures.size() != 0) {
            System.out.println("Paths are:");
            for (int i = 0; i < treasures.size(); i++) {
                System.out.println((i + 1) + ") " + treasures.get(i));
            }
        }
    }

}

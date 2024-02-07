import java.util.ArrayList;
import java.util.Scanner;

public class GraphBottleNeck_65050492 {
    private int V;
    private ArrayList<int[]> edges;

    public GraphBottleNeck_65050492() {
        this.V = 0;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int u, int v, int w) {
        edges.add(new int[]{u, v, w});
        this.V = Math.max(this.V, Math.max(u, v));
    }

    public int[][] bottleNeckPath(int[][] distances) {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    int tmp = Math.min(distances[i][j], Math.max(distances[i][k], distances[k][j]));
                    distances[i][j] = tmp;
                    distances[j][i] = tmp;
                }
            }
        }
        return distances;
    }

    public static void displayMatrix(int[][] matrix, int step) {
        System.out.println("Step " + step + ":\n");
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphBottleNeck_65050492 g = new GraphBottleNeck_65050492();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the edges and weights (u v w), separated by spaces:");

        while (true) {
            System.out.print("Enter edge and weight (Enter -1 to stop): ");
            int u = scanner.nextInt();
            if (u == -1) break;

            int v = scanner.nextInt();
            if (v == -1) break;

            int w = scanner.nextInt();
            if (w == -1) break;

            g.addEdge(u, v, w);
            System.out.println("[ Edge added ]");
        }

        int[][] distances = new int[g.V + 1][g.V + 1];
        for (int i = 1; i <= g.V; i++) {
            for (int j = 1; j <= g.V; j++) {
                if (i == j) {
                    distances[i][j] = 0;
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int[] edge : g.edges) {
            distances[edge[0]][edge[1]] = edge[2];
        }

        System.out.println("\nBottleneck paths:");

        for (int k = 0; k < g.V; k++) {
            displayMatrix(distances, k);
            distances = g.bottleNeckPath(distances);
        }
    }
}

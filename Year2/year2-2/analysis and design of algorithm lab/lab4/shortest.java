import java.util.Scanner;

class ShortestPath {
    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 1; v < dist.length; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 1; i < dist.length; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    void dijkstra(int graph[][], int src) {
        int V = graph.length;
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 1; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 1; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 1; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        printSolution(dist);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        int graph[][] = new int[V + 1][V + 1];

        System.out.println("Enter the weighted adjacency matrix for the graph:");
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                System.out.print("Weight from vertex " + i + " to vertex " + j + " (0 if no direct connection): ");
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter the source vertex: ");
        int sourceVertex = scanner.nextInt();

        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, sourceVertex);

        scanner.close();
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class KruskalAlgorithm {

    static class Edge implements Comparable<Edge> {
        int start, stop, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class Graph {
        int vertices;
        Edge[] edges;

        Graph(int v, int e) {
            vertices = v;
            edges = new Edge[e];
            for (int i = 0; i < e; ++i)
                edges[i] = new Edge();
        }

        void addEdge(int index, int start, int stop, int weight) {
            edges[index].start = start;
            edges[index].stop = stop;
            edges[index].weight = weight;
        }
    }

    static void makeSet(int[] parent, int[] rank, int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int findParent(int[] parent, int component) {
        if (parent[component] == component)
            return component;

        return parent[component] = findParent(parent, parent[component]);
    }

    static void unionSet(int u, int v, int[] parent, int[] rank) {
        u = findParent(parent, u);
        v = findParent(parent, v);

        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[u] > rank[v]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    static void kruskalAlgo(Graph graph) {
        Arrays.sort(graph.edges);

        int[] parent = new int[graph.vertices];
        int[] rank = new int[graph.vertices];
        makeSet(parent, rank, graph.vertices);

        int minCost = 0;

        System.out.println("Following are the edges in the constructed MST");
        for (int i = 0; i < graph.edges.length; i++) {
            int v1 = findParent(parent, graph.edges[i].start);
            int v2 = findParent(parent, graph.edges[i].stop);
            int wt = graph.edges[i].weight;

            if (v1 != v2) {
                unionSet(v1, v2, parent, rank);
                minCost += wt;
                System.out.println(graph.edges[i].start + " -- " + graph.edges[i].stop + " == " + wt);
            }
        }

        System.out.println("Minimum Cost Spanning Tree: " + minCost);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt() + 1;

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        Graph graph = new Graph(vertices, edges);

        System.out.println("Enter the details of each edge (start stop weight): ");
        for (int i = 0; i < edges; i++) {
            int start = scanner.nextInt();
            int stop = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(i, start, stop, weight);
        }

        kruskalAlgo(graph);
    }
}

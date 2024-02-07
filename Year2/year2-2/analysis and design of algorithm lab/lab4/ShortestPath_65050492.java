// import java.util.*;

// class Graph {
//     private List<String> nodes;
//     private Map<String, List<Edge>> edges;

//     public Graph() {
//         nodes = new ArrayList<>();
//         edges = new HashMap<>();
//     }

//     public void addNode(String node) {
//         nodes.add(node);
//         edges.put(node, new ArrayList<>());
//     }

//     public void addEdge(String node1, String node2, int weight) {
//         edges.get(node1).add(new Edge(node2, weight));
//         edges.get(node2).add(new Edge(node1, weight));
//     }

//     public List<String> getNodes() {
//         return nodes;
//     }

//     public List<Edge> getEdges(String node) {
//         return edges.get(node);
//     }
// }

// class Edge {
//     String to;
//     int weight;

//     public Edge(String to, int weight) {
//         this.to = to;
//         this.weight = weight;
//     }
// }

// class Dijkstra {
//     private Graph graph;
//     private Map<String, Integer> distances;
//     private Map<String, String> previous;
//     private PriorityQueue<String> queue;

//     public Dijkstra(Graph graph) {
//         this.graph = graph;
//         distances = new HashMap<>();
//         previous = new HashMap<>();
//         queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
//     }

//     public Map<String, Integer> shortestPath(String start, String target) {
//     setup(start);
//     while (!queue.isEmpty()) {
//         String current = queue.poll();
//         for (Edge neighbor : graph.getEdges(current)) {
//             int alt = distances.get(current) + neighbor.weight;
//             // Add a condition to check for Integer.MAX_VALUE before updating the distance
//             if (distances.get(current) != Integer.MAX_VALUE && alt < distances.get(neighbor.to)) {
//                 distances.put(neighbor.to, alt);
//                 previous.put(neighbor.to, current);
//                 queue.add(neighbor.to);
//             }
//         }
//     }
//     return distances;
// }

//     private void setup(String start) {
//         for (String node : graph.getNodes()) {
//             distances.put(node, Integer.MAX_VALUE);
//             previous.put(node, null);
//             queue.add(node);
//         }
//         distances.put(start, 0);
//     }

//     public List<String> buildPath(String target) {
//         List<String> path = new ArrayList<>();
//         while (target != null) {
//             path.add(target);
//             target = previous.get(target);
//         }
//         Collections.reverse(path);
//         return path;
//     }
// }

// public class ShortestPath_65050492 {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter the number of vertices: ");
//         int numVertices = scanner.nextInt();

//         Graph graph = new Graph();

//         // Add nodes
//         for (int i = 0; i < numVertices; i++) {
//             System.out.print("Enter vertex " + (i + 1) + ": ");
//             String vertex = scanner.next();
//             graph.addNode(vertex);
//         }

//         // Add edges
//         System.out.print("Enter the number of edges: ");
//         int numEdges = scanner.nextInt();

//         for (int i = 0; i < numEdges; i++) {
//             System.out.print("Enter edge " + (i + 1) + " (vertex1 vertex2 weight): ");
//             String vertex1 = scanner.next();
//             String vertex2 = scanner.next();
//             int weight = scanner.nextInt();
//             graph.addEdge(vertex1, vertex2, weight);
//         }

//         System.out.print("Enter the starting vertex: ");
//         String startVertex = scanner.next();

//         Dijkstra dijkstra = new Dijkstra(graph);
//         Map<String, Integer> result = dijkstra.shortestPath(startVertex, "D");

//         System.out.println("Vertex\tDistance from Source");
//         for (String vertex : graph.getNodes()) {
//             System.out.println(vertex + "\t" + result.get(vertex));
//         }

//         scanner.close();
//     }
// }

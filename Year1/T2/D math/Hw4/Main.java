import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Minneapolis");
        graph.addVertex("Chicago");
        graph.addVertex("Louisville");
        graph.addVertex("Milwaukee");
        graph.addVertex("St.Louis");
        graph.addVertex("Detroit");
        graph.addVertex("Nashville");
        graph.addVertex("Cincinnati");
        graph.addEdge("Minneapolis", "Chicago","355");
        graph.addEdge("Louisville", "Cincinnati","83");
        graph.addEdge("Chicago", "Milwaukee","74");
        graph.addEdge("St.Louis", "Louisville","242");
        graph.addEdge("Louisville", "Milwaukee","348");
        graph.addEdge("Louisville", "Nashville","151");
        graph.addEdge("Chicago", "Louisville","269");
        graph.addEdge("Minneapolis", "Nashville","695");
        graph.addEdge("Louisville", "Detroit","306");
        graph.addEdge("St.Louis", "Chicago","262");
        graph.addEdge("Cincinnati", "Detroit","230");

        graph.show();
    }
}
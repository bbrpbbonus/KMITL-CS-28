import java.util.Arrays;

public class Graph {
    private int[][] adjacencyMatrix;
    private String[][] vertices;
    private int edge;

    public Graph (int numVertices){
        this.vertices = new String[numVertices][2];
        for (int i = 0; i < numVertices; i++) {
            vertices[i][0] = "V"+i;
            vertices[i][1] = i+"";
        }
        adjacencyMatrix = new int[numVertices][numVertices];
        edge=0;    
    }

    public void aggEdge(int from, int to) {
        adjacencyMatrix[from][to] += 1;
        adjacencyMatrix[to][from] += 1;
        adjacencyMatrix[from][to] += (from == to)?1:0;
        edge+=1;
    }

    public void showMatrix() { 
        System.out.print("  ");
        for (String[] is : vertices) {
            System.out.print(" "+is[0]);
        }
        System.out.println();

        for(int i = 0; i < adjacencyMatrix.length; i++){
            System.out.println(vertices[i][0]+" "+Arrays.toString(adjacencyMatrix[i]));
        }
        System.out.println("\nTotal edge is "+edge);
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Graph matrix = new Graph(4);
        matrix.aggEdge(0,1);
        matrix.aggEdge(1,2);
        matrix.aggEdge(1,3);
        matrix.aggEdge(2,3);
        matrix.aggEdge(3,0);

        
        matrix.showMatrix();
    }
}
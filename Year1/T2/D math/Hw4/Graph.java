import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Graph {
    private Map<String, List<String[]>> mapGraph;
    public Graph(){
        mapGraph = new HashMap<String,List<String[]>>();
    }
    public void addVertex(String label) {
        mapGraph.put(label, new ArrayList<>());
    }

    public void addEdge(String label1, String label2,String w) {
        mapGraph.get(label1).add(new String[]{label2,w});
        mapGraph.get(label2).add(new String[]{label1,w});
    }
    public void show(){
        System.out.println("");
        for (Map.Entry<String,List<String[]>> entry : mapGraph.entrySet()) {
            System.out.println("");
            System.out.print(entry.getKey()+" = ");
            for (String[] str : entry.getValue()) {
                System.out.print(str[0]+" "+str[1]+",");
            }
        }

    }

}

class kruskal{
    
    //พยายามแล้วครับแต่ไม่รู้จะเอากราฟที่เขียนมาใช้ไง

}

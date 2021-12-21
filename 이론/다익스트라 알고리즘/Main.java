import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Node>> graph = new HashMap<>();
        graph.put("A",new ArrayList<Node>(Arrays.asList(new Node("B",4), new Node("C",1))));
        graph.put("B",new ArrayList<Node>());
        graph.put("C",new ArrayList<Node>(Arrays.asList(new Node("B",2))));

    }

    class MyDijkstra{
        private String startVertex;
        private HashMap<String, ArrayList<Node>> graph;
        private HashMap<String, Integer>
        private ArrayList<String> targetList;
        private ArrayList<Integer> distanceList;

        public void inputData(String inputStartVertex, HashMap<String, ArrayList<Node>> inputList){
            this.startVertex = inputStartVertex;
            this.graph = inputList;
            for(String key : graph.keySet()){
                targetList.add(key);
            }
            for(int i=0;i<graph.size();i++){
                distanceList.add(Integer.MAX_VALUE);
            }
        }

        public void getDistance(){
        }
    }

    static class Node implements Comparable<Node>{
        private String vertex;
        private Integer distance;
        public Node(String vertex, Integer distance){
            this.vertex = vertex;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node n){
            return this.distance - n.distance;
        }
    }
}

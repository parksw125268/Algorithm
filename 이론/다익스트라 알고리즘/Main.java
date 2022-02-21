import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Node>> graph = new HashMap<>();
        graph.put("A",new ArrayList<Node>(Arrays.asList(new Node("B",8),new Node("C",1),new Node("D",2))));
        graph.put("B",new ArrayList<Node>());
        graph.put("C",new ArrayList<Node>(Arrays.asList(new Node("B",5),new Node("D",2))));
        graph.put("D",new ArrayList<Node>(Arrays.asList(new Node("E",3),new Node("F",5))));
        graph.put("E",new ArrayList<Node>(Arrays.asList(new Node("F",1))));
        graph.put("F",new ArrayList<Node>(Arrays.asList(new Node("A",5))));
        MyDijkstra dijkstra = new MyDijkstra();
        System.out.println(dijkstra.dijkstraFunc("A",graph));
    }

    static class MyDijkstra{
        private String startVertex;
        private HashMap<String, ArrayList<Node>> hashGraph;
        private HashMap<String, Integer> hashDistance = new HashMap<>();

        public String dijkstraFunc(String inputStartVertex, HashMap<String, ArrayList<Node>> inputList){
            PriorityQueue<Node> pq = new PriorityQueue<>();
            initVars(inputStartVertex,inputList,pq);
            whileMoon(pq);
            return makeResult();

        }

        private void initVars(String inputStartVertex, HashMap<String, ArrayList<Node>> inputList, PriorityQueue<Node> pq){
            this.startVertex = inputStartVertex;
            this.hashGraph = inputList;
            for(String key : hashGraph.keySet()){
                hashDistance.put(key,Integer.MAX_VALUE);
            }
            hashDistance.put(this.startVertex,0);
            pq.add(new Node(this.startVertex,0));
        }

        private void whileMoon(PriorityQueue<Node> pq){
            Node currNode;
            Node targetNode;
            String targetVert;
            Integer targetDist;
            while(pq.size()>0){
                currNode = pq.poll();//현재 뽑은 노드
                if(currNode.distance > this.hashDistance.get(currNode.vertex)){
                    continue;
                }
                ArrayList<Node> arrayListTargets = this.hashGraph.get(currNode.vertex);
                for(int i=0;i<arrayListTargets.size();i++){
                    targetNode = arrayListTargets.get(i);
                    targetVert = targetNode.vertex;
                    targetDist = targetNode.distance + currNode.distance;
                    if(this.hashDistance.get(targetVert) > targetDist){
                        this.hashDistance.put(targetVert,targetDist);
                        pq.add(new Node(targetVert,targetDist));
                    }
                }
            }
        }
        private String makeResult(){
            String result = "";
            for(String key : this.hashDistance.keySet()){
                result = result+key+" : "+this.hashDistance.get(key)+"\n";
            }
            return result;
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

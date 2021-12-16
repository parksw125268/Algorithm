import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Node> aList = new ArrayList<>();
        aList.add(new Node("B",8));
        aList.add(new Node("C",1));
        aList.add(new Node("D",2));

        ArrayList<Node> cList = new ArrayList<>();
        cList.add(new Node("B",5));
        cList.add(new Node("D",2));

        ArrayList<Node> dList = new ArrayList<>();
        dList.add(new Node("E",3));
        dList.add(new Node("F",5));

        ArrayList<Node> eList = new ArrayList<>();
        eList.add(new Node("F",1));

        ArrayList<Node> fList = new ArrayList<>();
        fList.add(new Node("A",5));

        /*HashMap<String, ArrayList<Node>> hashData = new HashMap<>();
        hashData.put("A",aList);
        hashData.put("B",new ArrayList<Node>());//B는 아무방향으로도 가지 않는다.
        hashData.put("C",cList);
        hashData.put("D",dList);
        hashData.put("E",eList);
        hashData.put("F",fList);*/

    }

    class MyDijkstra{
        private ArrayList<HashMap<String,ArrayList<Node>>> dataList;// "A",{Node(2,"B"),Node(1,"C")}
        private ArrayList<String> vertexList; // a,b,c,d,e
        private String startVertex;
        public MyDijkstra(String startVertex){
            this.dataList = new ArrayList<>();
            this.startVertex = startVertex;
        }
        public void inputData(String startVertex, ArrayList<Node> nodeList){
            vertexList.add(startVertex);
            HashMap<String, ArrayList<Node>> inputHash = new HashMap<>();
            inputHash.put(startVertex,nodeList);
            this.dataList.add(inputHash);
        }
        public ArrayList<HashMap<String,Integer>> getShortestDistance(){
            //1. 받은 리스트를 돌면서 vertex가 무엇무엇이있는지 중복되지 않게 vertexList에 넣고 value를 inf로 초기화
            //2. PrioriyQueue<Node(startVertex,0)>를 선언하고 거기다가  을 넣고 시작
            // while(Queue.size != 0) 밑에 과정을 반복.
            //3. Queue에서 pop. 거기 달린 vertext들과 자기자신과 + 한 값을 vertextList의 값과 비교해서 더 작으면
            //   vertextList에 업데이트. Queue에도 없으면 push, 있으면 update

            for(int i=0;i<dataList.size();i++){
                dataList.get(i);
            }

            return new ArrayList<HashMap<String,Integer>>();
        }
    }

    static class Node{
        private String vertex;
        private Integer distance;
        public Node(String vertex, Integer distance){
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}

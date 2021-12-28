import java.util.*;

class Solution{
    public long solution(int n, int[] times) {
        PriorityQueue<Node> passed = new PriorityQueue<>();
        ArrayList<Node> answerList = new ArrayList<>();

        //1. Queue 에 다 넣기
        for(int i=0;i<times.length;i++){
            passed.add(new Node(times[i]));
        }

        //2. 최솟값에다가 한개씩 채우기
        for(int i=0;i<n;i++){
            Node node1 = passed.poll();
            node1.plus();
            passed.add(node1);
        }
        //3. 다꺼내서 ArrayList에 넣기
        while (passed.size() != 0){
            Node node1 = passed.poll();
            node1.minus();
            answerList.add(node1);
        }
        Collections.sort(answerList);
        Node node2 = answerList.get(answerList.size()-1);
        return node2.time;
    }

    class Node implements Comparable<Node>{
        private int howLong; //걸리는 시간
        private long time;    //총걸린 시간
        private Node o;

        public Node(int howLong){
            this.howLong = howLong;
            this.time = howLong;
        }

        public void plus(){
            this.time += this.howLong;
        }
        public void minus(){
            this.time -= this.howLong;
        }

        @Override
        public int compareTo(Node o) {
            return (int)(this.time-o.time);
        }

    }
}
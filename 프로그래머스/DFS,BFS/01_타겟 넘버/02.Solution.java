class Solution{
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Tree t = new Tree(target);
        t.insertData(numbers,0,t.head,0);
    
	return t.popCount() ;

    }

    class Tree {
        private Node  head;
        private int count;
        private int target;


        public Tree(int target){
            this.head = new Node(0);
            this.count = 0;
            this.target = target;
        }
        private  class Node{
            Node right;
            Node left = null;
            int value;
            public Node(int value){
                this.right = null;
                this.value = value;
            }
        }

        public void insertData(int[] array, int idx, Node currNode, int Sum){ //idx에 0 부터 들어감.
            if(idx == array.length){
                if (Sum == target){
                    count ++;
                }
                return;
            }
            currNode.left = new Node(-array[idx]);
            currNode.right = new Node(array[idx]);
            insertData(array, idx+1, currNode.left, Sum+currNode.left.value);
            insertData(array, idx+1, currNode.right,Sum+currNode.right.value);
        }

        public int popCount(){
            return this.count;
        }
    }
}

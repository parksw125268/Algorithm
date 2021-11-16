public class BinarySearchTree {
    Node head = null;

    public static class Node{
        int value ;
        Node left = null;
        Node right = null;
    }

    public void insertData(int inputData){
        if (this.head == null ){
            this.head = new Node();
            head.value = inputData;
            return;
        }
        Node fNode = head;
        while(true){
            if(inputData < fNode.value){
                if(fNode.left == null){
                    fNode.left = new Node();
                    fNode.left.value = inputData;
                    return;
                }else{
                    fNode = fNode.left;
                }
            }else{
                if(fNode.right == null){
                    fNode.right = new Node();
                    fNode.right.value = inputData;
                    return;
                }else{
                    fNode = fNode.right;
                }
            }
        }
    }

    public Integer popData(int popData){
        if(this.head ==  null)
            return null;

        //pop 하려는 노드 찾기
        Node fNode = head; //찾는 데이터를 가지 노드
        Node pNode = null; //fNode의 parent
        String side = null;//fNode가 parent에 왼쪽에 달렸냐 오른쪽에 달렸냐.
        while(fNode.value != popData){
            if(popData < fNode.value){
                if (fNode.left == null){
                    return null;
                }else {
                    side = "left";
                    pNode = fNode;
                    fNode = fNode.left;
                }
            }else{
                if(fNode.right == null) {
                    return null;
                }else{
                    side = "right";
                    pNode = fNode;
                    fNode = fNode.right;
                }
            }
        }
        //1. fNode에 left가 없는경우 -> fNode를 pop 하고 pNode.side에 fNode.right를 붙인다.
        if(fNode.left == null) {
            if (side == null) { //fNode가 head였던경우
                head = fNode.right;
                return fNode.value;
            } else if (side.equals("left")) {
                pNode.left = fNode.right;
                return fNode.value;
            } else {
                pNode.right = fNode.right;
                return fNode.value;
            }
        }
        //2. fNode 에 left가 있는경우
        //2-1. fNode에 left에 right가 없는경우
        if (fNode.left.right == null){
            if (side == null){ //fNode가 head였던경우
                head = fNode.left;
                head.right = fNode.right;
                return fNode.value;
            }else if (side.equals("left")){
                pNode.left = fNode.left;
                pNode.left.right = fNode.right;
                return fNode.value;
            }else{
                pNode.right = fNode.left;
                pNode.right.right = fNode.right;
                return fNode.value;
            }
        }
        //2-2. fNode에 left에 right가 존재 하는경우 -> 그 right에 끝을 뽑아낸다.
        //현재  fNode와 pNode와 side를 찾은 상태 fNode의 오른쪽 끝을 찾아보자.
        Node rNode = fNode.left.right;
        Node rpNode = fNode.left; // rNode에 parent
        while(rNode.right != null){
            rpNode = rNode;
            rNode = rNode.right;
        }
        //rpNode.right에 rNode.left를 붙임. null일수도 있고 아닐수도 잇는데 상관없음. null이면 null이 붙으니 노상관.
        rpNode.right = rNode.left;
        if (side == null){//fNode가 head였던경우
            rNode.left = head.left;
            rNode.right = head.right;
            head = rNode;
        }else if (side.equals("left")){
            rNode.left  = fNode.left;
            rNode.right = fNode.right;
            pNode.left = rNode;
        }else {
            rNode.left = fNode.left;
            rNode.right = fNode.right;
            pNode.right = rNode;
        }
        return fNode.value;
    }









    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertData(5);
        bst.insertData(14);
        bst.insertData(11);
        bst.insertData(1);
        bst.insertData(6);
        bst.insertData(4);
        bst.insertData(9);
        bst.insertData(3);
        bst.insertData(0);
        bst.insertData(15);
        System.out.println(bst.head.value); //5
        System.out.println(bst.head.left.value); //1
        System.out.println(bst.head.left.left.value); //0
        System.out.println(bst.head.left.left.left); //null
        System.out.println(bst.head.left.right.value); //4
        System.out.println(bst.head.left.right.left.value); //3

        System.out.println(bst.head.right.value); //14
        System.out.println(bst.head.right.right.value); //15
        System.out.println(bst.head.right.left.value); //11
        System.out.println(bst.head.right.left.left.value); //6
        System.out.println(bst.head.right.left.left.right.value); //9
        System.out.println(bst.head.right.left.left.left); //null
        System.out.println();


        System.out.println(bst.popData(1)+" <== pop");
        System.out.println(bst.head.value); //5
        System.out.println(bst.head.left.value); //0
        System.out.println(bst.head.right.value); //14
        System.out.println(bst.head.left.right.value); //4
        System.out.println(bst.head.left.right.left.value); //3
        System.out.println();

        System.out.println(bst.popData(14)+" <== pop");
        System.out.println(bst.head.value); //5
        System.out.println(bst.head.right.value); //11
        System.out.println(bst.head.right.left.value); //6
        System.out.println(bst.head.right.right.value); //15
        System.out.println(bst.head.right.left.right.value); //9
        System.out.println(bst.head.right.left.left); //null
        System.out.println();

        System.out.println(bst.popData(5)+" <== pop");
        System.out.println(bst.head.value); //4
        System.out.println(bst.head.left.value); //0
        System.out.println(bst.head.left.right.value); //3
        System.out.println(bst.head.right.value); //11
        System.out.println(bst.head.right.left.value); //6
        System.out.println(bst.head.right.right.value); //15
        System.out.println(bst.head.right.left.right.value); //9

        System.out.println();
        System.out.println(bst.popData(4)+" <== pop");
        System.out.println(bst.head.value); //3
        System.out.println(bst.head.left.right); //null
    }
}

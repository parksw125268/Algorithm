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
}

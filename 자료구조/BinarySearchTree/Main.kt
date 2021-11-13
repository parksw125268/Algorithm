
fun main(){
    val bst = BinarySearchTree().apply {
        insertData(5)
        println( head!!.value )
        insertData(8)
        println( head!!.rNode!!.value )
        insertData(3)
        println( head!!.lNode!!.value )
        insertData(2)
        println( head!!.lNode!!.lNode!!.value )
        insertData(7)
        println( head!!.rNode!!.lNode!!.value )
    }
}

class BinarySearchTree {
    var head : Node? = null
    class Node{
        var value : Int? = null
        var lNode : Node? = null
        var rNode : Node? = null
    }
    fun insertData(inputValue : Int){
        //트리에 아무것도 없는경우
        if (this.head == null){
            this.head = Node().also {
                it.value = inputValue
            }
            return
        }
        var temNode = head
        while(true){
            if (temNode!!.value!! > inputValue){
                if (temNode!!.lNode == null){
                    temNode.lNode = Node().apply {
                        value = inputValue
                    }
                    break
                }else{
                    temNode = temNode.lNode
                }
            }else{
                if (temNode!!.rNode == null){
                    temNode.rNode = Node().apply {
                        value = inputValue
                    }
                    break
                }else{
                    temNode = temNode.rNode
                }
            }
        }
    }
    fun print(){
        //
    }

}
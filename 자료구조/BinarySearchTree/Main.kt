
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
            //데이터가 왼쪽으로 갈지 오른쪽으로 갈지 결정.
            // 그곳에 노드가 있으면 다시 찾고 없으면 그곳에 넣음.
            if (temNode!!.value!! > inputValue){
                if (temNode.lNode == null){
                    temNode.lNode = Node().apply {
                        value = inputValue
                    }
                    break
                }else{
                    temNode = temNode.lNode
                }
            }else{
                if (temNode.rNode == null){
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
    fun popData(inputValue : Int) : Int?{
        if(this.head == null){ //트리에 아무것도 없음.
            return null
        }
        var pNode : Node? = null
        var fNode = head
        var side  : String? = null

        while(true){
            if(fNode!!.value == inputValue){
                break
            }else{
                // inputValue가 더 작음
                if(fNode.value!! > inputValue){
                    if (fNode.lNode == null){
                        return null
                    }else{
                        pNode = fNode
                        side = "left"
                        fNode = fNode.lNode
                    }
                }else{
                    if(fNode.rNode == null){
                        return null
                    }else{
                        pNode = fNode
                        side = "right"
                        fNode = fNode.rNode
                    }
                }
            }
        }
        //찾는 Node와 찾은 Node의 pNode와 pNode에 왼쪽인지 오른쪽인지를 가지고 있음.
        if(side == null){//헤드가 바로 찾던 Data 인 경우.
            val result = head!!.value
            head = null
            return result
        }
        val result = fNode!!.value
        //찾은 노드에 왼쪽 노드가 없는경우(간단)
        if(fNode.lNode == null){
            if (side == "left"){
                pNode!!.lNode = fNode.rNode
            }else{
                pNode!!.rNode = fNode.rNode
            }
            return result
        }
        //찾은 노드에 왼쪽값이 있는경우. 그 왼쪽노드에 가장 오른쪽 노드를 찾아야됨(최대값)
        var temNode = fNode.lNode
        var temParentNode = fNode
        while(true){
            if(temNode!!.rNode == null)
                break
            temParentNode = temNode
            temNode = temNode.rNode
        }
        //찾은 노드의 왼쪽값의 가장 오른쪽끝 값(최대값)에
        //1. 왼쪽 노드가 없는경우


        //2. 왼쪽 노드가 있는경우

    }


    fun print(){
        //
    }

}
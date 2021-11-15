
fun main(){
    val bst = BinarySearchTree().apply {
        { insertData(5)
        println( head!!.value )
        insertData(8)
        println( head!!.rNode!!.value )
        insertData(3)
        println( head!!.lNode!!.value )
        insertData(2)
        println( head!!.lNode!!.lNode!!.value )
        insertData(7)
        println( head!!.rNode!!.lNode!!.value )}
        insertData(5)
        insertData(8)
        insertData(3)
        insertData(2)
        insertData(7)
        insertData(4)
        popData(5)
        popData(4)
        popData(3)
        popData(2)
        popData(7)
        println(head!!.value)
        println(head!!.lNode)
        println(head!!.rNode)
        popData(8)
        println(head)
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
    fun popData(inputValue : Int) : Int?{ // todo 처음 찾은 노득가 head인 경우 도 생각
        if (this.head == null)
            return null
        var pNode : Node? = null
        var pSide : String? = null
        var fNode = this.head

        while (fNode!!.value!! != inputValue){
            if(fNode.value!! > inputValue) {//왼쪽에 있음.
                if (fNode.lNode == null) {//왼쪽노드가 없음.
                    return null
                }
                pSide = "left"
            }else{
                if(fNode.rNode == null){
                    return null
                }
                pSide = "right"
            }
            pNode = fNode
            fNode = fNode.lNode
        }
        //1. 찾은 노드에 left가 null인경우, 그 부모에 side에 fNode에 right를 넣는다.
        if(fNode.lNode == null){
            if (pSide == "left"){
                pNode!!.lNode = fNode.rNode
            }else if (pSide == "right"){
                pNode!!.rNode = fNode.rNode
            }else{
                head = fNode.rNode
            }
            return inputValue
        }else { //2. fNode에 left에 right가 null인경우 -> pNode.side = fNode.left
            if (fNode.lNode!!.rNode == null){
                if(pSide == "left"){
                    pNode!!.lNode = fNode.lNode
                    pNode.lNode!!.rNode = fNode.rNode
                }else if( pSide == "right"){
                    pNode!!.rNode = fNode.lNode
                    pNode.rNode!!.rNode = fNode.rNode
                }else{
                    head!!.lNode!!.rNode = head!!.rNode
                    head = fNode.lNode
                }
                return inputValue
            }
        }
        var tpNode = fNode.lNode//<==
        var tNode = tpNode!!.rNode
        while(tNode!!.rNode != null){
            tpNode = tNode
            tNode = tNode.rNode
        }

        //맨마지막 가지 잘라내서 pop한 자리에 넣기
        if(tNode.lNode == null){   //3. tNode.left가 null -> tpNode.rnode = null
            tpNode!!.rNode = null
        }else{                     //4. tNode.left가 null이 아닌경우  -> tpNode.rnode = tNode.left
            tpNode!!.rNode = tNode.lNode
        }
        // 만약 side 가 null이면 head이므로 head = tNode, tNode.left = head.left, tNode.right = head.right
        // 아니라면 pNode에 붙여줘야함. pNode.side = tNode, tNode.left = fNode.left, tNode.right = fNode.right
        if(pSide == null){
            tNode.lNode = head!!.lNode
            tNode.rNode = head!!.rNode
            head = tNode
        }else{
            if (pSide == "left"){
                pNode!!.lNode = tNode
            }else{
                pNode!!.rNode = tNode
            }
            tNode.lNode = fNode.lNode
            tNode.rNode = fNode.rNode
        }
        return inputValue
    }


    fun print(){
        //
    }

}
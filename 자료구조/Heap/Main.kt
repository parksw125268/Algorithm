import java.util.*

fun main(){
    val heap1 = HeapTest()
    heap1.dataInsert(15)
    heap1.printList()
    heap1.dataInsert(5)
    heap1.printList()
    heap1.dataInsert(20)
    heap1.printList()
    heap1.dataInsert(21)
    heap1.printList()
    heap1.dataInsert(3)
    heap1.printList()
    heap1.dataInsert(12)
    heap1.printList()
    heap1.dataInsert(55)
    heap1.printList()
    heap1.dataInsert(25)
    heap1.printList()
    heap1.dataInsert(45)
    heap1.printList()
    heap1.dataInsert(204)
    heap1.printList()
    println(heap1.pop())
    heap1.printList()
    print(heap1.pop())
    heap1.printList()
    println(heap1.pop())
    heap1.printList()
    println(heap1.pop())
    heap1.printList()
    println(heap1.pop())
    heap1.printList()
    println(heap1.pop())
    heap1.printList()
}
class HeapTest{
    private val heapList= mutableListOf<Int?>()
    private var parentIdx = 0
    private var childIdx = 0

    private fun findPosition(childIdx: Int):Boolean{
        if (childIdx == 1)
            return true
        return (heapList[childIdx]!! < heapList[childIdx/2]!!)
    }
    fun dataInsert(inputData : Int){
        if (heapList.size == 0){
            heapList.add(null)
            heapList.add(inputData)
            return
        }
        heapList.add(inputData)
        childIdx = heapList.size-1

        while(!findPosition(childIdx)){
            val a : Int
            parentIdx = childIdx/2
            swap(childIdx,parentIdx)
            childIdx /= 2
        }
    }
    fun printList(){
        println(heapList)
    }
    fun pop() : Int{
        if(heapList.size <=1 )
            return -1
        if( heapList.size == 2){
            heapList.removeAt(0)
            return heapList.removeAt(0)!!
        }
        val result = heapList[1]!!
        heapList[1] = heapList.removeAt(heapList.size-1)
        var pIdx = 1
        var cIdx = 0

        while(pIdx*2 <= heapList.size-1){ //자식이 있는상태
            //왼쪽에만 있는경우
            if(pIdx*2 == heapList.size-1){
                cIdx = pIdx*2
                if (heapList[pIdx]!! < heapList[cIdx]!!){
                    swap(pIdx,cIdx)
                }
                break
            }else{//왼쪽 오른쪽 둘다 있는경우
                //왼쪽 오른쪽 중 큰쪽을 선택
                if (heapList[pIdx*2]!! > heapList[pIdx*2+1]!!){ //왼쪽이 큰 경우
                    cIdx = pIdx*2
                }else{ //오른쪽이 큰 경우
                    cIdx = pIdx*2+1
                }
                if (heapList[pIdx]!! < heapList[cIdx]!!){
                    swap(pIdx,cIdx)
                }
                pIdx = cIdx
            }
        }
        return result
    }
    private fun swap(idx1:Int, idx2:Int){
        val a = heapList[idx1]
        heapList[idx1] = heapList[idx2]
        heapList[idx2] = a
    }



}
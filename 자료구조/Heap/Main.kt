import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*

fun main(){
    val heap1 = HeapTest()
    heap1.dataInsert(15)
    heap1.dataInsert(5)
    heap1.dataInsert(20)
    heap1.dataInsert(21)
    heap1.dataInsert(3)
    heap1.dataInsert(24)
    heap1.dataInsert(12)
    heap1.dataInsert(55)
    heap1.dataInsert(25)
    heap1.dataInsert(45)
    heap1.dataInsert(204)
    heap1.printList()
    println(heap1.pop())
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

    fun findPosition(childIdx: Int):Boolean{
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
            a = heapList[childIdx]!!
            heapList[childIdx]= heapList[parentIdx]
            heapList[parentIdx]=a
            childIdx /= 2
        }
    }
    fun printList(){
        println(heapList)
    }
    private fun hasChild(pIdx : Int):Boolean{
        return pIdx*2 <= heapList.size-1
    }
    fun pop() : Int{
        if (this.heapList.size <= 1){
            return -1
        }
        if (this.heapList.size ==2){
            return heapList[1]!!
        }
        val result = heapList[1]
        //root 루트에 가장 끝의 노드를 넣고 가장 끝 노드는 삭제
        heapList[1] = heapList.removeAt(heapList.size-1)

        //루트부터 아래로 비교해가며 다시 포지션 세팅
        var pIdx = 1
        var cIdx = 1
        while (hasChild(pIdx)){
            if (pIdx*2+1 <= heapList.size-1){ //왼쪽 오른쪽 둘다 있는경우
                //왼쪽 오른쪽 비교
                if (heapList[pIdx*2]!! > heapList[pIdx*2+1]!!){
                    cIdx = pIdx*2
                }else{
                    cIdx = pIdx*2+1
                }
            }else{//왼쪽만 있는경우
                cIdx = pIdx*2
            }
            if (heapList[pIdx]!! < heapList[cIdx]!!){
                val a = heapList[pIdx]
                heapList[pIdx] = heapList[cIdx]
                heapList[cIdx] = a
                pIdx = cIdx
            }else{
                break
            }
        }
        return result!!
    }


}
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
    println()
    print(heap1.pop())
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
        print(heapList)
    }
    fun pop() : Int{
        return heapList[1] ?: -1
    }


}
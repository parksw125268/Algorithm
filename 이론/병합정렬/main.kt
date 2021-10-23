
import java.util.*

//병합정렬
fun main () {
    val mList = mutableListOf<Int>()
    for (i in 0 until 10){
        mList.add(Random().nextInt(100))
    }
    println(mList)
    println(MergeSort().merge(mList)) //mergesort
}

class MergeSort{
    //반으로 쪽개기
     fun merge(dataList : MutableList<Int>):MutableList<Int>{
        if(dataList.size < 2){
            return dataList
        }
        val middleIdx = dataList.size/2
        var leftList = dataList.subList(0,middleIdx)
        var rightList = dataList.subList(middleIdx,dataList.size)
        leftList = merge(leftList)
        rightList = merge(rightList)
        return mergeList(leftList,rightList)
    }
    fun mergeList(leftList: MutableList<Int> , rightList : MutableList<Int>):MutableList<Int> {
        var lIdx = 0
        var rIdx = 0
        val returnList = mutableListOf<Int>()
        while (leftList.size > lIdx && rightList.size > rIdx) {
            if (leftList[lIdx] < rightList[rIdx]) {
                returnList.add(leftList[lIdx])
                lIdx++
            } else {
                returnList.add(rightList[rIdx])
                rIdx++
            }
        }
        while (leftList.size > lIdx) {
            returnList.add(leftList[lIdx])
            lIdx++
        }
        while (rightList.size > rIdx) {
            returnList.add(rightList[rIdx])
            rIdx++
        }
        return returnList
    }
}

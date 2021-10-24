import java.util.*

//퀵정렬
fun main () {
    val mList = mutableListOf<Int>()
    for (i in 0 until 10){
        mList.add(Random().nextInt(100))
    }
    println(mList)
    println(MyQuickSort().qSort(mList)) //mergesort
}

class MyQuickSort{
    //반으로 쪽개기
    fun qSort(dataList : MutableList<Int>):MutableList<Int>{
        if (dataList.size<2)
            return dataList
        val pivot = dataList[0]
        val leftList = mutableListOf<Int>()
        val rightList = mutableListOf<Int>()
        for(i in 1 until dataList.size){
            if (dataList[i]<pivot){
                leftList.add(dataList[i])
            }else{
                rightList.add(dataList[i])
            }
        }
        val returnList = mutableListOf<Int>()
        returnList.addAll(this.qSort(leftList))
        returnList.add(pivot)
        returnList.addAll(this.qSort(rightList))
        return returnList
    }
}

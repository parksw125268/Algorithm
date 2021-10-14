import java.util.*

fun main() {
    val selectionSort =  SelectionSort()
    val list = mutableListOf<Int>()
    for (i in 0..100){
        list.add(i)
    }
    list.shuffle()
    println(selectionSort.sortFunc(list))
}
//선택정렬
class SelectionSort{
    fun sortFunc(dataList : MutableList<Int>) : MutableList<Int>{
        for (i in 0 until dataList.size){
            var lowIdx = i
            for (j in i until dataList.size){
                if (dataList[lowIdx] > dataList[j]){
                    lowIdx = j
                }
            }
            Collections.swap(dataList,i,lowIdx)
        }
        return dataList
    }

}
import kotlin.random.Random

fun main(){
    val dataList  = mutableListOf<Int>()
    for (i in 0 until 40){
        dataList.add(Random.nextInt(100))
    }
    println(dataList)
    dataList.sort()
    println(dataList)
    println(BinarySearch().binarySearch(dataList,30))
}

class BinarySearch{
    fun binarySearch(dataList : MutableList<Int>, num : Int):Boolean{
        if (dataList.size == 1 && dataList[0] == num) {
            return true
        }
        if (dataList.size == 1 && dataList[0] != num) {
            return false
        }
        if (dataList.size == 0 ){
            return false
        }
        val middleIdx = dataList.size/2

        if (dataList[middleIdx] > num){
            return this.binarySearch(dataList.subList(0,middleIdx) , num)
        }else if (dataList[middleIdx] == num){
            return true
        }else{
            return this.binarySearch(dataList.subList(middleIdx,dataList.size) , num)
        }
    }
}
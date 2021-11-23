import sun.net.idn.StringPrep

fun main(){
    val hash = HashTableWithLinkedList(5).apply{
        println(inputData("박상우1","야호1"))
        println(inputData("박상우2","야호2"))
        println(inputData("박상우3","야호3"))
        println(inputData("박상우4","야호4"))
        println(inputData("박상우5","야호5"))
        println(inputData("박상우4","다시 넣음"))

        println(searchData("박상우1"))//야호1
        println(searchData("박상우2"))//야호2
        println(searchData("박상우3"))//야호3
        println(searchData("박상우4"))//다시 넣음
        println(searchData("박상우5"))//야호5
        println(searchData("박상우4"))//다시 넣음
    }



}

class HashTableWithLinkedList(val size : Int){
    private var dataList : Array<Slot?>
    init {
        this.dataList = Array<Slot?>(this.size,{null})
    }

    class Slot(val key : String, var value : String, var next : Slot? = null ){  }

    private fun hash(inputKey : String):Int{
        var idx  = 0
        for (i in 0..inputKey.length-1){
            idx += inputKey[i].toInt()
        }
        return idx % this.size
    }

    fun inputData(inputKey: String, inputValue:String):Boolean{
        val idx = hash(inputKey)
        var currSlot = dataList[idx]
        var preSlot : Slot?= null
        while (currSlot != null){
            if(currSlot.key == inputKey){
                currSlot.value = inputValue
                return true
            }
            preSlot = currSlot
            currSlot  =  preSlot.next
        }
        if(preSlot == null){
            dataList[idx] = Slot(inputKey,inputValue,null)
        }else{
            preSlot.next = Slot(inputKey,inputValue,null)
        }
        return true
    }

    fun searchData(inputKey: String):String{
        val idx  = hash(inputKey)
        var currSlot = this.dataList[idx]
        while (currSlot != null){
            if(currSlot.key == inputKey){
                return currSlot.value
            }
            currSlot = currSlot.next
        }
        return "찾는 데이터가 존재하지 않습니다. "

    }
}
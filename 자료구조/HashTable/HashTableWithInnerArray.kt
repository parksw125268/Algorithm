fun main(){
    val hash = HashTableWithInnerArray(5).apply {
        println(inputData("박상우1","야호1"))
        println(inputData("박상우2","야호2"))
        println(inputData("박상우3","야호3"))
        println(inputData("박상우4","야호4"))
        println(inputData("박상우5","야호5"))
        println(inputData("박상우6","야호3"))
        println(inputData("박상우5","데이터 바뀐것."))

        println()

        println(searchData("박상우1")) //야호1
        println(searchData("박상우2")) //야호1
        println(searchData("박상우3")) //야호1
        println(searchData("박상우4")) //야호1
        println(searchData("박상우6")) //null
        println(searchData("박상우5")) //데이터 바뀐것.
    }
}

class HashTableWithInnerArray(val size : Int){
    var dataList : Array<Slot?>
    init {
        this.dataList = Array<Slot?>(size,{null})
    }

    class Slot(val key : String, var value : String){ }


    fun hashTable(inputKey: String):Int {
        var idx =0
        for (i in inputKey.indices) {
            idx += inputKey[i].toInt()
        }
        return idx % this.size
    }

    fun inputData(inputKey: String, inputValue : String) : Boolean{
        var idx = hashTable(inputKey)
        var cnt = 0
        while(this.dataList[idx] != null){
            if (++cnt > this.size){
                return false
            }
            if(this.dataList[idx]!!.key == inputKey){
                this.dataList[idx]!!.value = inputValue
                return true
            }
            idx ++
            if(idx == this.size)
                idx = 0
        }
        this.dataList[idx] = Slot(inputKey,inputValue)
        return true
    }

    fun searchData(inputKey: String) : String? {
        var idx = hashTable(inputKey)
        var cnt = 0
        while(this.dataList[idx] != null){
            cnt++
            if (cnt>size) {
                return null
            }
            if(this.dataList[idx]!!.key == inputKey){
                return this.dataList[idx]!!.value
            }
        }
        return null
    }
}
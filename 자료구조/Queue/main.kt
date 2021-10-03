fun main (){
    val mq = MyQueue<Int>().apply {
        enqueue(1)
        enqueue(2)
        enqueue(3)
        println(dequeue())
        println(dequeue())
        println(dequeue())

    }
}

class MyQueue<T>{
    private val queue = mutableListOf<T>()

    fun enqueue(item : T){
        queue.add(item)
    }

    fun dequeue():T{
        return queue.removeAt(0)
    }
}
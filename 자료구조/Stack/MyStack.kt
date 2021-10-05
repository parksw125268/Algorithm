
fun main(){
    val myStack = MyStack<Int>();
    myStack.push(1)
    myStack.push(2)
    println(myStack.pop())  //2
    myStack.push(3)
    println(myStack.pop())  //3
    println(myStack.pop())  //1
    println(myStack.pop())  //null
}

class MyStack <T>{
    val stack = mutableListOf<T>();
    fun push(data :T){
        stack.add(data)
    }

    fun pop():T?{
       if (stack.isEmpty()){
           return null
       }
        return stack.removeAt(stack.size-1)
    }

}
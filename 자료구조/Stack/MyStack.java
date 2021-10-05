import java.util.ArrayList;

public class MyStack <T>{
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T data){
        stack.add(data);
    }

    public T pop(){
        if (stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size()-1);
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());//2
        myStack.push(3);
        System.out.println(myStack.pop());//3
        System.out.println(myStack.pop());//1
    }
}

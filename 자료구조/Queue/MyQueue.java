import java.util.*;

public class MyQueue<T> {
    private ArrayList<T> queue = new ArrayList<T>();

    public void enqueue(T item){
        queue.add(item);
    }

    public T dequeue(){
        if (queue.isEmpty()){
            return null;
        }
        return queue.remove(0);//값을  return해주고 삭제됨.
    }
    public boolean isEmpty(){ //Queue가 비었는지 확인
        return queue.isEmpty();
    }

    public static void main(String[] args){
        MyQueue<Integer> mq = new MyQueue<Integer>();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
    }
}

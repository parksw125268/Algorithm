import java.util.Arrays;

public class MyObjectSort implements Comparable<MyObjectSort>{
    private int a;
    private int b;

    public MyObjectSort(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(MyObjectSort os){
        double Value1 = (double)this.a/(double)this.b*200000;
        double Value2 = (double)os.a/(double)os.b*200000;

        return (int)Value1 - (int)Value2 ;//오름차순 정렬
    }

    public static void main(String[] args) {
        MyObjectSort mos1 = new MyObjectSort(1,3);
        MyObjectSort mos2 = new MyObjectSort(2,5);
        MyObjectSort mos3 = new MyObjectSort(5,3);
        MyObjectSort mos4 = new MyObjectSort(4,4);
        MyObjectSort mos5 = new MyObjectSort(3,7);
        MyObjectSort mos6 = new MyObjectSort(2,1);
        MyObjectSort mos7 = new MyObjectSort(5,4);
        MyObjectSort mos8 = new MyObjectSort(7,5);

        MyObjectSort[] mosArray = {mos1,mos2,mos3,mos4,mos5,mos6,mos7,mos8};
        Arrays.sort(mosArray);
        for (int i=0;i<mosArray.length;i++){
            System.out.println(mosArray[i].b);
        }

    }
}

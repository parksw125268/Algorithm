import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyComparable {
    public static void main(String[] args) {
        Point a = new Point(1);
        Point b = new Point(3);
        Point c = new Point(2);
        Point d = new Point(6);
        Point e = new Point(2);
        Point f = new Point(3);


        Point[] p = {a,b,c,d,e,f};
        Arrays.sort(p);
        for (int i=0;i<p.length;i++){
            System.out.println(p[i].x);
        }
    }

    static class Point implements Comparable<Point>{
        private int x;
        public Point(int x){
            this.x = x;
        }
        @Override
        public int compareTo(Point p){
            return this.x - p.x;   //this - 객체 >> 오름차순
           // return p.x - this.x; //객체 - this >> 내림차순
        }
    }
}

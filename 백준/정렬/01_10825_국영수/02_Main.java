import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static String name;
    static int p1;
    static int p2;
    static int p3;
    static ArrayList<Student> aList = new ArrayList<Student>();

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            p1 = Integer.parseInt(st.nextToken());
            p2 = Integer.parseInt(st.nextToken());
            p3 = Integer.parseInt(st.nextToken());
            aList.add(new Student(name,p1,p2,p3));
        }
    }
    static void work(){
        Collections.sort(aList);
        for(int i=0;i<aList.size();i++){
            sb.append(aList.get(i).getName()+"\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        work();
        System.out.println(sb.toString());
    }
}
class Student implements Comparable<Student>{
    private String name;
    private int point1;
    private int point2;
    private int point3;
    public Student(String name,int point1,int point2,int point3){
        this.name = name;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }
    @Override
    public int compareTo(Student s){
        if(this.point1 != s.point1) {
            return s.point1 - this.point1;//내림
        }else if(this.point2 != s.point2){
            return this.point2 - s.point2;//오름
        }else if(this.point3 != s.point3){
            return s.point3 - this.point3;//내림
        }else{
            return this.name.compareTo(s.name);//오름차순
        }
    }

    public String getName(){
        return this.name;
    }
}

import java.util.*;

public class N_Queen {
    private int count;
    public N_Queen(){
        this.count = 0;
    }
    public void printFunc(){
        System.out.println("경우의 수 : "+this.count);
    }
    public void solution(int n, int row, ArrayList<Integer> arrayList){
        if(row == n) {
            count++;
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++){
            if(isCheck( i, arrayList)){
                arrayList.add(i);
                solution(n,row+1,arrayList);
                arrayList.remove(arrayList.size()-1);
            }
        }
    }
    private boolean isCheck(int col, ArrayList<Integer> aList){
        if (aList.size() == 0){
            return true;
        }
        //1.세로체크
        for(int i=0;i<aList.size();i++){
            if(aList.get(i) == col){
                return false;
            }
        }
        //2.대각체크
        for(int i=0;i<aList.size();i++){
            if(Math.abs(aList.size()-i) == Math.abs(col - aList.get(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        N_Queen nq = new N_Queen();
        nq.solution(n,0,new ArrayList<Integer>());
        nq.printFunc();
    }

}

import java.util.*;
class Main{
  static String[] cand = {"A","B","C","D"};
  static int[] selected;
  static int pickCnt = 3;
  static String[] ansArr;
  public static void main(String[] args){
    ansArr = new String[pickCnt];
    //work1(0); //중복을 허용해서 순서 상관있이
    //work2(0,0); //중복을 허용하고 순서 상관 없이
    //selected = new int[cand.length];
    //work3(0);//중복을 허용하지 않고 순서 상관있이
    work4(0,0);//중복을 허용하지 않고 순서 상과없이

  }
  static void work1(int idx){
    if(idx == pickCnt){
      System.out.println(Arrays.toString(ansArr));
      return;   
    }
    for(int i=0;i<cand.length;i++){
      ansArr[idx] = cand[i];
      work1(idx+1);
    }
  }
  static void work2(int idx,int startIdx){
    if(idx == pickCnt){
      System.out.println(Arrays.toString(ansArr));
      return;
    }
    for(int i=startIdx;i<cand.length;i++){
      ansArr[idx] = cand[i];
      work2(idx+1,i);
    }
  }
   
  static void work3(int idx){
    if(idx == pickCnt){
      System.out.println(Arrays.toString(ansArr));
      return;
    }
    for(int i=0;i<cand.length;i++){
      if (selected[i] == 0){
        selected[i] = 1;
        ansArr[idx] = cand[i];
        work3(idx+1);
        selected[i] = 0;
      }
    }
  }
  static void work4(int idx, int startIdx){
    if(idx == pickCnt){
      System.out.println(Arrays.toString(ansArr));
      return;
    }
    for(int i=startIdx ;i<cand.length;i++){
      ansArr[idx] = cand[i];
      work4(idx+1,i+1);
    }
  }
}
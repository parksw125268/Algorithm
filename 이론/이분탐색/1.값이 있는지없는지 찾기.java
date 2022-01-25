import java.util.*;
public class Main {
    private static int[] arr;

    public static void main(String[] args) {
        arr = new int[20];
        for(int i=0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*100);
        }
        Arrays.sort(arr); //**정렬 필수 
        System.out.println(Arrays.toString(arr));
        binarySearch(30);
    }

    private static void binarySearch(int value){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == value){
                System.out.println("찾는 값의 idx는 "+mid+" 입니다.");
                return;
            }else if(arr[mid] < value){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        System.out.println("찾는 값이 없습니다.");
    }

}
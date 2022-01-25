import java.util.*;
public class Main {
    private static int[] arr;

    public static void main(String[] args) {
        arr = new int[20];
        for(int i=0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*100);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        binarySearch(30);
    }

    static void binarySearch(int value){
        int left = 0;
        int right = arr.length-1;
        int ans = arr.length; //값이 왼쪽에 있으면 왼쪽 끝 idx,오른쪽에 있으면 오른쪽 idx
        while(left<=right){
            int mid=(left+right)/2;
            if(value < arr[mid]){ //이상이면 '<=', 초과면 '<' mid가 ans임 mid기준으로 생각
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(value+"보다 큰 값은 idx "+ans+" 부터 시작됩니다.");
    }

}
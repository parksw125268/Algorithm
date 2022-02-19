import java.util.*;
class Main{
    public static void main(String[] args) {
        ArrayList<Integer> aList = new ArrayList<>();
        for(int i =0;i<10;i++){
            aList.add((int)(Math.random()*100));
        }
        System.out.println(aList);
        Collections.sort(aList);
        System.out.println(aList);
        System.out.println(binarySearch(51,aList));
    }

    private static int binarySearch(int value,ArrayList<Integer> aList ){
        int left = 0;
        int right = aList.size()-1;
        int ans = -1;
        while(left<=right){
            int mid = (left+right)/2;
            if(aList.get(mid) == value){
                ans = mid;
                break;
            }else if(value > aList.get(mid) ){
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}
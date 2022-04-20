import java.util.*;
class Solution {
    int[] people; int limit;
    int cnt=0;
    public int solution(int[] people, int limit) {
        this.people = people; this.limit = limit;
        Arrays.sort(people); //init;
        work();
        return cnt;
    }
    void work(){
        int left = 0;
        int right = people.length-1;
        while(left<right){
            cnt++;
            if(people[left] + people[right] <= limit ){
                left++; right--;
            }else{
                right--;
            }
        }
        if(left == right) cnt++;
    }
}
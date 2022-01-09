class Solution {
    public long solution(int price, long money, int count) {
        long sum = (long)price*(1+count)*count/2;
        if(sum > money){
            return sum - money;
        }
        return 0;
    }
}
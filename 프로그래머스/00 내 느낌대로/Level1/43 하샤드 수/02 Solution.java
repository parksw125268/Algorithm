class Solution {
    public boolean solution(int x) {
        String s = Integer.toString(x);
        int div = 0;
        for(int i = 0; i< s.length(); i++){
            div += Integer.parseInt(s.substring(i,i+1));
        }
        return x % div == 0;
    }
}
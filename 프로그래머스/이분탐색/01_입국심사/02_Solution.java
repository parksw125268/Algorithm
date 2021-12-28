class Solution{
    public long solution(int n, int[] times) {
        long answer = 0;
        long[] passed = new long[times.length];
        for (int cnt=0;cnt<n;cnt++){
            int idx = 0;
            long min = 0;
            for(int i=0;i<times.length;i++){
                if(i==0){
                    min = passed[i]+times[i];
                }else{
                    if(min > passed[i]+times[i]){
                        min = passed[i]+times[i];
                        idx = i;
                    }
                }
            }
            passed[idx] += times[idx];
        }

        for(int i=0;i<times.length;i++){
            answer = getMax(answer,passed[i]);
        }
        return answer;
    }
    private long getMax(long a, long b){
        if (a>b)
            return a;
        else
            return b;
    }
}
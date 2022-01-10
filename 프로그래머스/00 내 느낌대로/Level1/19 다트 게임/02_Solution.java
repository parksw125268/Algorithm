class Solution {
    private String dartResult;
    private String[] scores = new String[3];
    private int[] eachValues = new int[3];;
    public int solution(String dartResult) {
        this.dartResult = dartResult;
        devideScores();
        calcScores();

        int answer = eachValues[0] + eachValues[1] + eachValues[2];
        return answer;
    }
    private void calcScores(){
        for(int i = 0; i< scores.length; i++){
            if(isNumber(scores[i].charAt(1))){ //1번이 숫자라는것은 10 이라는뜻.
                eachValues[i] = 10;
                eachValues[i] = doubleCalc(eachValues[i],scores[i].substring(2,3));
            }else{
                eachValues[i] = Integer.parseInt(scores[i].substring(0,1));
                eachValues[i] = doubleCalc(eachValues[i],scores[i].substring(1,2));
            }
            String last = scores[i].substring(scores[i].length()-1,scores[i].length());
            if(!isAlpha(last.charAt(0))){
                if(last.equals("#")){
                    eachValues[i] *= -1;
                }else{
                    eachValues[i] *= 2;
                    if(i != 0){
                        eachValues[i-1] *= 2;
                    }
                }
            }
        }
    }
    private int doubleCalc(int value1, String sdt){
        if(sdt.equals("D")){
            value1 = (int)Math.pow(value1,2);
        }else if(sdt.equals("T")){
            value1 = (int)Math.pow(value1,3);
        }
        return value1;
    }

    private void devideScores(){
        String before = "num";
        int idx = 0;
        int from = 0;
        for(int i=0;i<dartResult.length();i++){
            if(isNumber(dartResult.charAt(i))){
                if(before.equals("char")){
                    scores[idx] = dartResult.substring(from,i);
                    from = i;
                    idx++;
                }
                before = "num";
            }else{
                before = "char";
            }

            if(i == dartResult.length()-1){
                scores[idx] = dartResult.substring(from,i+1);
            }
        }
    }
    private boolean isNumber(char c){
        if (48 <= c && c <=57){
            return true;
        }
        return false;
    }
    private boolean isAlpha(char c){
        if (65 <= c && c <=90){
            return true;
        }
        return false;
    }
}
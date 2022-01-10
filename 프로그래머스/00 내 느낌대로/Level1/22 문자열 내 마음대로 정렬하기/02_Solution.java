import java.util.*;
class Solution {
    private int n;
    public String[] solution(String[] strings, int n) {
        this.n = n;
        Some[] somes = new Some[strings.length];
        for (int i=0;i<strings.length;i++){
            somes[i] = new Some(strings[i]);
        }
        Arrays.sort(somes);
        String[] answer = new String[strings.length];
        for (int i=0;i<strings.length;i++){
            answer[i] = somes[i].s;
        }
        return answer;
    }

    class Some implements Comparable<Some>{
        private String s;
        private String cutString;
        public Some(String s){
            this.s = s;
            this.cutString = s.substring(n,n+1);
        }

        @Override
        public int compareTo(Some s){
            if(this.cutString.equals(s.cutString)){
                return this.s.compareTo(s.s);    
            }
            return this.cutString.compareTo(s.cutString);
        }
    }
}
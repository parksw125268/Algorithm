class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int cnt = 0 ;
        int faker = 0;

        //잃어버린 애들을 오름차순으로 정렬을 한다. 버블정렬 (정렬 안해서 던져주는거 실화야~~???)
        for(int i = 0 ; i<lost.length -1 ; i++){
            for(int j = i ; j<lost.length -1 ;j++){
                if(lost[j]>lost[j+1]){
                    int a = lost[j];
                    lost[j] = lost[j+1];
                    lost[j+1] = a;
                }
            }
        }


        //1. 체육복 가져왔는데 도둑맞은 허수를 제거한다.
        for(int i = 0 ; i < reserve.length; i++){
            for(int j = 0;j<lost.length;j++){
                if(reserve[i] == lost[j]){
                    reserve[i] = -1;
                    lost[j] = -1;
                    faker++;
                    break;
                }
            }
        }
        //2. 잃어버린 애를 돌면서 앞번호에 먼저 있는지 보고 그다음 뒷번호를 본다. 빌렸으면 빌려준애는 -1로 바꾼다.
        for(int i = 0 ; i < lost.length ; i++){
            if (lost[i] == -1){ //잃어버렸으나 여분 갖져온 애 pass
                continue;
            }
            boolean get = false;
            //자기보다 빠른 번호에서 빌려보고
            for(int j=0; j<reserve.length; j++){
                if (lost[i]-1 == reserve[j]){
                    reserve[j] = -1;
                    cnt++;
                    get = true;
                    break;
                }
            }
            //앞번호에서 빌려봤는데 못빌림. 뒷번호에 빌려봄.
            if (!get){
                for(int j=0; j<reserve.length; j++){
                    if (lost[i]+1 == reserve[j]){
                        reserve[j] = -1;
                        cnt++;
                        break;
                    }
                }
            }
        }

        //반 인원 - 잃어버린애 + 잃어버렸지만 여분 가져온애 + 빌린애
        answer = n - lost.length + faker + cnt;
        return answer;
    }


   /* public static void main(String[] args) {
        Solution  s = new  Solution();
        int[] lost = {3,1};
        int[] reserve = {2,4};

        System.out.print(s.solution(5,lost,reserve));
    }*/
}
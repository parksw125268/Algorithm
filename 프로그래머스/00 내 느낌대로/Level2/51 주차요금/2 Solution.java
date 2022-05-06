import java.util.*; //0: 시간, 1:차번호
class Solution {
    int[] fees; String[] records;
    HashMap<String,String> carHash = new HashMap<>();//차량 입출차
    HashMap<String,Integer> feeHash = new HashMap<>();//차량별 요금
    ArrayList<String> carList = new ArrayList<>();
    int[] answer;
    public int[] solution(int[] fees, String[] records) {
        this.fees = fees;  this.records = records;
        work();
        return answer;
    }
    void carOut(String[] temArr){
        String srtTime = carHash.remove(temArr[1]);
        int srtHour = Integer.parseInt(srtTime.substring(0,2));
        int srtMin  = Integer.parseInt(srtTime.substring(3,5));
        int endHour = Integer.parseInt(temArr[0].substring(0,2));
        int endMin  = Integer.parseInt(temArr[0].substring(3,5));
        int totTime = 60-srtMin;
        totTime += (endHour - srtHour - 1)*60 ;
        totTime += endMin;
        if(!feeHash.containsKey(temArr[1])){//없으면 생성
            feeHash.put(temArr[1],totTime);    
            carList.add(temArr[1]);
        }else{//있으면 추가 
            int temTime = feeHash.remove(temArr[1]);
            feeHash.put(temArr[1],temTime+totTime);    
        }
    }
    void work(){
        for(int i=0;i<records.length;i++){
            String[] temArr = records[i].split(" ");
            if(!carHash.containsKey(temArr[1])){ //입차
                carHash.put(temArr[1],temArr[0]);
            }else{ //출차
                carOut(temArr);
            }
        }
        if(carHash.size() > 0){
            ArrayList<String> keyList = new ArrayList<>();
            for(String key : carHash.keySet()){
                keyList.add(key);
            }
            for(int i=0;i<keyList.size();i++){
                String temArr[] = {"23:59",keyList.get(i)};
                carOut(temArr);
            }
        }
        calcFee();
    }
    
    void calcFee(){
        answer = new int[carList.size()];
        Collections.sort(carList); //차 번호 작은순으로 
        for(int i=0;i<carList.size();i++){
            String key = carList.get(i);
            int time = feeHash.get(key);
            if(time <= fees[0]){//기본요금
                answer[i] = fees[1];   
            }else{
                time -= fees[0];
                answer[i] = fees[1];   
                int m = time/fees[2];
                int n = time%fees[2];
                if(n > 0) m++;
                answer[i] += m*fees[3];
            }
        }
    }    
}
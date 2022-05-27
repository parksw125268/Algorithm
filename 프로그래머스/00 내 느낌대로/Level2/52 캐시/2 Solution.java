import java.util.*;
class Solution {
    int cacheSize; String[] cities; int answer;
    ArrayList<String> aList = new ArrayList<>();
    public int solution(int cacheSize, String[] cities) {
        this.cacheSize = cacheSize; this.cities = cities;
        this.answer = 0;
        work();
        return answer;
    }
    void work(){
        for(int i=0;i<cities.length;i++){
            String city = cities[i].toUpperCase();
            if(aList.contains(city)){
                answer++;
                aList.remove(aList.indexOf(city));
                aList.add(city);
            }else{
                answer += 5;
                aList.add(city);
                if(aList.size() > cacheSize)
                    aList.remove(0);
            }
        }
    }
}
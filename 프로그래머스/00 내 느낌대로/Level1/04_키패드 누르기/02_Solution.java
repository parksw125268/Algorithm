import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        HashMap<Integer, ArrayList<Integer>> lGraph = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> rGraph = new HashMap<>();
        graphSet(lGraph, "l");
        graphSet(rGraph, "r");
        String answer="";
        int lStatus = - 7;
        int rStatus = - 5;
        for (int i=0;i<numbers.length;i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7 ){
                lStatus = numbers[i] ;
                answer = answer+"L";
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                rStatus =  numbers[i];
                answer = answer+"R";
            }else{
                if(getDistance(lStatus,numbers[i],lGraph) < getDistance(rStatus,numbers[i],rGraph)){//왼쪽이 더 가까움
                    lStatus = numbers[i] ;
                    answer = answer+"L";
                }else if(getDistance(lStatus,numbers[i],lGraph) > getDistance(rStatus,numbers[i],rGraph)){//오른쪽이 더 가까움
                    rStatus = numbers[i] ;
                    answer = answer+"R";
                }else{ //거리 같음
                    if(hand.equals("left")){
                        lStatus = numbers[i] ;
                        answer = answer+"L";
                    }else{
                        rStatus = numbers[i] ;
                        answer = answer+"R";
                    }
                }
            }
        }
        return answer;
    }
    
    private void graphSet(HashMap<Integer, ArrayList<Integer>> graph, String hand){
        if (hand.equals("l")){
            graph.put(1, new ArrayList<Integer>(Arrays.asList(2,4)));  
            graph.put(4, new ArrayList<Integer>(Arrays.asList(1,5,7)));  
            graph.put(7, new ArrayList<Integer>(Arrays.asList(4,8,-7)));  
            graph.put(-7, new ArrayList<Integer>(Arrays.asList(7,0)));  
            graph.put(2, new ArrayList<Integer>(Arrays.asList(1,5)));  
            graph.put(5, new ArrayList<Integer>(Arrays.asList(2,4,8)));  
            graph.put(8, new ArrayList<Integer>(Arrays.asList(5,7,0)));  
            graph.put(0, new ArrayList<Integer>(Arrays.asList(-7,8)));  
        }else{
            graph.put(2, new ArrayList<Integer>(Arrays.asList(3,5)));  
            graph.put(5, new ArrayList<Integer>(Arrays.asList(2,6,8)));  
            graph.put(8, new ArrayList<Integer>(Arrays.asList(5,9,0)));  
            graph.put(0, new ArrayList<Integer>(Arrays.asList(8,-5)));  
            graph.put(3, new ArrayList<Integer>(Arrays.asList(2,6)));  
            graph.put(6, new ArrayList<Integer>(Arrays.asList(3,5,9)));
            graph.put(9, new ArrayList<Integer>(Arrays.asList(6,8,-5)));  
            graph.put(-5, new ArrayList<Integer>(Arrays.asList(9,0)));  
            
        }
    }
    private int getDistance(int fromA, int  toA, HashMap<Integer, ArrayList<Integer>> graph ){
        ArrayList<Integer> ableList = new ArrayList<Integer>();
        ableList.add(fromA);
        int cnt = 0;
        while(!ableList.contains(toA)){
            cnt++;
            int size = ableList.size();
            for(int i=0;i<size;i++){
                ArrayList<Integer> addedList = graph.get(ableList.get(i));
                for(int j=0;j<addedList.size();j++){
                    ableList.add(addedList.get(j));
                }
            }
        }
        return cnt;
    }
}
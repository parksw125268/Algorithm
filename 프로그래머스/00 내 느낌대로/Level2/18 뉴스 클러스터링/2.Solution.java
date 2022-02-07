import java.util.*;
class Solution {
    ArrayList<String> aList = new  ArrayList<>();
    ArrayList<String> bList = new  ArrayList<>();
    int hab = 0; //합집합
    int gyo = 0; //교집합 
    public int solution(String str1, String str2) {
        aList= makeList(str1);
        bList= makeList(str2);
        if(aList.size()==0 && bList.size()!=0){
            return 0;
        }else if(aList.size()!=0 && bList.size()==0){
            return 0;
        }else if(aList.size()==0 && bList.size()==0){
            return 65536;
        }
        
        counting();
        
        double answer = (double)gyo/hab * 65536;
        System.out.println(answer);
        return (int)answer;
    }
    private void counting(){
        for (int i=0;i<aList.size();i++){
            if(bList.contains(aList.get(i))){
                gyo++;
                hab++;
                bList.remove(bList.indexOf(aList.get(i)));
            }else{
                hab++;
            }
        }    
        hab += bList.size();
    }
    
    private ArrayList<String> makeList(String s){
        s = s.toUpperCase();
        ArrayList<String> aList = new ArrayList<>();
        for(int i=0;i<s.length()-1;i++){
            if(isAlpha(s.charAt(i)) && isAlpha(s.charAt(i+1))){
                aList.add(s.substring(i,i+2));
            }
        }
        return aList;
    }
    private boolean isAlpha(char c){
        if('A' <= c && c <= 'Z'){
            return true;
        }   
        return false;
    }
}

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String,String> hash = new HashMap<>();
        for(int i=0;i<phone_book.length;i++){
            for(int j=1;j<phone_book[i].length();j++){
                hash.put(phone_book[i].substring(0,j),phone_book[i].substring(j,phone_book[i].length()));
            }
        }
        for(int i=0;i<phone_book.length;i++){
            if(hash.get(phone_book[i]) != null){
                return false;
            }
        }
        return true;
        
    }
}
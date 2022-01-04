import java.util.*;
class Solution {
    public String solution(String new_id) {
        new_id = work1(new_id);
        new_id = work2(new_id);
        new_id = work3(new_id);
        new_id = work4(new_id);
        if (new_id.equals("")){
            return "aaa";
        }
        new_id = work6(new_id);
        new_id = work7(new_id);
        return new_id;
    }

    private String work1(String s){
        for(int i='A' ; i< 'Z'+1 ; i++){
            s = s.replace((char)i,(char)(i+32));
        }
        return s;
    }

    private String work2(String s){
        String notChar = "~!@#$%^&*()=+[{]}:?,<>/";
        for(int i=0 ; i< notChar.length() ; i++){
            s = s.replace(notChar.substring(i,i+1),"");
        }
        return s;
    }
    private String work3(String s){
        while (s.contains("..")){
            s = s.replace("..",".");
        }
        return s;
    }
    private String work4(String s){
        if(s.length() > 0){
            if(s.substring(0, 1).equals(".")){
                s = s.substring(1,s.length());
            }
        }
        if(s.length() > 0 ){
            if( s.substring(s.length()-1,s.length()).equals(".")){
                s = s.substring(0,s.length()-1);
            }
        }
        return s;
    }
    private String work6(String s){
        if (s.length() > 15){
            s = s.substring(0,15);

            if(s.substring(14,15).equals(".")){
                s = s.substring(0,14);
            }
        }
        return s;
    }
    private String work7(String s){
        String a = "";
        if (s.length() <= 2){
            a = s.substring(s.length()-1 , s.length());
            while(s.length() < 3){
                s = s + a;
            }
        }
        return s;
    }

}
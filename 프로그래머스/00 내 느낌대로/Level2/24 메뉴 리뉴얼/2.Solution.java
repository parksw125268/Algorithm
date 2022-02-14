import java.util.*;
class Solution {
    String[] orders; int[] course; ArrayList<String> ansList = new ArrayList<>();
    int menuCnt; String[] selected; String order = "";
    ArrayList<String> middleList;
    public String[] solution(String[] orders, int[] course) {
        this.orders=orders;
        this.course=course;
        
        ordersSort(); 
        
        for(int i=0;i<course.length;i++){
            menuCnt = course[i]; //메뉴 개수대로 목록 만들기
            bruteForce();
        }
        Collections.sort(ansList);
        String[] answer = new String[ansList.size()];
        for(int i=0;i<ansList.size();i++){
            answer[i] = ansList.get(i);
        }
        return answer;
    }
    private void getCourseMenu(){
        ArrayList<Integer> aList = new ArrayList<>();
        int cnt = 1;
        int max = -1;
        middleList.add("LAST"); //마지막값 비교를 위해 추가
        for(int i=1;i<middleList.size();i++){
            if(middleList.get(i).equals(middleList.get(i-1))){
                cnt++;
            }else{
                if(cnt >= 2){
                    if(max == cnt){
                        aList.add(i-1);
                    }else if(max < cnt){
                        max = cnt;
                        aList.clear();
                        aList.add(i-1);
                    }
                }
                cnt = 1;
            }
        }
        for(int i=0;i<aList.size();i++){
            ansList.add(middleList.get(aList.get(i)));
        }
    }

    private void bruteForce(){
        middleList = new ArrayList<>();
        for(int i=0;i<orders.length;i++){
            order = orders[i];
            selected = new String[menuCnt];
            dfs(0,0);
        }
        Collections.sort(middleList);
        getCourseMenu();
    }

    private void dfs(int idx, int start){
        if(idx == menuCnt){
            String s= "";
            for(int i =0;i<selected.length;i++) {
                s += selected[i];
            }
            middleList.add(s);
            return;
        }
        for(int i=start ; i< order.length() ; i++){
            selected[idx] = order.substring(i,i+1);
            dfs(idx+1,i+1);
        }
    }
    
    private void ordersSort(){
        for(int i=0;i<orders.length;i++){
            ArrayList<String> sList = new ArrayList<>();
            for(int j=0;j<orders[i].length();j++){
                sList.add(orders[i].substring(j,j+1));
            }
            Collections.sort(sList);
            String s = "";
            for(int j=0;j<sList.size();j++){
                s += sList.get(j);
            }
            orders[i] = s;
        }
    }

}
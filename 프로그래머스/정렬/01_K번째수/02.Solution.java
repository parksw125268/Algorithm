import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> sortList = new ArrayList<>();
        MyMergeSort ms = new MyMergeSort();

        for (int i=0;i<commands.length;i++){
            sortList.clear();
            for (int j=commands[i][0]-1;j<commands[i][1];j++){
                sortList.add(array[j]);
            }
            sortList = ms.sortFunc(sortList);
            answer[i] = sortList.get(commands[i][2]-1);
        }

        return answer;
    }

    class MyMergeSort{
        public ArrayList<Integer> sortFunc (ArrayList<Integer> aList){
            //조건 맞으면 return
            if(aList.size() == 1){
                return aList;
            }else if(aList.size() == 2 && aList.get(0)>aList.get(1)){
                int a = aList.get(0);//바꾸기
                aList.set(0,aList.get(1));
                aList.set(1,a);
                return aList;
            }

            //반복적으로 하는 행위
            //반으로 잘라서 재귀보내고 돌아온걸로 정력하고 다시 보내고
            ArrayList<Integer> leftList = new ArrayList<>(aList.subList(0, aList.size()/2 ));
            ArrayList<Integer> rightList = new ArrayList<>(aList.subList(aList.size()/2, aList.size()));
            leftList = sortFunc(leftList);
            rightList = sortFunc(rightList);

            ArrayList<Integer> returnList = new ArrayList<>();
            //정력해가지고 다시 return
            while(leftList.size() != 0 || rightList.size() != 0){
                //1.둘다 안끝난경우, 2. 왼쪽이 끝난경우, 3. 오른쪽이 끝난경우
                if(leftList.size() != 0 && rightList.size() != 0){      //1.
                    if(leftList.get(0) < rightList.get(0)){
                        returnList.add(leftList.remove(0));
                    }else{
                        returnList.add(rightList.remove(0));
                    }
                }else if(leftList.size() == 0){                         //2.
                    for(int i=0;i<rightList.size();i++){
                        returnList.add(rightList.remove(0));
                    }
                }else{                                                  //3.
                    for(int i=0;i<leftList.size();i++){
                        returnList.add(leftList.remove(0));
                    }
                }
            }
            return returnList;
        }
    }
}
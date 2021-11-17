class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashTable hTable = new HashTable(completion.length);
        for (int i= 0; i<completion.length; i++){
            hTable.insertData(completion[i]);
        }

        for (int i= 0; i<participant.length; i++){
            if (!hTable.searchData(participant[i])){
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
    public  class HashTable{
        int size;
        Slot[] slots;

        public HashTable(int size) {
            this.size = size;
            this.slots = new Slot[size];
        }

        public class Slot{
            String key;
            Slot next;
            public Slot(String key){
                this.key = key;
            }
        }

        public int hashFunc(String  inputKey){
            int a = 0;
            for(int i = 0 ; i< inputKey.length() ; i++){
                a += (int)inputKey.charAt(i);
            }
            return a % this.size;
        }

        public void insertData(String inputKey){
            //insertData()  동일 데이터가 들어오면 그에 다음 링크에 넣어주자.
            int idx = hashFunc(inputKey);
            Slot cSlot = slots[idx];
            Slot pSlot = null;
            while (cSlot != null){
                pSlot = cSlot;
                cSlot = cSlot.next;
            }
            if(pSlot == null) {
                slots[idx] = new Slot(inputKey);
            }else{
                pSlot.next = new Slot(inputKey);
            }
        }

        public Boolean searchData(String inputKey){
            //searchData()  search하고 나면 걔를 ""로 바까주기.
            int idx = hashFunc(inputKey);
            Slot cSlot = slots[idx];

            while(cSlot != null){
                if(cSlot.key .equals( inputKey)){
                    cSlot.key = "";
                    return true;
                }
                cSlot = cSlot.next;
            }
            return false;
        }
    }
}
public class HashTableWithLinkedList {
    Slot[] slots;
    int slotSize ;
    public HashTableWithLinkedList(int size){
        this.slotSize = size;
        this.slots = new Slot[size];
    }
    //데이터가 저장될 수 있는공간 = Slot

    private static class Slot{
        String key ;
        String value;
        Slot next;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private int hashTable(String key){
        char a = key.charAt(0); //key에 첫글자를 따옴.
        //걔를 숫자로 변환.
        return (int)a % this.slotSize;
    }
    public boolean inputData(String inputKey,String inputValue){
        int idx = hashTable(inputKey);
        //해당 idx에 slot이 없다면 걍 집어넣고 있다면 key가 같은지 비교하고 없다면 linkedlist로 연결하여 저장한다.
        //1. 해당 idx에 slot이 없는경우.
        if(this.slots[idx] == null){
            this.slots[idx] = new Slot(inputKey,inputValue);
            return true;
        }
        //2. 해당 idx에 slot이 있는경우 -> key가 같은지 확인하고 같으면 덮어쓰고 안같으면 옆으로 이동.
        Slot pSlot = null;
        Slot cSlot = this.slots[idx];
        while (cSlot!=null) {
            if (cSlot.key.equals(inputKey)) {
                cSlot.value = inputValue;
                return true;
            }else{
                pSlot = cSlot;
                cSlot = pSlot.next;
            }
        }
        cSlot = new Slot(inputKey,inputValue);
        return true;
    }
    public String getData(String inputKey){
        int idx = hashTable(inputKey);
        if (this.slots[idx] == null){
            return null;
        }
        Slot pSlot = null;
        Slot cSlot = this.slots[idx];
        while (cSlot!=null) {
            if (cSlot.key.equals(inputKey)) {
                return cSlot.value;
            }
            pSlot = cSlot;
            cSlot = pSlot.next;
        }
        return null;
    }

    public static void main(String[] args) {
        HashTableWithLinkedList hash = new HashTableWithLinkedList(20);

        System.out.println(hash.inputData("Park","010-1111-1111"));
        System.out.println(hash.inputData("Psdd","010-2222-2222"));
        System.out.println(hash.getData("Park"));
        System.out.println(hash.getData("Psdd"));

    }
}

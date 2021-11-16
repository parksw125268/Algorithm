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
    public boolean inputData(String key,String value){
        int idx = hashTable(key);
        this.slots[idx] = new Slot(key,value);
        return true;
    }
    public String getData(String key){
        int idx = hashTable(key);
        if (slots[idx] == null){
            return null;
        }else {
            return this.slots[idx].value;
        }
    }

    public static void main(String[] args) {
        HashTableWithLinkedList hash = new HashTableWithLinkedList(20);
        System.out.println(hash.inputData("Park","010-1111-1111"));
        System.out.println(hash.inputData("Psdd","010-2222-2222"));
        System.out.println(hash.getData("Park"));

    }
}

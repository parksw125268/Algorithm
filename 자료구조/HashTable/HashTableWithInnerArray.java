public class HashTableWithInnerArray {
    Slot[] dataArray;
    int  size;
    public HashTableWithInnerArray(int size){
       this.size = size;
       dataArray  =  new Slot[size];
    }

    private class Slot{
        String key;
        String value;
        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hashFun(String inputKey){
        int idx=0;
        for(int i=0 ; i<inputKey.length() ; i++){
            idx += (int)(inputKey.charAt(i));
        }
        return idx % size;
    }

    public boolean inputData(String inputKey, String inputValeu){
        int idx = hashFun(inputKey);
        int cnt = 0;

        while(this.dataArray[idx] != null){
            cnt ++;
            if (cnt > size){
                return false;
            }
            if(this.dataArray[idx].key.equals(inputKey)){
                this.dataArray[idx].value = inputValeu;
                return true;
            }
            if(idx == size-1){
                idx = 0;
            }else{
                idx += 1;
            }
        }
        this.dataArray[idx] = new Slot(inputKey, inputValeu);
        return true;
    }

    public String getData(String inputKey){
        int idx = hashFun(inputKey);
        int cnt = 0;

        while(this.dataArray[idx]!=null){
            cnt ++;
            if (cnt > size){
                return null;
            }
            if(this.dataArray[idx].key.equals( inputKey)){
                return this.dataArray[idx].value;
            }
            if(idx == size-1){
                idx = 0;
            }else{
                idx += 1;
            }
        }
        return null;
    }

    public static void main(String args[]){
        HashTableWithInnerArray hash = new HashTableWithInnerArray(3);
        System.out.println(hash.inputData("박상우","야호"));//true
        System.out.println(hash.inputData("박상우1","야호1"));//true
        System.out.println(hash.inputData("박상우2","야호2"));//true
        System.out.println(hash.inputData("박상우2","야호22"));//true
        System.out.println(hash.inputData("박상우3","야호3"));//false
        System.out.println("=======");
        System.out.println(hash.getData("박상우")); //야호
        System.out.println(hash.getData("박상우1"));//야호
        System.out.println(hash.getData("박상우3"));//null
        System.out.println(hash.getData("박상우2"));//야호
        System.out.println(hash.getData("박상우4"));//null

    }
}

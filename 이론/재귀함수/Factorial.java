class Main{
    public static void main(String[] args){
        MyFact mf = new MyFact();
        System.out.println(mf.factFunc(0));
    }

    static  class MyFact{
        public int factFunc(int num){
            if(num == 0){
                return 1;
            }else if(num == 1){
                return 1;
            }else{
                return num * factFunc (num-1);
            }
        }
    }
}

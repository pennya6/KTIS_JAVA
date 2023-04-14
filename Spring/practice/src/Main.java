public class Main {
//    public static void exec(Compare compare){
//        int k=10;
//        int m=20;
//        int value= compare.compareTo(k,m);
//        System.out.println(value);
//    }
    public static void main(String[] args) {
//        exec((i,j)->{
//            return i+j;
//        });
        Ramda4_2.test test=new Ramda4_2.test();
        test.compareTo(10,20);
        System.out.println(test.compareTo(10,20));
    }
}
//interface Compare{
//    public int compareTo(int a,int b);
//}
public class Ramda4 {
    @FunctionalInterface
    interface Math{
        public int Calc(int a,int b);
    }

    public static void main(String[] args){
        Math plus=(a,b)->a+b;
        System.out.println(plus.Calc(4,2));
    }
}

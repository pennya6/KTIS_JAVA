public class Ramda4_2 {
    public void main(String args[]){
        //System.out.println(test.compareTo(10,20));
        test test=new test();
        test.compareTo(10,20);
        System.out.println(test.compareTo(10,20));

    }
    public static class test implements Compare{

        @Override
        public int compareTo(int a, int b) {
            return a+b;
        }
    }
}

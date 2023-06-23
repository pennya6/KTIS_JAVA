package sec02;

public class Array {
    public static void main(String[] args){
        int[] scores={83,90,87};
        System.out.println(scores[0]);
        System.out.println(scores[1]);
        System.out.println(scores[2]);

        int sum=0;
        for(int i=0;i<3;i++){
            sum+=scores[i];
        }
        double avg=(double)sum/3;
        System.out.println("avg = " + avg);
    }

}

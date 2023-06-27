package sec04.exam01;

public class CalculatorExample {
    public static void main(String[] args) {
        Calculator calculator=new Calculator();
        calculator.powerOn();

        int result= calculator.plus(5,6);
        System.out.println("result = " + result);

        calculator.poweroff();
    }
}

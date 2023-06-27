package sec05.exam04;

public class SingletonExample {
    public static void main(String[] args) {
        Singleton singleton=Singleton.getInstance();
        Singleton singleton1=Singleton.getInstance();

        if(singleton==singleton1){
            System.out.printf("same singleton");
        }else{
            System.out.printf("not same");
        }
    }
}

package sec05.exam04;

public class Singleton {
    //정적 필드 -> 외부에서 필드값 변경못하도록
    private static Singleton singleton=new Singleton();

    //생성자
    private Singleton(){
    }
    //정적메소드 -> 외부 호출 가능
    static Singleton getInstance(){
        return singleton;
    }
}

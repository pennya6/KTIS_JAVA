package vo;

public class Person {
    //VO(Value Object)
    //기본특성
    //1. 수정자가 없다. -> setter가 없다라는 의미
    // 질문 -> 상수대리님께서 패키지 명을 vo라고 한 이유는?
    private String name;
    private String ssn;

    //생성자
    //객체를 생성하기 위해 new와 함께 호출
    //객체의 속성을 초기화하기 위해서 사용
    public Person(String name,String ssn){
        this.name=name;
        this.ssn=ssn;
    }
    public Person(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}

package vo;

public class Person {
    //필드
    //private으로 해야함
    //데이터 접근은 메소드를 통해서 해야함 -> getter, setter
    private String name;
    private String ssn;

    //생성자
    //일종의 서드
    public Person(String name,String ssn){
        this.name=name;
        this.ssn=ssn;
    }
    public Person(){

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

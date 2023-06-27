package sec06.exam02;

public class StudentExample {
    public static void main(String[] args) {
        Student student=new Student("hong","1234-1234",1);
        System.out.println("student.name = " + student.name);
        System.out.println("student.ssn = " + student.ssn);
        System.out.println("student.studentNo = " + student.studentNo);
    }
}

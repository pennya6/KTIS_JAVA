package AOPtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class AOPMain {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");

        Student a = factory.getBean("studentA", Student.class);
        Student b = (Student) factory.getBean("studentB");

        System.out.println("A 입장");
        a.classWork();
        System.out.println("--------------");
        System.out.println("B 입장");
        b.classWork();
    }
}

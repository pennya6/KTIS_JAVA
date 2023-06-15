package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBeans() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter + tab
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName = " + beanDefinitionName + " bean = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter + tab
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition=ac.getBeanDefinition(beanDefinitionName);
            //bean은 3가지 역할이 있지
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                //spring 내부 등록 빈이 아니라
                //내가 혹은 외부에서 등록한 빈
                Object bean=ac.getBean(beanDefinitionName);
                System.out.println("name="+beanDefinitionName+"object="+bean);
            }
        }
    }
}

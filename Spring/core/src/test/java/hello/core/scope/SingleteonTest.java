package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingleteonTest {
    @Test
    public void singletonBeanFind(){
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singletonBean=ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2=ac.getBean(SingletonBean.class);
        System.out.println(singletonBean);
        System.out.println(singletonBean2);
        Assertions.assertThat(singletonBean).isSameAs(singletonBean2);

        ac.close();
    }
    @Scope("singleton")
    static class SingletonBean{
        @PostConstruct
        public void init(){
            System.out.println("singletonBean.init");
        }

        @PreDestroy
        public void destory(){
            System.out.println("singletonebean.destory");
        }
    }
}

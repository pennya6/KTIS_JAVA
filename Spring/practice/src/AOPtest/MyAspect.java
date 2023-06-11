package AOPtest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// MethodInterceptor를 이용한 프록시 구현
// MethodInterceptor :  프록시 객체의 콜백 기능 중 하나
public class MyAspect implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object target = null;

        System.out.println("출석한다.");

        try {
            target = invocation.proceed();
        } catch(Exception e) {
            System.out.println("쉬는날이었다.");
        } finally {
            System.out.println("집에간다.");
        }

        return target;
    }
}

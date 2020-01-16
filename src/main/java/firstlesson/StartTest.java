package firstlesson;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println(testBean.getName());
        context.close();
    }
}
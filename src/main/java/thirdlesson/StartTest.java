package thirdlesson;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("newAppContext.xml");
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.playMusic();
        musicPlayer.showVolume();


        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(TestConfig.class);
        ClassicalMusic classicalMusic = appContext.getBean("classicalMusic", ClassicalMusic.class);
        System.out.println(classicalMusic.getSong());
        context.close();
        appContext.close();
    }

}

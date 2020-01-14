package secondlesson;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();
        musicPlayer.showVolume();
        context.close();
    }
}

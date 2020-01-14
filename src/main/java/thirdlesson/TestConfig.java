package thirdlesson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("thirdlesson")
@PropertySource("classpath:musicPlayer.properties")
public class TestConfig {
    //analog creation of bean throw xml. Creates bean with id = "classicalMusic"
    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }
}

package thirdlesson;

import org.springframework.stereotype.Component;

@Component("classical")
public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}

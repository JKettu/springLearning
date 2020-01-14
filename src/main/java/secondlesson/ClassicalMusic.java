package secondlesson;

import org.springframework.context.annotation.Bean;

public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}

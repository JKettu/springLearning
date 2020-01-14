package thirdlesson;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("rock")
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Bulletproof heart";
    }

    @PostConstruct
    public void doInit() {
        System.out.println("Init");
    }

    @PreDestroy
    public void doDestroy() {
        System.out.println("Destroy");
    }
}

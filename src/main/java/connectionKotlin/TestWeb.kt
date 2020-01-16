package connectionKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc
@EnableFeignClients
open class TestWeb {
    /*fun main(args: Array<String>) {
        runApplication<TestWeb>(*args)
    }*/
}
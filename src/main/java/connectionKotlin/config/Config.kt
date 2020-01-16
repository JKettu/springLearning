package connectionKotlin.config

import dbconnection.client.ContactClient
import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import org.springframework.cloud.openfeign.support.SpringMvcContract
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration
import org.springframework.web.servlet.view.InternalResourceViewResolver
import org.springframework.web.servlet.view.JstlView

@Configuration
@ComponentScan("connectionKotlin")
@EnableTransactionManagement
open class Config: DelegatingWebMvcConfiguration() {

    override fun configureDefaultServletHandling(configurer: DefaultServletHandlerConfigurer) {
        configurer.enable();
    }

    @Bean
    open fun internalResourceViewResolver(): InternalResourceViewResolver {
        val resolver = InternalResourceViewResolver()
        resolver.setViewClass(JstlView::class.java)
        resolver.setPrefix("/WEB-INF/templates/")
        resolver.setSuffix(".jsp")
        return resolver
    }

    @Bean
    open fun contactClient():ContactClient {
        return Feign.builder()
                .contract(SpringMvcContract())
                .decoder(JacksonDecoder())
                .encoder(JacksonEncoder())
                .target(ContactClient::class.java, "http://localhost:8080")
    }
}
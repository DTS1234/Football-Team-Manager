package uep.football.manager.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import uep.football.manager.service.auth.LoginState;

/**
 * @date 02.06.2021
 */
@Configuration
@EnableWebMvc
public class Config {

    @Bean
    public LoginState getLoginState() {
        return new LoginState();
    }

}

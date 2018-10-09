package de.jcon.example.jcon_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@Order(1)
public class BasicAuthenticationConfigurationAdapter extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        final UserDetails user = User.withDefaultPasswordEncoder().username("jcon").password("jcon").roles("OWNER","ACTUATOR").build();
        manager.createUser(user);
        return manager;
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }


}

package de.jcon.example.jcon_demo.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import de.jcon.example.jcon_demo.endpoints.RuntimeEndpoint;

@Configuration
@Order(2)
public class NoAuthenticationConfigurationAdapter extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(EndpointRequest.to(HealthEndpoint.class, RuntimeEndpoint.class));
        super.configure(web);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/message").authenticated();
        super.configure(http);
    }
}

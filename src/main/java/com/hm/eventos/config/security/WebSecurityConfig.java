/*package com.hm.eventos.config.security;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by hans6 on 09-07-2017.
 */
/*@Configuration
@EnableWebSecurity
@ConditionalOnProperty(prefix = "auth0", value = "secret")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN = "ADMINISTADOR";
    private static final String USER = "USUARIO";

    @Value("${auth0.audience}")
    private String audience;

    @Value("${auth0.issuer}")
    private String issuer;

    @Value("${auth0.secret}")
    private String secret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        JwtWebSecurityConfigurer
                .forRS256(audience, issuer)
                .configure(http)
                .authorizeRequests()
                .antMatchers("**").permitAll()
                .anyRequest().authenticated();
    }


}*/

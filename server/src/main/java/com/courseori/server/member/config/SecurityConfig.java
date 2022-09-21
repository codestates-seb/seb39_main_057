package com.courseori.server.member.config;

import com.courseori.server.member.filter.FirstFilter;
import com.courseori.server.member.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private final CorsFilter corsFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.addFilterBefore(new FirstFilter(), BasicAuthenticationFilter.class);
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //session이나 cookie 사용없이 STATELESS 사용
                .and()
                .formLogin().disable()  //form-login을 사용하지 않습니다.
                .httpBasic().disable()
                .apply(new CustomDls())
                .and()
                .authorizeRequests()
                .antMatchers("/api/user/**")
                .access("HasRole('ROLE_USER') or HasRole('ROLE_ADMIN')")
                .antMatchers("/api/admin/**")
                .access("HasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .addFilter(corsFilter);
        return http.build();
    }

    public class CustomDls extends AbstractHttpConfigurer<CustomDls,HttpSecurity> {

        @Override
        public void configure(HttpSecurity builder) throws Exception{
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            builder
                    .addFilter(corsFilter)
                    .addFilter(new JwtAuthenticationFilter(authenticationManager));
        }
    }
}

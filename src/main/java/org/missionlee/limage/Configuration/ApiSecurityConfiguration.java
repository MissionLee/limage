package org.missionlee.limage.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author MissionLee
 * @Description
 * @Date Created in 9:10 2018/8/1
 **/
//@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true) // 这个注解允许我们为应用中的类和方法添加注解，从而定义他们的安全级别 -> 在方法使用 @Secured("ROLE_ADMIN")
public class ApiSecurityConfiguration extends WebSecurityConfigurerAdapter {
    // URL授权
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/login","/logout","/hello","/").permitAll()
                .antMatchers(HttpMethod.GET,"/api/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }
    // 用户授权
    @Autowired
    public void configureAuth(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("USER","ADMIN");
    }
}

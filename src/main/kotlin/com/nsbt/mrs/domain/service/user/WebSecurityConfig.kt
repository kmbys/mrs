package com.nsbt.mrs.domain.service.user

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    @Bean
    fun passwordEncoder() =
        BCryptPasswordEncoder()

    override fun configure(http: HttpSecurity?): Unit {
        http!!.authorizeRequests()
            .antMatchers("/js/**", "/css/**").permitAll()
            .antMatchers("/**").authenticated()
            .and()
            .formLogin()
            .loginPage("/loginForm")
            .loginProcessingUrl("/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/rooms", true)
            .failureUrl("/loginForm?error=true").permitAll()
    }

}


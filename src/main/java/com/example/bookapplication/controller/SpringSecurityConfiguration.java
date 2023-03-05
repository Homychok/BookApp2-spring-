package com.example.bookapplication.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

public class SpringSecurityConfiguration {
    @Bean
//Создаем метод в классе конфигурации -
//который возвращает бин SecurityFilterChain -
//основной бин для конфигурации Spring Security
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Отключение защиты от подделки межсайтовых запросов (CSRF)
        // это необходимо чтобы нормально использовать REST API,
        // не запрашивая CSRF коды
        httpSecurity.csrf().disable()
                // Настройка правил авторизации
                .authorizeRequests()
                // Разрешение доступа к URL-адресу "/web" для всех пользователей
                .antMatchers("/web").permitAll()
                // Запрет доступа к любым другим URL-адресам, если пользователь не прошел аутентификацию
                .anyRequest().authenticated()
                // Настройка аутентификации через базовую HTTP-аутентификацию
                .and().httpBasic();

        return httpSecurity.build();
    }

}

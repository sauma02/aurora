/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.config;

import NameCheap.nameCheap.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Admin
 */
@Configuration
public class SecurityConfig {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
  

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception {
        try {
            return https.formLogin(Customizer.withDefaults())
                    .authorizeHttpRequests(req -> req
                    .requestMatchers("/**").permitAll()
                    .requestMatchers("/login/**").permitAll()       
                    .requestMatchers("/admin/**").hasAuthority("admin")
                    .anyRequest().authenticated())
                    .formLogin()
                    .loginPage("/login")
                    .successHandler(myAuthenticationSuccessHandler()).permitAll()
                    .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").and()
                    .userDetailsService(usuarioServicio).build();

        } catch (Exception e) {
            throw new Exception("error");
        }
    }
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authentication -> authentication;
    }
    @Bean
    //Se crea el bean nuevo para poder redireccionar basado en el rol de la persona
    public MySimpleAuthenticationSuccessHandler myAuthenticationSuccessHandler(){
            return new MySimpleAuthenticationSuccessHandler();
    }
}

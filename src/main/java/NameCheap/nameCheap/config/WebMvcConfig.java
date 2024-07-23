/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.config;

import jakarta.mail.Session;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 *
 * @author USUARIO
 */
@Configuration
public class WebMvcConfig {
    @Bean
    public JavaMailSender javaMail(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.hostinger.com");
        mailSender.setPort(465);
        
        
        mailSender.setUsername("auroraSupport@auroramarblegranite.com");
        mailSender.setPassword("Supergamo123.");
        
        
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.hostinger.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.from", "auroraSupport@auroramarblegranite.com");
        Session session = Session.getInstance(props);
        
        mailSender.setSession(session);
        
        return mailSender;
        
    }
}

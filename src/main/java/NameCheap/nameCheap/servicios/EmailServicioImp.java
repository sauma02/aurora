/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.servicios;

import jakarta.mail.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class EmailServicioImp implements EmailServicio {
    
    private Session session;
    @Autowired
    private JavaMailSender javaMail;
    @Override
    public void enviarMensajeSencillo(String to, String subject, String text, String from) {
        try {
            
        
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom(from);
        mensaje.setTo(to);
        mensaje.setSubject(subject);
        mensaje.setText(text);
        javaMail.send(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            
            if(e.getCause() != null){
                System.err.println("Error: "+e.getCause().getMessage());
            }
        }
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@Entity
@Getter
@Setter
public class PasswordResetToken {
   @Id 
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   private String token;
   private String email;
   @OneToOne
   private Usuario usuario;
   private LocalDateTime expirationTime;
   public PasswordResetToken(){
        this.token = UUID.randomUUID().toString();
        this.email = email;
        this.expirationTime = calculateExpirationDate();
    }
    public PasswordResetToken(Integer id, String token, String email, Usuario usuario, LocalDateTime expirationTime) {
        this.id = id;
        this.token = token;
        this.email = email;
        this.usuario = usuario;
        this.expirationTime = calculateExpirationDate();
    }
   

    @Override
    public String toString() {
        return "passwordResetToken{" + "id=" + id + ", token=" + token + ", email=" + email + ", usuario=" + usuario + ", expirationTime=" + expirationTime + '}';
    }

    private LocalDateTime calculateExpirationDate(){
        return LocalDateTime.now().plusDays(1);
    }
    public boolean isExpired(LocalDateTime expirationDate){
        return expirationDate.isBefore(LocalDateTime.now());
    }
   
   
}

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
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@Entity
@Getter
@Setter

public class usuario {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Integer id;
   private String nombre;
   private String username;
   private String email;
   private String password;
   @OneToOne
   private rol rol;

    public usuario() {
    }

    public usuario(Integer id, String nombre, String username, String email, String password, rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "usuario{" + "id=" + id + ", nombre=" + nombre + ", username=" + username + ", email=" + email + ", password=" + password + ", rol=" + rol + '}';
    }
   
   
}

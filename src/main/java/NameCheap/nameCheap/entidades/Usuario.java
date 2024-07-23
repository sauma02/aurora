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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Admin
 */
@Entity
@Getter
@Setter

public class Usuario implements UserDetails{
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Integer id;
   private String nombre;
   private String username;
   private String email;
   private String password;
   @OneToOne
   private Rol rol;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String username, String email, String password, Rol rol) {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        try {
            List<GrantedAuthority> authorityList = new ArrayList();
            List<Rol> roles = new ArrayList();
            roles.add(rol);
            for (Rol role : roles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(rol.getNombre());
                authorityList.add(authority);
            }
            return authorityList;
        } catch (Exception e) {
            e.printStackTrace();
            if(e.getCause() != null){
                System.err.println("Error: "+e.getCause().getMessage());
            }
            return null;
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
   
   
}

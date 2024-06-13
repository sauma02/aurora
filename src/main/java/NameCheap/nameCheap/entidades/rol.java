/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@Entity
@Getter
@Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nombre;
    private String descripcion;
    @JoinColumn(name = "usuario_id")
    @OneToMany(fetch = FetchType.EAGER)
    private List<Usuario> usuario;

    public Rol() {
    }

    public Rol(Integer id, String nombre, String descripcion, List<Usuario> usuario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "rol{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", usuario=" + usuario + '}';
    }
    
    
    
}

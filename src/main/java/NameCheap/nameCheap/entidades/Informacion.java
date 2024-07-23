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
import jakarta.persistence.ManyToMany;
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

public class Informacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String titulo;
    private String seccion;
    private String texto;
    private String iconoServicio;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Imagen> imagen;

    public Informacion(Integer id, String titulo, String seccion, String texto, String iconoServicio, List<Imagen> imagen) {
        this.id = id;
        this.titulo = titulo;
        this.seccion = seccion;
        this.texto = texto;
        this.iconoServicio = iconoServicio;
        this.imagen = imagen;
    }

    

    public Informacion() {
    }

    @Override
    public String toString() {
        return "informacion{" + "id=" + id + ", titulo=" + titulo + ", seccion=" + seccion + ", texto=" + texto + ", imagen=" + imagen + '}';
    }
    
    
}

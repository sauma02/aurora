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
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@Entity
@Getter
@Setter
public class imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String titulo;
    private String nombreImagen;
    private Integer tamano;
    private String fileType;
    @ManyToOne(fetch = FetchType.EAGER)
    private informacion info;
    private String ruta;

    public imagen() {
    }

    public imagen(Integer id, String titulo, String nombreImagen, Integer tamano, String fileType, informacion info, String ruta) {
        this.id = id;
        this.titulo = titulo;
        this.nombreImagen = nombreImagen;
        this.tamano = tamano;
        this.fileType = fileType;
        this.info = info;
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "imagen{" + "id=" + id + ", titulo=" + titulo + ", nombreImagen=" + nombreImagen + ", tamano=" + tamano + ", fileType=" + fileType + ", info=" + info + ", ruta=" + ruta + '}';
    }
    
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package NameCheap.nameCheap.repositorios;

import NameCheap.nameCheap.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {

    public Rol findByNombre(String nombre);
    
}

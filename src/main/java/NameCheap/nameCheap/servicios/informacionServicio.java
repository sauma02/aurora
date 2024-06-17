/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.servicios;

import NameCheap.nameCheap.entidades.Informacion;
import NameCheap.nameCheap.repositorios.InformacionRepositorio;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class InformacionServicio {
    @Autowired
    private InformacionRepositorio informacionRepositorio;
    @Transactional
    public Informacion crearInfo(Informacion info){
        informacionRepositorio.save(info);
        return info;
    }
    public void editarInfo(Informacion info){
        Optional<Informacion> resInfo = informacionRepositorio.findById(info.getId());
        if(resInfo.isPresent()){
            Informacion informacion = resInfo.get();
            informacionRepositorio.save(informacion);
        }
    }
    public void eliminarInfo(Integer id){
        Optional<Informacion> resInfo = informacionRepositorio.findById(id);
        if(resInfo.isPresent()){
            Informacion informacion = resInfo.get();
            informacionRepositorio.delete(informacion);
            
        }
    }
    public List<Informacion> listarInfo(){
        return informacionRepositorio.findAll();
    }
}

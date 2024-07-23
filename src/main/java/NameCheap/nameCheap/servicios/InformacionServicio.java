/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.servicios;

import NameCheap.nameCheap.entidades.Imagen;
import NameCheap.nameCheap.entidades.Informacion;
import NameCheap.nameCheap.repositorios.InformacionRepositorio;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Service
public class InformacionServicio {
    @Autowired
    private InformacionRepositorio informacionRepositorio;
    @Autowired
    private FileStorageService storageService;
    @Autowired
    private ImagenServicio imagenServicio;
    @Transactional
    public Informacion crearInfo(String titulo, String seccion, String texto, String iconoServicio, MultipartFile imagen) throws Exception{
        if(imagen != null){
            Informacion info = new Informacion();
            Imagen img = new Imagen();
            List<Imagen> listImg = new ArrayList();
            info.setSeccion(seccion);
            info.setTexto(texto);
            info.setTitulo(titulo);
            info.setIconoServicio(iconoServicio);
            img.setNombreImagen(storageService.listOneFile(imagen).getOriginalFilename());
            imagenServicio.crearImagen(img, info, imagen);
            listImg.add(img);
            info.setImagen(listImg);
            informacionRepositorio.save(info);
            return info;
            
        }else{
            Informacion info = new Informacion(null, titulo, seccion, texto, iconoServicio, null);
            return info;
        }
        
    }
    public Informacion editarInfo(Informacion info){
        Optional<Informacion> resInfo = informacionRepositorio.findById(info.getId());
        if(resInfo.isPresent()){
            Informacion informacion = resInfo.get();
            informacionRepositorio.save(informacion);
            return informacion;
        }else{
            return null;
        }
    }
        public void eliminarInfo(Informacion info){
        informacionRepositorio.delete(info);
    }
    public List<Informacion> listarInfo(){
        return informacionRepositorio.findAll();
    }

    public Informacion listarInfoPorId(Integer id) {
       Optional<Informacion> infoRes = informacionRepositorio.findById(id);
       if(infoRes.isPresent()){
           Informacion info = infoRes.get();
           return info;
       }else{
           return null;
       }
    }
}

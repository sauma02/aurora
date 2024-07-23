/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.servicios;

import NameCheap.nameCheap.entidades.Imagen;
import NameCheap.nameCheap.entidades.Informacion;
import NameCheap.nameCheap.repositorios.ImagenRepositorio;
import jakarta.transaction.Transactional;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Service
public class ImagenServicio {

  
    @Autowired
    private ImagenRepositorio imagenRepositorio;
    @Autowired
    private FileStorageService storageService;

    @Transactional
    public Imagen crearImagen(Imagen imagen, Informacion info, MultipartFile file) throws Exception {
        try {
            
            Path ruta = Paths.get("src/main/resources/static/img/" + file.getOriginalFilename());

            imagen.setRuta(ruta.toString());
            imagen.setTamano(file.getSize());
            imagen.setNombreImagen(file.getOriginalFilename());
            imagen.setFileType(file.getContentType());
            imagen.setInfo(info);
            imagenRepositorio.save(imagen);
            return imagen;

        } catch (Exception ex) {
            ex.printStackTrace();

            if (ex.getCause() != null) {
                System.err.println("Error: " + ex.getCause().getMessage());
            }
            return null;
        }
    }

    public Imagen editarImagenInfo(Informacion info, Imagen imagen, MultipartFile file) throws Exception {
        try {
            Path ruta = Paths.get("src/main/resources/img/" + file.getOriginalFilename());

            imagen.setRuta(ruta.toString());
            imagen.setTamano(file.getSize());

            imagen.setFileType(file.getContentType());
            imagen.setInfo(info);
            imagenRepositorio.save(imagen);
            return imagen;
        } catch (Exception e) {
            e.printStackTrace();

            if (e.getCause() != null) {
                System.err.println("Error: " + e.getCause().getMessage());
            }
            return null;
        }
    }

    public void eliminarImagen(Imagen img) {
        try {
            storageService.deleteFileByName(img);
            imagenRepositorio.delete(img);
        } catch (Exception e) {
            e.getCause();
            
        }

    }
    public Imagen imagenPorId(Integer id){
        Optional<Imagen> imagenRes = imagenRepositorio.findById(id);
        if(imagenRes.isPresent()){
            Imagen img = imagenRes.get();
            return img;
        }else{
            return null;
        }
           
    }
}

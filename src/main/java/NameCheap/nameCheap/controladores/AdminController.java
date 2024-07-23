/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.controladores;

import NameCheap.nameCheap.entidades.Imagen;
import NameCheap.nameCheap.entidades.Informacion;
import NameCheap.nameCheap.servicios.FileStorageService;
import NameCheap.nameCheap.servicios.ImagenServicio;
import NameCheap.nameCheap.servicios.InformacionServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Controller
public class AdminController {

    @Autowired
    private InformacionServicio infoServicio;
    @Autowired
    private FileStorageService storageService;
    @Autowired
    private ImagenServicio imagenServicio;

    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserDetails userDetails, ModelMap map) {
        if(userDetails != null){
            String username = userDetails.getUsername();
        map.addAttribute("username", username);
        if (username != null) {
            return "admin.html";
        } else {
            return "redirect:/";
        }
        }else{
            return "redirect:/login";
        }
        

    }

    @GetMapping("/admin/adminPanel")
    public String adminPanel(@AuthenticationPrincipal UserDetails userDetails, ModelMap map) {
        if(userDetails != null){
            String username = userDetails.getUsername();
        List<Informacion> infoLista = infoServicio.listarInfo();
        map.addAttribute("username", username);
        map.addAttribute("infoLista", infoLista);
        return "adminPanel.html";
        }else{
            return "redirect:/login";
        }
        
    }

    @GetMapping("/admin/adminPanel/registrarInfo")
    public String infoForm() {
        return "registrarInfo.html";

    }
    
    @GetMapping("/admin/adminPanel/registrarInfo/editar/{id}")
    public String editar(@PathVariable("id") Integer id, ModelMap map) {
        Informacion info = infoServicio.listarInfoPorId(id);
        map.addAttribute("info", info);
        return "editarInfo.html";
    }
    
    @GetMapping("/admin/adminPanel/registrarInfo/anadirImg/{id}")
    public String anadirImagenes(@PathVariable("id") Integer id, ModelMap map) {
        Informacion info = infoServicio.listarInfoPorId(id);
        List<Imagen> imagenes = info.getImagen();
        map.addAttribute("info", info);
        map.addAttribute("imagenes", imagenes);
        return "anadirImagenes.html";
    }

    @PostMapping("/admin/adminPanel/registrarInfo/editar/edit")
    public String edit(@RequestParam("id") Integer id, @RequestParam("titulo") String titulo, @RequestParam("seccion") String seccion, @RequestParam("texto") String texto, @RequestParam("iconoServicio") String inconoServicio, ModelMap map) {
        try {
            Informacion info = infoServicio.listarInfoPorId(id);
            info.setIconoServicio(inconoServicio);
            info.setSeccion(seccion);
            info.setTexto(texto);
            info.setTitulo(titulo);
            infoServicio.editarInfo(info);
            map.addAttribute("info", info);
            map.addAttribute("errorStatus", "false");
            map.addAttribute("errorMessage", "Edited info successfully");
            return "editarInfo.html";
        } catch (Exception e) {
            e.getCause();
            if (e.getCause() != null) {
                System.err.println("Error: " + e.getCause().getMessage());
            }
            Informacion info = infoServicio.listarInfoPorId(id);
            map.addAttribute("info", info);
            map.addAttribute("errorStatus", "true");
            map.addAttribute("errorMessage", "Unexpected error: " + e.getMessage());
            return "editarInfo.html";

        }
    }

    @PostMapping("/admin/adminPanel/registrarInfo/regis")
    public String registrarInfo(@RequestParam("titulo") String titulo, @RequestParam("seccion") String seccion, @RequestParam("texto") String texto,
            @RequestParam("iconoServicio") String inconoServicio, @RequestParam("imagen") MultipartFile imagen, ModelMap map) {
        try {
            if (imagen != null) {

                infoServicio.crearInfo(titulo, seccion, texto, inconoServicio, imagen);
                map.addAttribute("exitoStatus", "true");
                map.addAttribute("exitoMessage", "Se ha registrado la informacion con exito");
                return "registrarInfo.html";
            } else {
                infoServicio.crearInfo(titulo, seccion, texto, inconoServicio, null);
                map.addAttribute("exitoStatus", "true");
                map.addAttribute("exitoMessage", "Se ha registrado la informacion sin imagen con exito");
                return "registrarInfo.html";
            }
        } catch (Exception e) {
            e.getCause();
            if (e.getCause() != null) {
                System.err.println("Error: " + e.getCause().getMessage());
            }
            map.addAttribute("exitoStatus", "false");
            map.addAttribute("exitoMessage", "Error al registrar informacion " + e.getMessage());
            return "registrarInfo.html";
        }

    }

    @PostMapping("/admin/adminPanel/eliminar/{id}")
    public String eliminarInfo(@PathVariable("id") Integer id, ModelMap map){
        try {
            Informacion info = infoServicio.listarInfoPorId(id);
            List<Imagen> imagenes = info.getImagen();
            if(imagenes.isEmpty()){
            for (Imagen img : imagenes) {
                imagenes.remove(img);
                imagenServicio.eliminarImagen(img);
            }
            infoServicio.eliminarInfo(info);
            List<Informacion> infoLista = infoServicio.listarInfo();
            map.addAttribute("errorStatus", "false");
            map.addAttribute("errorMessage", "Info deleted successfully");
            map.addAttribute("infoLista", infoLista);
            return "adminPanel.html";
            }else{
            infoServicio.eliminarInfo(info);
            List<Informacion> infoLista = infoServicio.listarInfo();
            map.addAttribute("errorStatus", "false");
            map.addAttribute("errorMessage", "Info deleted successfully");
            map.addAttribute("infoLista", infoLista);
            return "adminPanel.html";
            }
        } catch (Exception e) {
            e.printStackTrace();
            if(e.getCause() != null){
                System.err.println("Error: "+e.getCause().getMessage());
            }
            List<Informacion> infoLista = infoServicio.listarInfo();
            map.addAttribute("infoLista", infoLista);
            map.addAttribute("errorStatus", "true");
            map.addAttribute("errorMessage", "Unexpected error: "+e.getMessage());
            return "adminPanel.html";
        
        }
    }

    @PostMapping("/admin/adminPanel/registrarInfo/editar/editarImagen")
    public String editForm(@RequestParam("imagenId") Integer imagenId, @RequestParam("imagen") MultipartFile imagen, ModelMap map) {
        try {
            storageService.init();
            Imagen img = imagenServicio.imagenPorId(imagenId);
            Informacion info = img.getInfo();

            List<Imagen> listaImagen = info.getImagen();
            if (imagen.getOriginalFilename() == img.getNombreImagen()) {
                map.addAttribute("info", info);
                map.addAttribute("imagenes", listaImagen);
                map.addAttribute("errorStatus", "true");
                map.addAttribute("errorMessage", "Uploaded file is the same as the one in the folder");
                return "editarInfo.html";
            } else {
                for (Imagen imagen1 : listaImagen) {
                    if (img.equals(imagen1)) {
                        listaImagen.remove(imagen1);
                        Imagen imgNueva = new Imagen();
                        storageService.save(imagen);
                        imagenServicio.crearImagen(imgNueva, info, imagen);
                        listaImagen.add(imgNueva);

                    }

                }

                info.setSeccion(info.getSeccion());
                info.setTexto(info.getTexto());
                info.setIconoServicio(info.getIconoServicio());
                info.setTitulo(info.getTitulo());
                info.setImagen(listaImagen);
                map.addAttribute("info", info);
                map.addAttribute("imagenes", listaImagen);
                map.addAttribute("errorStatus", "false");
                map.addAttribute("errorMessage", "Image edited succesfully");
                infoServicio.editarInfo(info);
                return "anadirImagenes.html";
            }

        } catch (Exception e) {
            e.getCause();

            if (e.getCause() != null) {
                System.err.println("Error: " + e.getCause().getMessage());
            }
           
            Imagen img = imagenServicio.imagenPorId(imagenId);
             Informacion info = img.getInfo();
            List<Imagen> listaImagen = info.getImagen();
            map.addAttribute("info", info);
            map.addAttribute("imagenes", listaImagen);
            map.addAttribute("errorStatus", "true");
            map.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "anadirImagenes";
        }

    }

    @PostMapping("/admin/adminPanel/registrarInfo/editar/addImage")
    public String añadirImagen(@RequestParam("id") Integer id, @RequestParam("imagen[]") MultipartFile[] imagenes, ModelMap map) {
        try {

            Informacion info = infoServicio.listarInfoPorId(id);
            List<Imagen> listaImg = info.getImagen();
            storageService.init();
            for (MultipartFile imagen : imagenes) {
                storageService.save(imagen);
                Imagen img = new Imagen();
                img.setNombreImagen(storageService.listOneFile(imagen).getOriginalFilename());
                imagenServicio.crearImagen(img, info, imagen);
                listaImg.add(img);
            }
            info.setImagen(listaImg);
            infoServicio.editarInfo(info);
            map.addAttribute("info", info);
            map.addAttribute("errorStatus", "false");
            map.addAttribute("errorMessage", "File added successfully");
            return "anadirImagenes.html";
            
        } catch (Exception e) {
            e.getCause();
            if (e.getCause() != null) {
                System.err.println("Error: " + e.getCause().getMessage());
            }

            Informacion info = infoServicio.listarInfoPorId(id);
            List<Imagen> listaImg = info.getImagen();
            map.addAttribute("info", info);
            map.addAttribute("imagenes", listaImg);
            map.addAttribute("errorStatus", "true");
            map.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "anadirImagenes.html";
        }
    }

    @PostMapping("/admin/adminPanel/registrarInfo/editar/añadirImagenIndividual")
    public String añadirImagenSola(@RequestParam("infoId") Integer id, @RequestParam("imagen[]") MultipartFile[] imagenes, ModelMap map) {
        try {
            Informacion info = infoServicio.listarInfoPorId(id);
            storageService.init();
            List<Imagen> listaImg = new ArrayList();
            for (Imagen img : listaImg) {
                for (MultipartFile file : imagenes) {
                    storageService.save(file);
                    img.setNombreImagen(storageService.listOneFile(file).getOriginalFilename());
                    imagenServicio.crearImagen(img, info, file);
                    listaImg.add(img);
                }
            }

            info.setImagen(listaImg);
            infoServicio.editarInfo(info);
            map.addAttribute("info", info);
            map.addAttribute("errorStatus", "false");
            map.addAttribute("errorMessage", "Files added successfully");
            return "editarInfo.html";
        } catch (Exception e) {
            e.getCause();
            if (e.getCause() != null) {
                System.err.println("Error: " + e.getCause().getMessage());
            }
            Imagen img = imagenServicio.imagenPorId(id);
            Informacion info = img.getInfo();
            map.addAttribute("info", info);
            map.addAttribute("errorStatus", "true");
            map.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "editarInfo.html";
        }

    }
   @PostMapping("/admin/adminPanel/registrarInfo/editar/eliminarImagenes")
    public String eliminar(@RequestParam("infoId") Integer id, ModelMap map){
        try {
            Informacion info = infoServicio.listarInfoPorId(id);
            List<Imagen> imagenes = info.getImagen();
            for (Imagen img : imagenes) {
                imagenServicio.eliminarImagen(img);
            }
            imagenes.clear();
            info.setImagen(imagenes);
            infoServicio.editarInfo(info);
            map.addAttribute("info", info);
            
            return "redirect:/admin/adminPanel";
        } catch (Exception e) {
            e.getStackTrace();
            if(e.getCause() != null){
                System.err.println("Error: "+e.getCause().getMessage());
            }
            Informacion info = infoServicio.listarInfoPorId(id);
            map.addAttribute("info", info);
            return "adminPanel.html";
        }
    }

    @PostMapping("/admin/adminPanel/registrarInfo/editar/eliminarImagen/{id}")
    public String eliminar(@RequestParam("infoId") Integer infoId, @PathVariable("id") Integer id, ModelMap map) {
        try {
            
                
            
            Imagen img = imagenServicio.imagenPorId(id);
            Informacion info = infoServicio.listarInfoPorId(infoId);
            if(img != null){
                
            
            
            List<Imagen> imgLista = info.getImagen();
            for (Imagen imagen : imgLista) {
                if (img.equals(imagen)) {
                    imgLista.remove(imagen);

                    imagenServicio.eliminarImagen(imagen);
                   

                }
            }
            info.setImagen(imgLista);
            infoServicio.editarInfo(info);
            map.addAttribute("info", info);
            System.out.println("Info: "+info);
            map.addAttribute("errorStatus", "false");
            map.addAttribute("errorMessage", "Image deleted succesfully");
            return "anadirImagenes.html";
            }else{
            
            map.addAttribute("errorStatus", "false");
            map.addAttribute("errorMessage", "No image to delete");
            return "anadirImagenes.html"; 
            }
            
        } catch (Exception e) {
            e.getCause();
            if (e.getCause() != null) {
                System.err.println("Error: " + e.getCause().getMessage());
            }
           
            Informacion info = infoServicio.listarInfoPorId(infoId);
            System.out.println("Info: "+info);
            map.addAttribute("info", info);
            map.addAttribute("errorStatus", "true");
            map.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "anadirImagenes.html";
        }
    }
}

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
        String username = userDetails.getUsername();
        map.addAttribute("username", username);
        return "admin.html";
    }

    @GetMapping("/admin/adminPanel")
    public String adminPanel(@AuthenticationPrincipal UserDetails userDetails, ModelMap map) {
        String username = userDetails.getUsername();
        List<Informacion> infoLista = infoServicio.listarInfo();
        map.addAttribute("username", username);
        map.addAttribute("infoLista", infoLista);
        return "adminPanel.html";
    }
    @GetMapping("/admin/adminPanel/registrarInfo")
    public String infoForm(){
        return "registrarInfo.html";
    }

   @PostMapping("/admin/adminPanel/registrarInfo/regis")
    public String registrarInfo(@RequestParam("titulo") String titulo, @RequestParam("seccion") String seccion, @RequestParam("texto") String texto,
            @RequestParam("iconoServicio") String inconoServicio, @RequestParam("imagen[]") MultipartFile[] imagen, ModelMap map) {
        try {
            Informacion info = new Informacion();
            Imagen img = new Imagen();
            List<Imagen> listImg = new ArrayList();
            if (imagen != null) {

                info.setTitulo(titulo);
                info.setTexto(texto);
                info.setSeccion(seccion);
                info.setIconoServicio(inconoServicio);
                storageService.init();
                for (MultipartFile file : imagen) {
                    if (storageService.listOneFile(file).isEmpty() || storageService.listOneFile(file) == null) {
                        storageService.save(file);
                        imagenServicio.crearImagen(img, info, file);
                        listImg.add(img);

                    }
                }
                info.setImagen(listImg);
                infoServicio.crearInfo(info);
                map.addAttribute("exitoStatus", "true");
                map.addAttribute("exitoMessage", "Se ha registrado la informacion con exito");
                return "registrarInfo.html";
            } else {
                info.setTitulo(titulo);
                info.setTexto(texto);
                info.setSeccion(seccion);
                info.setIconoServicio(inconoServicio);

                info.setImagen(listImg);
                infoServicio.crearInfo(info);
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
            map.addAttribute("exitoMessage", "Error al registrar informacion "+e.getMessage());
            return "registrarInfo.html";
        }

    }
}

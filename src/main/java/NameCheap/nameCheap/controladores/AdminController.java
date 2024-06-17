/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.controladores;

import NameCheap.nameCheap.entidades.Informacion;
import NameCheap.nameCheap.servicios.InformacionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Admin
 */
@Controller
public class AdminController {
    @Autowired
    private InformacionServicio infoServicio;
 @GetMapping("/admin")
 public String admin(){
     return "admin.html";
 }
 @GetMapping("/admin/adminPanel")
 public String servicios(ModelMap map){
     List<Informacion> infoLista = infoServicio.listarInfo();
     map.addAttribute("infoLista", infoLista);
     return "adminPanel.html";
 }
}

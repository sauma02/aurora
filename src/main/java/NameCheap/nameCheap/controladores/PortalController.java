/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Admin
 */
@Controller
public class PortalController {
    
    
   @GetMapping("/")
   public String inicio(){
       return "index.html";
   }
   @GetMapping("/portafolio")
   public String portafolio (){
       return "portafolio.html";
   }
   @GetMapping("/login")
   public String login(){
       return "login.html";
   }
   
}

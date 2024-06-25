/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.controladores;

import NameCheap.nameCheap.config.MySimpleAuthenticationSuccessHandler;
import NameCheap.nameCheap.entidades.Usuario;
import NameCheap.nameCheap.servicios.UsuarioServicio;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class PortalController {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private AuthenticationManager authenticationManager;
      @Autowired 
    private MySimpleAuthenticationSuccessHandler authenticationSuccessHandler;
    
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
   @PostMapping("/login")
   public String loginForm(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap map){
       UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
       try {
           Usuario user = usuarioServicio.buscarPorUsername(username);
           if(user.getPassword().equals(password)){
               Authentication auth = authenticationManager.authenticate(token);
               SecurityContextHolder.getContext().setAuthentication(auth);
               String redirectUrl = authenticationSuccessHandler.determineTargetUrlForAuthentication(auth);
               return "redirect:"+redirectUrl;
               
           }else{
               map.addAttribute("errorStatus", "true");
               map.addAttribute("errorMessage", "Error, el usuario y/o contraseña son incorrectos");
               return "login.html";
           }
       } catch (Exception e) {
           e.getCause();
           
           if(e.getCause() != null){
               System.err.println("Error: "+e.getMessage().toString());
               
           }
           map.addAttribute("errorStatus", "true");
           map.addAttribute("errorMessage", "Error inesperado: "+e.getMessage());
           return "login.html";
       }
   }
   @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/"; // Redirect to login page with a logout parameter
    }
}

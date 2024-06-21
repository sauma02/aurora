package NameCheap.nameCheap;

import NameCheap.nameCheap.entidades.Rol;
import NameCheap.nameCheap.entidades.Usuario;
import NameCheap.nameCheap.repositorios.RolRepositorio;
import NameCheap.nameCheap.repositorios.UsuarioRepositorio;
import NameCheap.nameCheap.servicios.FileStorageService;
import NameCheap.nameCheap.servicios.RolServicio;
import NameCheap.nameCheap.servicios.UsuarioServicio;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class NameCheapApplication {

    @Resource
    private FileStorageService storageService;

    public void run(String... arg) {
        storageService.init();
    }

    public static void main(String[] args) {
        SpringApplication.run(NameCheapApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(UsuarioRepositorio usuarioRepositorio, RolRepositorio rolRepositorio, PasswordEncoder passwordEncoder){
        return args ->{
            Usuario usuario = usuarioRepositorio.findByUsername("user");
            Usuario usuarioAdmin = usuarioRepositorio.findByUsername("admin");
            Rol rolUser = rolRepositorio.findByNombre("user");
            Rol rolAdmin = rolRepositorio.findByNombre("admin");
            if(rolUser != null && usuario != null){
                System.out.println("Usuario ya existe");
            }else{
                Rol us = new Rol();
                us.setNombre("user");
                rolRepositorio.save(us);
                Usuario user = new Usuario(null, "usuario", "user", "josedavids123@live.com", passwordEncoder.encode("password"), us);
                usuarioRepositorio.save(user);
                
            }
            if(usuarioAdmin != null && rolAdmin != null){
                System.out.println("Usuario admin ya existe");
            }else{
                Rol ad = new Rol();
                ad.setNombre("admin");
                rolRepositorio.save(ad);
                Usuario admin = new Usuario(null, "admin", "admin", "josedavids123@live.com", passwordEncoder.encode("password"), ad);
                usuarioRepositorio.save(admin);
            }
        };
                
    }
}   

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NameCheap.nameCheap.servicios;

import NameCheap.nameCheap.entidades.Usuario;
import NameCheap.nameCheap.repositorios.UsuarioRepositorio;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class UsuarioServicio implements UserDetailsService{
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Transactional
    public Usuario crearUsuario(Usuario us){
        usuarioRepositorio.save(us);
        return us;
    }
    public void editarUsuario(Usuario us){
        Optional<Usuario> resUsuario = usuarioRepositorio.findById(us.getId());
        if(resUsuario.isPresent()){
            Usuario usuario = resUsuario.get();
            usuarioRepositorio.save(usuario);
            
        }
    }
    public void eliminarUsuario(Integer id){
        Optional<Usuario> resUsuario = usuarioRepositorio.findById(id);
        if(resUsuario.isPresent()){
            Usuario usuario = resUsuario.get();
            usuarioRepositorio.delete(usuario);
        }
    }
    public Usuario buscarPorUsername(String username){
        return usuarioRepositorio.findByUsername(username);
    }
    public List<Usuario> listarUsuarios(){
        return usuarioRepositorio.findAll();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByUsername(username);
        if(usuario == null){
            throw new UsernameNotFoundException("El usuario ingresado no existe");
        }else{
            return usuario;
        }
    }
    
}

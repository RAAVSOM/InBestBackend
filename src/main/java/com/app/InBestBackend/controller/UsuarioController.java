package com.app.InBestBackend.controller;

import com.app.InBestBackend.domain.dto.UsuarioDTO;
import com.app.InBestBackend.domain.service.UsuarioService;
import com.app.InBestBackend.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usersService;
    
    @PostMapping("/login")
    public UsuarioDTO loginUser(@RequestBody UsuarioDTO usersDTO) throws Exception{
        UsuarioDTO usuarioEncontrado = usersService.loadUsuarioByUsuario(usersDTO.getUsuario());
        if(usuarioEncontrado != null && usersService.validarContraseña(usuarioEncontrado, usersDTO.getClave())){
            return usuarioEncontrado;
        }
        return usuarioEncontrado;
    }
    
    @GetMapping
    public List<Usuario> ver(){
        return usersService.cargartodos();
    }
    
    @PostMapping
    public Usuario agregar(@RequestBody UsuarioDTO usersDTO){
        return usersService.guardar(usersDTO);
    }
    
}

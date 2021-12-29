package com.gvendas.gestaovendas.security;

import com.gvendas.gestaovendas.entidades.Usuario;
import com.gvendas.gestaovendas.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsSecurity")
public class UserDetailsSecurityImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.findByLogin(username);

        if(usuario == null){
            throw new UsernameNotFoundException("user not found");
        }

            return usuario;



    }
}

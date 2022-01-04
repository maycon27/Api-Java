package com.gvendas.gestaovendas.repositorio;

import com.gvendas.gestaovendas.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

    Usuario findByLogin(String login);
}

package com.gvendas.gestaovendas.dto.usuario;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gvendas.gestaovendas.entidades.Role;
import com.gvendas.gestaovendas.entidades.Usuario;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class UsuarioResponseDto {
    private String login;
    private String nome;
    private String email;

    // token jwt
    private String token;

    private List<String> roles;

    public static UsuarioResponseDto create(Usuario user) {
        ModelMapper modelMapper = new ModelMapper();
        UsuarioResponseDto dto = modelMapper.map(user, UsuarioResponseDto.class);

        dto.roles = user.getRoles().stream()
                .map(Role::getNome)
                .collect(Collectors.toList());

        return dto;
    }

    public static UsuarioResponseDto create(Usuario user, String token) {
        UsuarioResponseDto dto = create(user);
        dto.token = token;
        return dto;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(this);
    }
}

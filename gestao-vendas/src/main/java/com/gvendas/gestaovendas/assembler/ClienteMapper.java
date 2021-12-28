package com.gvendas.gestaovendas.assembler;

import com.gvendas.gestaovendas.dto.cliente.ClienteResponseDTO;
import com.gvendas.gestaovendas.entidades.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class ClienteMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ClienteResponseDTO toModel(Cliente cliente){
        var dto = new ClienteResponseDTO();

        modelMapper.map(cliente,dto);

        return dto;
    }
}

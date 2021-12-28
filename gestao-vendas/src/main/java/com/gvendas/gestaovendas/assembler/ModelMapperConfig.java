package com.gvendas.gestaovendas.assembler;

import com.gvendas.gestaovendas.dto.cliente.EnderecoResponseDTO;
import com.gvendas.gestaovendas.entidades.Endereco;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        var enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap(
                Endereco.class, EnderecoResponseDTO.class);

        return modelMapper;
    }
}

package com.gvendas.gestaovendas.excecao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice 
public class GestaoVendasTratamentoExcecao extends ResponseEntityExceptionHandler {
	
	private static final String CONSTANT_VALIDATION_NOT_BLANK = "NotBlank";
	private static final String CONSTANT_VALIDATION_LENGTH = "Length";
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Erro> erros = gerarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> handlerEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request){
		String msgUsuario = " Recurso não encontrado";
		String msgDesvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(msgUsuario, msgDesvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
		
	}
	
	@ExceptionHandler(RegraNegocioException.class) 
	public ResponseEntity<Object> handleRegraNegocioException(RegraNegocioException ex, WebRequest request){
		String msgUsuario = ex.getMessage();
		String msgDesvolvedor = ex.getMessage();
		List<Erro> erros = Arrays.asList(new Erro(msgUsuario, msgDesvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	private List<Erro> gerarListaDeErros(BindingResult bindingResult) {
		List<Erro> erros = new ArrayList<Erro>();
		bindingResult.getFieldErrors().forEach(FieldError -> {
			String msgUsuario = tratarMensagemDeErroParaUsuario(FieldError);
			String msgDesevolvedor = FieldError.toString();
			
			erros.add(new Erro(msgUsuario,msgDesevolvedor));
		});
		
		return erros;
	}

	private String tratarMensagemDeErroParaUsuario(FieldError fieldError) {
		if(fieldError.getCode().equals(CONSTANT_VALIDATION_NOT_BLANK)) {
			return fieldError.getDefaultMessage().concat(" é obrigatório.");
		}
		if(fieldError.getCode().equals(CONSTANT_VALIDATION_LENGTH)) {
			return fieldError.getDefaultMessage().concat(String.format(" deve ter entre %s e %s caracteres", fieldError.getArguments()[2], 
					fieldError.getArguments()[1]));
		}
		return fieldError.toString();
	}

}

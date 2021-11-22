package com.gvendas.gestaovendas.excecao;

public class Erro {

	private String msgUsuario;
	private String msgDesevolvedor;
	
	
	public Erro(String msgUsuario, String msgDesevolvedor) {
		this.msgUsuario = msgUsuario;
		this.msgDesevolvedor = msgDesevolvedor;
	}


	public String getMsgUsuario() {
		return msgUsuario;
	}


	public String getMsgDesevolvedor() {
		return msgDesevolvedor;
	}

	
	
}

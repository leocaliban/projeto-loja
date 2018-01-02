package com.leocaliban.loja.services.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoException (String mensagem) {
		super(mensagem);
	}
	public ObjetoNaoEncontradoException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}
}

package com.comida.demo.core.exception;

public class AlimentoException extends Exception {

	private static final long serialVersionUID = -5562328648351241726L;

	/**
	 * Construtor com a mensagem
	 * 
	 * @param menssagem
	 */

	public AlimentoException(String menssagem) {
		super(menssagem);
	}

	/**
	 * Construtor com a causa
	 * 
	 * @param causa
	 */
	public AlimentoException(Exception causa) {
		super(causa);
	}

	/**
	 * Construtor com a mensagem e a causa da excecao
	 * 
	 * @par public EntidadeNaoEncontradaException(Exception causa) { super(causa); }
	 * 
	 *      /** Construtor com a mensagem e a causa da excecao
	 * @param menssagem
	 * @param causa
	 */
	public AlimentoException(String menssagem, Exception causa) {
		super(menssagem, causa);
	}
	
}

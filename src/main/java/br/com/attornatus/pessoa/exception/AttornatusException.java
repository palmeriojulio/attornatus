package br.com.attornatus.pessoa.exception;

public class AttornatusException extends RuntimeException {

	
	private static final long serialVersionUID = 8596351288031457670L;

	public AttornatusException(String message) {
		super(message);
	}
	
	public AttornatusException() {
		
	}
}

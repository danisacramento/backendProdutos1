package br.com.sacramento.lojadeprodutos.security;

import javax.xml.bind.DatatypeConverter;

import br.com.sacramento.lojadeprodutos.model.Usuario;

public class Autenticator {
private static final String PREFIXO="*GeNeRaTiOn|";
	
	public static String generateToken(Usuario usuario) {
		String str = PREFIXO + usuario.toString();
		String token = DatatypeConverter.printHexBinary(str.getBytes());
		return token;
	}
	
	public static boolean isValid(String token) {
	    byte[] vetor = DatatypeConverter.parseHexBinary(token);
	    String novaString = new String(vetor);
	    System.out.println("DEBUG = "+novaString);
	    if (novaString.startsWith(PREFIXO)) {
	    	return true;
	    }
	    return false;
	}

}

/**
 *
 */
package com.xebia.mowitnow.exception;


/**
 * @author :  deungoue yann
 * @date : 10 juil. 2015
 */
public class ParseFlatFileException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2177331738326306537L;

	/**
	 * Constructor
	 */
	public ParseFlatFileException( String message) {
		System.out.println("[ERROR]:Erreur dans la lecture du fichier\n"
						 + "[REASON] : "+message);
	}

	

}

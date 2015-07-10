/**
 *
 */
package com.xebia.mowitnow.exception;

import com.xebia.mowitnow.IMowerConstant;

/**
 * @author :  deungoue yann
 * @date : 9 juil. 2015
 */
public class JavaVersionException extends Exception {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public JavaVersionException() {
		System.out.println("[ERROR]:Version de Java doit est >="
							+IMowerConstant.MINIMAL_JAVA_VERSION
							+"\nUne Mise à jour est recommandée ");
	}

}

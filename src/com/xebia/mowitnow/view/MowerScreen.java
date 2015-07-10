/**
 *
 */
package com.xebia.mowitnow.view;

import com.xebia.mowitnow.pojo.Mower;

/**
 * @author :  deungoue yann
 * @date : 9 juil. 2015
 */
public class MowerScreen {
	
	public static void startSystem(){
		System.out.println("***************************************\n"
				 		 + "*       Démarrage des Tondeuses       *\n"
				 		 + "*                                     *\n"
				 		 + "***************************************");
	}
	
	public static void stopSystem(){
		System.out.println("\n"
						 + "***************************************\n"
				 		 + "*         Arret des Tondeuses         *\n"
				 		 + "*                                     *\n"
				 		 + "***************************************\n");
	}
	
	public static void systemOk(){
		System.out.println("Système : ON...");
	}

	public static void mowerStart(Mower mower) {
		System.out.println("La Tondeuse démarre en : "+mower);
	}

	public static void mowerEnd(Mower mower) {
		System.out.println("La Tondeuse arrive en : "+mower);
		System.out.println("***************************************");
	}

	public static void stopSystemWithErrors() {
		System.out.println("Système : OFF...");
	}

}

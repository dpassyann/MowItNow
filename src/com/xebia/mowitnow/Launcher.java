/**
 *
 */
package com.xebia.mowitnow;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.xebia.mowitnow.controller.MowerController;
import com.xebia.mowitnow.provider.AStatementProvider;
import com.xebia.mowitnow.provider.impl.FlatFileStatementProvider;
import com.xebia.mowitnow.provider.impl.MockStatementProvider;

/**
 * @author :  deungoue yann
 * @date : 9 juil. 2015
 */
public class Launcher {

	
	
	/**
	 * Entry point of the program
	 * @param args
	 */
	public static void main(String[] args) {
		
		AStatementProvider provider = null;
		if( args.length == 0 ){
			provider = new MockStatementProvider();
		}else{
			String strPath = args[0];
			Path path = Paths.get(strPath);
			provider = new FlatFileStatementProvider(path);
		}
		MowerController.launchSystem( provider );
		
		

	}

}

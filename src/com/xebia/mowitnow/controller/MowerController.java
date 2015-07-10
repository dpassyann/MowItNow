/**
 *
 */
package com.xebia.mowitnow.controller;

import java.util.List;
import java.util.Map;

import com.xebia.mowitnow.IMowerConstant;
import com.xebia.mowitnow.controller.action.IMowAction;
import com.xebia.mowitnow.exception.JavaVersionException;
import com.xebia.mowitnow.exception.ParseFlatFileException;
import com.xebia.mowitnow.pojo.Mower;
import com.xebia.mowitnow.provider.AStatementProvider;
import com.xebia.mowitnow.view.MowerScreen;

/**
 * @author :  deungoue yann
 * @date : 9 juil. 2015
 */
public class MowerController {
	

	/**
	 * Method to launch the System.
	 * @param provider of mowers and actions
	 */
	public static void launchSystem( AStatementProvider provider ) {
		MowerScreen.startSystem();
		try {
			if( isJavaVersionRequired() ){
				MowerScreen.systemOk();
				mow( provider.getMowerActionListOnMap() );
			}
		} catch (JavaVersionException | ParseFlatFileException e) {
			MowerScreen.stopSystemWithErrors();
		}
		finally{
			MowerScreen.stopSystem();
		}
	}

	private static void mow( Map< Mower, List<IMowAction> > mowActionMap ){

		for( Mower mower : mowActionMap.keySet() ){
			List<IMowAction> actions = mowActionMap.get( mower );
			MowerScreen.mowerStart( mower );
			mower.doActions( actions );
			MowerScreen.mowerEnd( mower );
		}
	}

	private static boolean isJavaVersionRequired() throws JavaVersionException  {
		if( getVersion () > IMowerConstant.MINIMAL_JAVA_VERSION ){
			return true;
		}
		throw new JavaVersionException();
	}

	private static double getVersion () {
		String version = System.getProperty( "java.version" );
		int pos = version.indexOf( '.' );
		pos = version.indexOf( '.', pos+1 );
		return Double.parseDouble ( version.substring ( 0, pos ) );
	}

}

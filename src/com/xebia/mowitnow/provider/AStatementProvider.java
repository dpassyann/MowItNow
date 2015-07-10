/**
 *
 */
package com.xebia.mowitnow.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xebia.mowitnow.controller.action.IMowAction;
import com.xebia.mowitnow.controller.action.MowerActionFactory;
import com.xebia.mowitnow.exception.ParseFlatFileException;
import com.xebia.mowitnow.pojo.Lawn;
import com.xebia.mowitnow.pojo.Mower;

/**
 * @author :  deungoue yann
 * @date : 8 juil. 2015
 */
public abstract class AStatementProvider {

	/**
	 * get Mower and his Actions on Map
	 * @return MowerActionListOnMap
	 * @throws Exception 
	 */
	public abstract Map< Mower, List<IMowAction> > getMowerActionListOnMap() throws ParseFlatFileException;
	
	/**
	 * Method to initialize the lawn
	 * @return the lawn
	 */
	public abstract Lawn getLawn() throws ParseFlatFileException;
	
	
	/**
	 * Method to parse the actions string into IMowAction
	 * @param actions in string to be transform into IMowAction
	 * @return the list of IMowAction
	 */
	public List<IMowAction> getParsedMowAction( String strActions ) {
		MowerActionFactory factory = MowerActionFactory.getInstance();
		List<IMowAction> actions = new ArrayList<IMowAction>();
		for( int pos = 0; pos < strActions.length(); pos++ ){
			actions.add( factory.createMowAction( strActions.substring(pos, pos+1) ) );
		}
		return actions;
	}
	
}

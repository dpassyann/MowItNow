/**
 *
 */
package com.xebia.mowitnow.controller.action;

import java.util.HashMap;
import java.util.Map;

import com.xebia.mowitnow.controller.action.impl.ForwardAction;
import com.xebia.mowitnow.controller.action.impl.LeftAction;
import com.xebia.mowitnow.controller.action.impl.NullAction;
import com.xebia.mowitnow.controller.action.impl.RightAction;

/**
 * @author :  deungoue yann
 * @date : 9 juil. 2015
 */
public class MowerActionFactory {
	
	final private static String FORWARD = "A"; 
	final private static String RIGHT = "D"; 
	final private static String LEFT = "G"; 

	private Map<String, IMowAction> registry = new HashMap<String, IMowAction>();
	
	private static MowerActionFactory instance = new MowerActionFactory();
	
	private MowerActionFactory() {
		registry.put( FORWARD, new ForwardAction() );
		registry.put( RIGHT, new RightAction() );
		registry.put( LEFT, new LeftAction() );
	}
	
	//singleton
	public static MowerActionFactory getInstance(){
		return instance;
	}
	
	public IMowAction createMowAction( String key){
		IMowAction action = registry.get( key );
		if( action == null ){
			action = new NullAction();
		}
		return action;
	}

}

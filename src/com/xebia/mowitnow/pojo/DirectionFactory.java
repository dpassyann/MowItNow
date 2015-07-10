/**
 *
 */
package com.xebia.mowitnow.pojo;

import java.util.HashMap;
import java.util.Map;

import com.xebia.mowitnow.pojo.impl.East;
import com.xebia.mowitnow.pojo.impl.North;
import com.xebia.mowitnow.pojo.impl.South;
import com.xebia.mowitnow.pojo.impl.West;

/**
 * @author :  deungoue yann
 * @date : 10 juil. 2015
 */
public class DirectionFactory {

	private Map<String, IDirection> registry = new HashMap<String, IDirection>();
	
	private static DirectionFactory instance = new DirectionFactory();
	
	private DirectionFactory() {
		registry.put( "N", new North() );
		registry.put( "S", new South() );
		registry.put( "W", new West() );
		registry.put( "E", new East() );
	}
	
	//singleton
	public static DirectionFactory getInstance(){
		return instance;
	}
	
	public IDirection createDirection( String key){
		IDirection direction = registry.get( key );
		return direction;
	}

}

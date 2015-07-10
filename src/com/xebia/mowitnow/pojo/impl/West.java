/**
 *
 */
package com.xebia.mowitnow.pojo.impl;

import com.xebia.mowitnow.pojo.IDirection;
import com.xebia.mowitnow.pojo.Position;

/**
 * @author :  deungoue yann
 * @date : 8 juil. 2015
 */
public class West implements IDirection{
	
	final private static String WEST = "W";

	@Override
	public Position forward(Position position) {
		Position p = new Position( position.getX()-1, position.getY() );
		return p;
	}

	@Override
	public IDirection left() {
		return new South();
	}

	@Override
	public IDirection right() {
		return new North();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return WEST;
	}
}

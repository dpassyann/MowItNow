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
public class North implements IDirection {
	
	final private static String NORTH = "N";

	@Override
	public Position forward(Position position) {
		Position p = new Position(position.getX(), position.getY()+1);
		return p;
	}

	@Override
	public IDirection left() {
		return new West();
	}

	@Override
	public IDirection right() {
		
		return new East();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return NORTH;
	}
}

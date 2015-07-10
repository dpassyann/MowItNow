/**
 *
 */
package com.xebia.mowitnow.pojo;

/**
 * @author :  deungoue yann
 * @date : 8 juil. 2015
 */
public class Position {
	
	private int x;
	
	private int y;

	/**
	 * Contructor
	 * @param _x : position abscissa
	 * @param _y : ordinate position
	 */
	public Position(int _x, int _y) {
		x = _x;
		y = _y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(x).append(" ").append(y);
		return builder.toString();
	}

	/**
	 * @return the x abscissa
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y ordinate
	 */
	public int getY() {
		return y;
	}
	
	

}

/**
 *
 */
package com.xebia.mowitnow.pojo;


/**
 * @author :  deungoue yann
 * @date : 9 juil. 2015
 */
public class Lawn {
	//forecast
	private Position lower;
	
	private Position upper;

	/**
	 * Constructor
	 * @param _lower position of the lawn
	 * @param _upper position of the lawn
	 */
	public Lawn( Position _lower, Position _upper) {
		lower = _lower;
		upper = _upper;
	}
	
	/**
	 * Method allowing you to know whether you are in the borders of the lawn
	 * @param position of the mower
	 * @return true if is inside, false otherwise
	 */
	public boolean isInside( Position position){
		int x = position.getX();
		int y = position.getY();
		
		return ( lower.getX() <= x && x <= upper.getX() ) 
								   && 
			   ( lower.getY() <= y && y <= upper.getY() );
	}

	/**
	 * @return the lower
	 */
	public Position getLower() {
		return lower;
	}

	/**
	 * @return the upper
	 */
	public Position getUpper() {
		return upper;
	}
}

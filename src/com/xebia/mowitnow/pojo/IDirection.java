/**
 *
 */
package com.xebia.mowitnow.pojo;


/**
 * @author :  deungoue yann
 * @date : 8 juil. 2015
 */
public interface IDirection {
	/**
	 * Method to move forward
	 * @param position starting position
	 * @return the new position after moving
	 */
	Position forward( Position position);
	/**
	 * Method to move to left
	 * @return
	 */
	IDirection left();
	/**
	 * Method to move to right
	 * @return
	 */
	IDirection right();
}

/**
 *
 */
package com.xebia.mowitnow.pojo;

import java.util.List;

import com.xebia.mowitnow.controller.action.IMowAction;

/**
 * @author :  deungoue yann
 * @date : 9 juil. 2015
 */
public class Mower {
	
	private IDirection direction;
	
	private Position position;
	
	private Lawn lawn;

	/**
	 * Constructor
	 * @param direction initial direction of the mower
	 * @param position initial position of the mower
	 * @param lawn characteristics of the lawn where the mower will mow
	 */
	public Mower(IDirection _direction, Position _position, Lawn _lawn) {
		direction = _direction;
		position = _position;
		lawn = _lawn;
	}
	
	public void doActions( List<IMowAction> actions){
		for(IMowAction action : actions){
			execute( action );
		}
	}
	
	//visitor Hollywood principle
	private void execute(IMowAction action){
		action.mow(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(position).append(" ").append(direction);
		return builder.toString();
	}
	
	/**
	 * @return the direction
	 */
	public IDirection getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(IDirection direction) {
		this.direction = direction;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the lawn
	 */
	public Lawn getLawn() {
		return lawn;
	}
	
}

/**
 *
 */
package com.xebia.mowitnow.controller.action.impl;

import com.xebia.mowitnow.controller.action.IMowAction;
import com.xebia.mowitnow.pojo.IDirection;
import com.xebia.mowitnow.pojo.Mower;

/**
 * @author :  deungoue yann
 * @date : 9 juil. 2015
 */
public class RightAction implements IMowAction {
	
	/* (non-Javadoc)
	 * @see com.xebia.mowitnow.controller.action.IMowAction#mow(com.xebia.mowitnow.pojo.Mower)
	 */
	@Override
	public void mow(Mower mower) {
		IDirection direction = mower.getDirection().right();
		mower.setDirection(direction);
	}

}

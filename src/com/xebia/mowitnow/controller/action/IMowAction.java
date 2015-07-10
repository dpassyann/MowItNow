/**
 *
 */
package com.xebia.mowitnow.controller.action;

import com.xebia.mowitnow.pojo.Mower;

/**
 * @author :  deungoue yann
 * @date : 8 juil. 2015
 */
public interface IMowAction {
	/**
	 * Action to mow the lawn
	 * @param mower use to mow
	 */
	public void mow(Mower mower);
}

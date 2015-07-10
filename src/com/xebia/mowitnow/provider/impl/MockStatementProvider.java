/**
 *
 */
package com.xebia.mowitnow.provider.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xebia.mowitnow.controller.action.IMowAction;
import com.xebia.mowitnow.pojo.Lawn;
import com.xebia.mowitnow.pojo.Mower;
import com.xebia.mowitnow.pojo.Position;
import com.xebia.mowitnow.pojo.impl.East;
import com.xebia.mowitnow.pojo.impl.North;
import com.xebia.mowitnow.provider.AStatementProvider;

/**
 * @author :  deungoue yann
 * @date : 9 juil. 2015
 */
public class MockStatementProvider extends AStatementProvider {

	@Override
	public Map<Mower, List<IMowAction>> getMowerActionListOnMap() {
		Map<Mower, List<IMowAction>> mowerActionListMap = new HashMap<Mower, List<IMowAction>>();
		
		Mower mower1 = new Mower( new North(), new Position(1,2), getLawn() );
		List<IMowAction> actions1 = getParsedMowAction("GAGAGAGAA");
		mowerActionListMap.put(mower1, actions1);
		
		
		Mower mower2 = new Mower( new East(), new Position(3,3), getLawn() );
		List<IMowAction> actions2 = getParsedMowAction("AADAADADDA");
		mowerActionListMap.put(mower2, actions2);
		
		return mowerActionListMap;
	}

	@Override
	public Lawn getLawn() {
		return new Lawn( new Position(0, 0), new Position(5, 5) );
	}

}

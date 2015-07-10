/**
 *
 */
package com.xebia.mowitnow.provider.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xebia.mowitnow.controller.action.IMowAction;
import com.xebia.mowitnow.exception.ParseFlatFileException;
import com.xebia.mowitnow.pojo.DirectionFactory;
import com.xebia.mowitnow.pojo.IDirection;
import com.xebia.mowitnow.pojo.Lawn;
import com.xebia.mowitnow.pojo.Mower;
import com.xebia.mowitnow.pojo.Position;
import com.xebia.mowitnow.provider.AStatementProvider;

/**
 * @author :  deungoue yann
 * @date : 9 juil. 2015
 */
public class FlatFileStatementProvider extends AStatementProvider {

	private Path path = null;
	
	private Lawn lawn = null;
	
	private List<String> lines = null;
	
	/**
	 * Contructor
	 * @param _path
	 */
	public FlatFileStatementProvider( Path _path) {
		path = _path;
	}
	
	private void initialize() throws ParseFlatFileException{
		getLines();
		getLawn();
	}

	@Override
	public Map<Mower, List<IMowAction>> getMowerActionListOnMap() throws ParseFlatFileException{
		initialize();
		Map<Mower, List<IMowAction>> mowerActionListMap = new HashMap<Mower, List<IMowAction>>();
		for( int pos = 0; pos < lines.size(); pos+=2 ){
			Mower mower = initMower( lines.get( pos ) );
			List<IMowAction> actions = getParsedMowAction( lines.get( pos+1 ) );
			mowerActionListMap.put(mower, actions);
		}
		
		return mowerActionListMap;
	}

	@Override
	public Lawn getLawn() throws ParseFlatFileException{
		String line = lines.get(0);
		try{
			Position lower = new Position(0, 0);
			Position upper = new Position( new Integer( line.substring(0,1) ) , new Integer( line.substring(1,2) ) );
			lawn = new Lawn(lower, upper);
			lines.remove(0);
		}catch( Exception e){
			throw new ParseFlatFileException("Erreur de parsing de fichier");
		}
		return lawn;
	}

	/**
	 * Method to read all the lines of the file
	 * @return all the lines of the file.
	 * @throws ParseFlatFileException 
	 */
	private List<String> getLines() throws ParseFlatFileException{
		List<String> pLines = null;
		if( Files.isRegularFile(path) ){
			try {
				pLines =  Files.readAllLines( path, StandardCharsets.UTF_8 );
			} catch (IOException e) {
				throw new ParseFlatFileException("Erreur de parsing du fichier");
			}
		}else{
			throw new ParseFlatFileException("la source n'est pas un fichier");
		}
		if( pLines != null && !pLines.isEmpty() ){
			lines = new ArrayList<String>();
			for( String line : pLines ){
				Pattern whitespace = Pattern.compile( "\\s" );
				Matcher matcher = whitespace.matcher( line );
				if( matcher.find() ){
					line = matcher.replaceAll( "" );
				}
				line.trim();
				lines.add( line );
			}
		}
		return lines;
	}
	/**
	 * Method to parse the 
	 * @param strMower to parse into mower
	 * @return the mower
	 * @throws ParseFlatFileException
	 */
	private Mower initMower(String strMower) throws ParseFlatFileException {
		Mower mower = null;
		try{
			DirectionFactory factory = DirectionFactory.getInstance();
			IDirection direction = factory.createDirection( strMower.substring( 2 ) );
			Position position = new Position( new Integer( strMower.substring( 0,1 ) ) , new Integer( strMower.substring( 1,2 ) ) );
			mower = new Mower(direction, position, lawn);
		}catch( Exception e){
			throw new ParseFlatFileException("Impossible d'initialiser la tondeuse");
		}
		return mower;
	}

}

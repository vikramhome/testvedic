/**
 * 
 */
package com.vedic.maths;

import java.util.List;

/**
 * @author Badrinath
 *
 */
public final class Utils {

	public static String getCombineString(List<String> str){
		String val="";
		for(String s:str){
			val+=s+"\n";
		}
		return val;
		
		
	}
	
	public static String buildString(String...var ) {
		StringBuilder str = new StringBuilder();
		for(int i=0;i<var.length;i++){
			str.append(var[i]);
		}
		return str.toString();
	}

}

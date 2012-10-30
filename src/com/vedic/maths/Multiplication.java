/**
 * 
 */
package com.vedic.maths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Badrinath
 *
 */
public final class Multiplication {
	
	
	
	
	public static Map<String,Object> checkRules(String fno,String sno,int n){
		Map<String,Object> maps= new HashMap<String, Object>();
		maps.put("flag", true);
		switch(n){
		case 1: 
			if(fno.length()!= sno.length() || fno.length() < 2){
				maps.put("flag", false);
				maps.put("error", "Length of the numbers should be same and more than 1");
				return maps;
			}
			int extractFirstLastno =Integer.parseInt(fno.substring(fno.length()-1)); 
			int extractSecondLastno =Integer.parseInt(sno.substring(sno.length()-1)); 
			if((extractFirstLastno+extractSecondLastno)!=10){
				maps.put("flag", false);
				maps.put("error", "Sum of the last digit of the numbers should be 10");
				return maps;
			}
			int firstDigit=Integer.parseInt(fno.substring(0,fno.length()-1));
			int secondDigit=Integer.parseInt(sno.substring(0,sno.length()-1));
			if((firstDigit!=secondDigit)){
				maps.put("flag", false);
				maps.put("error", "Other digits except the last should be same");
				return maps;
			}
			return maps;
			
			
		case 2:
			if (fno.length() != sno.length()  || fno.length() <2) {
				maps.put("flag", false);
				maps.put("error", "Length of the numbers should be same and more than 1");
				return maps;
			}
			int firstDig=Integer.parseInt(fno.substring(0,1));
			int secondDig=Integer.parseInt(sno.substring(0,1));
			if(firstDig!=9 || secondDig !=9){
				maps.put("flag", false);
				maps.put("error", "Enter number closer to multiple of 10");
				return maps;
			}
			return maps;

		default:
			return maps;
		} 
	}
	
	
	public static  Map<Integer,List<String>> callMultiplication(String fno,String sno,int n){
		switch(n){
		case 1: return method1(fno,sno);
		case 2:	return method2(fno,sno);
		
		
		default:return null;
		}
	}
	
			
	public static Map<Integer,List<String>> method1(String fno,String sno){
		
		Map<Integer,List<String>> maps= new HashMap<Integer,List<String>>();
		ArrayList<String> values= new ArrayList<String>();
		String data=null;
		
		int extractFirstLastno =Integer.parseInt(fno.substring(fno.length()-1)); 
		int extractSecondLastno =Integer.parseInt(sno.substring(sno.length()-1)); 
		
		int firstDigit=Integer.parseInt(fno.substring(0,fno.length()-1));
		int secondDigit=Integer.parseInt(sno.substring(0,sno.length()-1));
		
			
		int first=Integer.parseInt(String.valueOf(fno));
		
		data=Utils.buildString("Last Digit of"," "+fno," is"," "+extractFirstLastno);
		values.add(data);
		data=Utils.buildString("Last Digit of"," "+sno," is"," "+extractSecondLastno);
		values.add(data);
		 
		maps.put(1,values);
		
		ArrayList<String> values2= new ArrayList<String>();
		
		
		data=Utils.buildString("Product of "," "+extractFirstLastno,"*"+extractSecondLastno,"="+extractFirstLastno*extractSecondLastno);
		values2.add(data);
		maps.put(2,values2);
		
		ArrayList<String> values3= new ArrayList<String>();
		
		data=Utils.buildString("First digit of"," "+fno," i.e."+firstDigit," is multiplied with ",firstDigit+"+"+(1));
		values3.add(data);
		data=Utils.buildString("Result will be ",firstDigit+"*"+(firstDigit+1),"="+(firstDigit*(firstDigit+1)));
		values3.add(data);
		
		maps.put(3,values3);
		
		ArrayList<String> values4= new ArrayList<String>();
		int result=(extractFirstLastno*extractSecondLastno);
		String actualres=""+result;
		if(result==9){
			actualres="0"+result;
		}
		data=Utils.buildString("Append"," "+(firstDigit*(firstDigit+1))," to "+(extractFirstLastno*extractSecondLastno));
		values4.add(data);
		data=Utils.buildString("\tResult ","="+(firstDigit*(firstDigit+1)),""+(actualres));
		values4.add(data);
		
		maps.put(4,values4);
		
		return maps;
	}
	
	
	public static Map<Integer,List<String>> method2(String fno,String sno){
	
		Map<Integer,List<String>> maps= new HashMap<Integer,List<String>>();
		ArrayList<String> values= new ArrayList<String>();
		String data=null;
		
		double fnNo=Double.parseDouble(fno);
		double snNo=Double.parseDouble(sno);
		
		int baseVal=(int) Math.pow(10,fno.length());
		
		System.out.println(baseVal);
		
		double extractFirstLastno =baseVal-fnNo; 
		double extractSecondLastno =baseVal-snNo; 
		
		/*int firstDigit=Integer.parseInt(fno.substring(0,fno.length()-1));
		int secondDigit=Integer.parseInt(sno.substring(0,sno.length()-1));
		
			
		int first=Integer.parseInt(String.valueOf(fno));*/
		
		data=Utils.buildString("Subtract "," "+fno," from "," "+baseVal," "+extractFirstLastno);
		values.add(data);
		data=Utils.buildString("Subtract "," "+sno," from", " "+baseVal," "+extractSecondLastno);
		values.add(data);
		 
		maps.put(1,values);
		
		ArrayList<String> values2= new ArrayList<String>();
		
		
		data=Utils.buildString("Product of "," "+extractFirstLastno,"*"+extractSecondLastno,"="+extractFirstLastno*extractSecondLastno);
		values2.add(data);
		maps.put(2,values2);
		
		ArrayList<String> values3= new ArrayList<String>();
		
		data=Utils.buildString("First No"," "+fno," is subtracted with "," "+extractSecondLastno,"="+(fnNo-extractSecondLastno));
		values3.add(data);
		maps.put(3,values3);
		
		
		ArrayList<String> values4= new ArrayList<String>();
		
		data=Utils.buildString("Prepend"," "+(fnNo-extractSecondLastno)," to "+(extractFirstLastno*extractSecondLastno));
		int calZero=(fno.length())-(String.valueOf(((int)extractFirstLastno*extractSecondLastno))).length();
		values4.add(data);
		String res="";
		for(int idx=0;idx<calZero;idx++){
			res+="0";
		}
		data=Utils.buildString("\tResult ","="+((int)(fnNo-extractSecondLastno)),res,"",""+((int)(extractFirstLastno*extractSecondLastno)));
		values4.add(data);
		
		maps.put(4,values4);
		
		return maps;
	}
	
}

package model.expression;

import model.RGBColor;
import java.util.*;



public class Variable implements Expression
{
	private String myName;
	
	public Variable(String name)
	{
		myName = name;
	}
	
	public RGBColor evaluate(HashMap<String, RGBColor> varMap) 
	{				
		return varMap.get(myName);
	}
	
	public String getName()
	{
		return myName;
	}
}

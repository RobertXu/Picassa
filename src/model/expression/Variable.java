package model.expression;

import model.RGBColor;
import java.util.*;



public class Variable implements Expression
{
	private static String myName;
	
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
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			myName = command;
			return (!command.equals("") && currentExp.size() == 0);
		}
	
		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new Variable(myName);
		}
	}
}

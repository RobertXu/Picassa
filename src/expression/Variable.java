package expression;

import java.util.List;

import model.RGBColor;



public class Variable implements Expression
{
	private static String myName;
	private RGBColor myValue;
	
	public Variable(String name)
	{
		myName = name;
	}
	
	public RGBColor evaluate(double evalX, double evalY) 
	{
		/*if (varValues.containsKey(myName))
			return varValues.get(myName);
		else
			throw new IllegalStateException("Variable has no value");*/
		
		return myValue;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public void setValue(RGBColor color)
	{
		myValue = color;
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

package model.expression;

import java.util.HashMap;
import java.util.List;

import model.RGBColor;



public class Constant implements Expression
{
	private double myValue;
	
	public Constant(double value)
	{
		myValue = value;
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) 
	{
		return new RGBColor(myValue);
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("") && currentExp.size() == 0);
		}

		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new Constant(value);
		}
	}
}

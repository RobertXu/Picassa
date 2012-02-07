package model.expression;

import java.util.List;

import model.RGBColor;



public class Ceiling extends OperandExp
{
	public Ceiling(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor toChange = toModify.get(0);
		double newRed = Math.ceil(toChange.getRed());
		double newGreen = Math.ceil(toChange.getGreen());
		double newBlue = Math.ceil(toChange.getBlue());
		
		return new RGBColor(newRed, newGreen, newBlue);
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("ceil") && currentExp.size() == 1);
		}
	
		public Expression ParseExpression(List<Expression> currentExp)
		{
			return new Ceiling(currentExp);
		}
	}
}

package model.expression;

import java.util.List;

import model.RGBColor;



public class SinExp extends OperandExp
{
	public SinExp(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor toChange = toModify.get(0);
		double newRed = Math.sin(toChange.getRed());
		double newGreen = Math.sin(toChange.getGreen());
		double newBlue = Math.sin(toChange.getBlue());
		
		return new RGBColor(newRed, newGreen, newBlue);
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("sin") && currentExp.size() == 1);
		}
	
		public Expression ParseExpression(List<Expression> currentExp)
		{
			return new SinExp(currentExp);
		}
	}
}

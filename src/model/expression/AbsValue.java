package model.expression;

import java.util.List;

import model.RGBColor;



public class AbsValue extends OperandExp
{
	public AbsValue(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor toChange = toModify.get(0);
		double newRed = Math.abs(toChange.getRed());
		double newGreen = Math.abs(toChange.getGreen());
		double newBlue = Math.abs(toChange.getBlue());
		
		return new RGBColor(newRed, newGreen, newBlue);
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("abs") && currentExp.size() == 1);
		}
	
		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new AbsValue(currentExp);
		}
	}
}

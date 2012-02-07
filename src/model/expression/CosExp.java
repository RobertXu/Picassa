package model.expression;

import java.util.List;

import model.RGBColor;



public class CosExp extends OperandExp
{
	public CosExp(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor toChange = toModify.get(0);
		double newRed = Math.cos(toChange.getRed());
		double newGreen = Math.cos(toChange.getGreen());
		double newBlue = Math.cos(toChange.getBlue());
		
		return new RGBColor(newRed, newGreen, newBlue);
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("cos") && currentExp.size() == 1);
		}
	
		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new CosExp(currentExp);
		}
	}
}

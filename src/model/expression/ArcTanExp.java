package model.expression;

import java.util.List;

import model.RGBColor;



public class ArcTanExp extends OperandExp
{
	public ArcTanExp(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor toChange = toModify.get(0);
		double newRed = Math.atan(toChange.getRed());
		double newGreen = Math.atan(toChange.getGreen());
		double newBlue = Math.atan(toChange.getBlue());
		
		return new RGBColor(newRed, newGreen, newBlue);
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("atan") && currentExp.size() == 1);
		}
	
		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new ArcTanExp(currentExp);
		}
	}
}

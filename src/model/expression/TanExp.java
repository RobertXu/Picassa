package model.expression;

import java.util.List;

import model.RGBColor;




public class TanExp extends OperandExp
{
	public TanExp(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor toChange = toModify.get(0);
		double newRed = Math.tan(toChange.getRed());
		double newGreen = Math.tan(toChange.getGreen());
		double newBlue = Math.tan(toChange.getBlue());
		
		return new RGBColor(newRed, newGreen, newBlue);
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("tan") && currentExp.size() == 1);
		}
	
		public Expression ParseExpression(List<Expression> currentExp)
		{
			return new TanExp(currentExp);
		}
	}
}

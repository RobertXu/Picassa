package expression;

import java.util.List;

import model.RGBColor;



public class Floor extends OperandExp
{
	public Floor(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor toChange = toModify.get(0);
		double newRed = Math.floor(toChange.getRed());
		double newGreen = Math.floor(toChange.getGreen());
		double newBlue = Math.floor(toChange.getBlue());
		
		return new RGBColor(newRed, newGreen, newBlue);
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("floor") && currentExp.size() == 1);
		}
	
		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new Floor(currentExp);
		}
	}
}

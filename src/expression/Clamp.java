package expression;

import java.util.List;

import model.RGBColor;



public class Clamp extends OperandExp
{
	public Clamp(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor toChange = toModify.get(0);
		double newRed = CalculateHelper(toChange.getRed());
		double newGreen = CalculateHelper(toChange.getGreen());
		double newBlue = CalculateHelper(toChange.getBlue());
		
		return new RGBColor(newRed, newGreen, newBlue);
	}
	
	public double CalculateHelper(double toClamp)
	{
		if (toClamp > 1.0)
			return 1.0;
		if (toClamp < -1.0)
			return -1.0;
		
		return toClamp;
	}
	
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("clamp") && currentExp.size() == 1);
		}
	
		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new Clamp(currentExp);
		}
	}
}

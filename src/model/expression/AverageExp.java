package model.expression;


import java.util.List;

import model.RGBColor;

public class AverageExp extends OperandExp
{
	public AverageExp(List<Expression> toCreate) 
	{
		super(toCreate);
	}

	RGBColor Calculate(List<RGBColor> toModify) 
	{
		double myRed = 0;
		double myGreen = 0;
		double myBlue = 0;
		
		for (RGBColor r: toModify)
		{
			myRed += r.getRed();
			myGreen += r.getGreen();
			myBlue += r.getBlue();
		}
		
		double length = toModify.size();
		
		return new RGBColor(myRed/length,myGreen/length,myBlue/length);
	}
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("average") && currentExp.size() > 0);
		}
	
		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new AverageExp(currentExp);
		}
	}
}

package model.expression;

import java.util.List;

import model.RGBColor;

public class SumExp extends OperandExp
{

	public SumExp(List<Expression> toCreate) 
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
		
		return new RGBColor(myRed,myGreen,myBlue);
	}
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("sum") && currentExp.size() > 0);
		}
	
		public Expression ParseExpression(List<Expression> currentExp)
		{
			return new SumExp(currentExp);
		}
	}
}

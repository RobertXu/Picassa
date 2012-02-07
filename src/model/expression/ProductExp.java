package model.expression;

import java.util.List;

import model.RGBColor;

public class ProductExp extends OperandExp
{
	public ProductExp(List<Expression> toCreate) 
	{
		super(toCreate);
	}

	RGBColor Calculate(List<RGBColor> toModify) 
	{
		double myRed = 1;
		double myGreen = 1;
		double myBlue = 1;
		
		for (RGBColor r: toModify)
		{
			myRed *= r.getRed();
			myGreen *= r.getGreen();
			myBlue *= r.getBlue();
		}
		
		return new RGBColor(myRed,myGreen,myBlue);
	}
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("product") && currentExp.size() > 0);
		}
	
		public Expression ParseExpression(List<Expression> currentExp)
		{
			return new ProductExp(currentExp);
		}
	}
}

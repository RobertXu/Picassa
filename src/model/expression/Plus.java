package model.expression;

import java.util.List;

import model.RGBColor;




public class Plus extends OperandExp
{
	public Plus(List<Expression> toCreate)
	{
		super(toCreate);
	}

	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor left = toModify.get(0);
		RGBColor right = toModify.get(1);
		
		return new RGBColor(left.getRed() + right.getRed(), 
                left.getGreen() + right.getGreen(),
                left.getBlue() + right.getBlue());
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return ((command.equals("plus")|| command.equals("+")) && currentExp.size() == 2);
		}

	
		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new Plus(currentExp);
		}
	}
}

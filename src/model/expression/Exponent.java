package model.expression;

import java.util.List;

import model.RGBColor;



public class Exponent extends OperandExp
{	
	public Exponent(List<Expression> toCreate)
	{
		super(toCreate);
	}

	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor left = toModify.get(0);
		RGBColor right = toModify.get(1);
		
		return new RGBColor(Math.pow(left.getRed(), right.getRed()),
				Math.pow(left.getGreen(), right.getGreen()),
				Math.pow(left.getBlue(), right.getBlue()));
	}

	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp) 
		{
			return ((command.equals("exp") || command.equals("^")) && currentExp.size() == 2);
		}

		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new Exponent(currentExp);
		}
	}
}

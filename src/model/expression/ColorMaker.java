package model.expression;

import java.util.List;

import model.RGBColor;



public class ColorMaker extends OperandExp
{
	public ColorMaker(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor left = toModify.get(0);
		RGBColor center = toModify.get(1);
		RGBColor right = toModify.get(2);
		
		return new RGBColor(left.getRed(), center.getRed(), right.getRed());
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp) 
		{
			return (command.equals("color") && currentExp.size() == 3);
		}

		public Expression ParseExpression(List<Expression> currentExp) 
		{
			return new ColorMaker(currentExp);
		}
	}
}

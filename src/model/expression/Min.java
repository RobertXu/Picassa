package model.expression;

import java.util.List;

import model.RGBColor;

public class Min extends OperandExp
{
	public Min(List<Expression> toCreate) 
	{
		super(toCreate);
	}

	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor min = new RGBColor(1);
		
		for (RGBColor r: toModify)
		{
			if (min.compareTo(r) > 0)
				min = r;
		}
		
		return min;
	}
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("min") && currentExp.size() > 0);
		}
	
		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new Min(currentExp);
		}
	}
}

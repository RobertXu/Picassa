package model.expression;

import java.util.List;

import model.RGBColor;

public class Max extends OperandExp
{
	public Max(List<Expression> toCreate) 
	{
		super(toCreate);
	}

	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor max = new RGBColor(-1);
		
		for (RGBColor r: toModify)
		{
			if (max.compareTo(r) < 0)
				max = r;
		}
		
		return max;
	}
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("max") && currentExp.size() > 0);
		}
	
		public Expression ParseExpression(List<Expression> currentExp)
		{
			return new Max(currentExp);
		}
	}
}

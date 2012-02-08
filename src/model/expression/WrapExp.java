package model.expression;

import java.util.List;

import model.RGBColor;



public class WrapExp extends OperandExp
{
	public WrapExp(List<Expression> toCreate)
	{
		super(toCreate);
	}

	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor toChange = toModify.get(0);
		toChange.wrap();
		
		return toChange;
	}

	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp) 
		{
			return(command.equals("wrap") && currentExp.size() == 1);
		}

		public Expression ParseExpression(List<Expression> currentExp) 
		{
			return new WrapExp(currentExp);
		}
	}
}

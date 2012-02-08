package model.expression;

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
		toModify.get(0).clamp();
		
		return toModify.get(0);
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("clamp") && currentExp.size() == 1);
		}
	
		public Expression ParseExpression(List<Expression> currentExp)
		{
			return new Clamp(currentExp);
		}
	}
}

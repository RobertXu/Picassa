package model.expression;

import java.util.List;

import model.RGBColor;

public class IfExp extends OperandExp
{

	public IfExp(List<Expression> toCreate) 
	{
		super(toCreate);
	}

	RGBColor Calculate(List<RGBColor> toModify) 
	{
		if(greaterThanZero(toModify.get(0)))
			return toModify.get(1);
		return toModify.get(2);
	}
	
	private boolean greaterThanZero(RGBColor value)
	{
		return ((value.getRed()+value.getBlue()+value.getGreen())/3) > 0 ;
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("if") && currentExp.size() == 3);
		}
	
		public Expression ParseExpression(List<Expression> currentExp)
		{
			return new IfExp(currentExp);
		}
	}
}

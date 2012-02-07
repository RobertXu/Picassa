package model.expression;

import java.util.List;



import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinBW extends OperandExp
{
	public PerlinBW(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{	
		return PerlinNoise.greyNoise(toModify.get(0), toModify.get(1));
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("perlinBW") && currentExp.size() == 2);
		}
	
		public Expression ParseExpression(List<Expression> currentExp)
		{
			return new PerlinBW(currentExp);
		}
	}
}

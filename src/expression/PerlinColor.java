package expression;

import java.util.List;



import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinColor extends OperandExp
{
	public PerlinColor(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{	
		return PerlinNoise.colorNoise(toModify.get(0), toModify.get(1));
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("perlinColor") && currentExp.size() == 2);
		}
	
		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new PerlinColor(currentExp);
		}
	}
}

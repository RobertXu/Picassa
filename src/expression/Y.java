package expression;

import java.util.List;

import model.RGBColor;



public class Y implements Expression
{

	public RGBColor evaluate(double evalX, double evalY)
	{
		return new RGBColor(evalY);
	}
	
	public static class Factory extends ExpressionFactory 
	{

		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("y") && currentExp.size() == 0);
		}

		public Expression ParseExpression(double value, List<Expression> currentExp) 
		{
			return new Y();
		}
	}
}

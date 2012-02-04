package expression;

import java.util.List;

import model.RGBColor;



public class LogExp extends OperandExp
{
	public LogExp(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor toChange = toModify.get(0);
		double newRed = Math.log(toChange.getRed());
		double newGreen = Math.log(toChange.getGreen());
		double newBlue = Math.log(toChange.getBlue());
		
		return new RGBColor(newRed, newGreen, newBlue);
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("log") && currentExp.size() == 1);
		}
	
		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			System.out.println("I am log");
			return new LogExp(currentExp);
		}
	}
}

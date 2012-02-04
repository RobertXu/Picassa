package expression;

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
		double newRed = RGBColor.wrap(toChange.getRed());
		double newGreen = RGBColor.wrap(toChange.getGreen());
		double newBlue = RGBColor.wrap(toChange.getBlue());
		
		return new RGBColor(newRed, newGreen, newBlue);
	}

	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp) 
		{
			return(command.equals("wrap") && currentExp.size() == 1);
		}

		public Expression ParseExpression(double value, List<Expression> currentExp) 
		{
			return new WrapExp(currentExp);
		}
	}
}

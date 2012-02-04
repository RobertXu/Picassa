package expression;

import java.util.List;

import model.RGBColor;



public class Negate extends OperandExp
{
	public Negate(List<Expression> toCreate)
	{
		super(toCreate);
	}

	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		RGBColor color = toModify.get(0);
		
		return new RGBColor(-1*color.getRed(),
				-1*color.getGreen(),
				-1*color.getBlue());
	}

	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("neg") && currentExp.size() == 1);
		}

		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new Negate(currentExp);
		}
	}
}

package model.expression;

import java.util.List;



import model.RGBColor;
import model.util.ColorModel;

public class YCrCbtoRGB extends OperandExp
{
	public YCrCbtoRGB(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		return new RGBColor(ColorModel.ycrcb2rgb(toModify.get(0)));
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("yCrCbtoRGB") && currentExp.size() == 1);
		}
	
		public Expression ParseExpression(List<Expression> currentExp)
		{
			return new YCrCbtoRGB(currentExp);
		}
	}
}

package model.expression;

import java.util.List;



import model.RGBColor;
import model.util.ColorModel;

public class RGBToYCrCb extends OperandExp
{
	public RGBToYCrCb(List<Expression> toCreate)
	{
		super(toCreate);
	}
	
	public RGBColor Calculate(List<RGBColor> toModify) 
	{
		return new RGBColor(ColorModel.rgb2ycrcb(toModify.get(0)));
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("rgbToYCrCb") && currentExp.size() == 1);
		}
	
		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new RGBToYCrCb(currentExp);
		}
	}
}

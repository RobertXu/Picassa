package expression;
import java.awt.Color;
import java.util.List;
import java.util.Random;

import model.RGBColor;



public class RandomColor implements Expression
{
	Random r;
	
	public RandomColor()
	{
		r = new Random();
	}

	public RGBColor evaluate(double evalX, double evalY) 
	{
		int red = r.nextInt(255);
		int green = r.nextInt(255);
		int blue = r.nextInt(255);
		
		return new RGBColor(new Color(red, green, blue ));
	}
	
	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp)
		{
			return (command.equals("random") && currentExp.size() == 0);
		}

		public Expression ParseExpression(double value, List<Expression> currentExp)
		{
			return new RandomColor();
		}
	}


}

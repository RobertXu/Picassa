package expression;

import java.util.List;
import java.util.ArrayList;

import model.RGBColor;



public class LetExp implements Expression
{
	private ArrayList<Expression> toEvaluate;
	
	public LetExp(List<Expression> toCreate)
	{
		toEvaluate = new ArrayList<Expression>(toCreate);
	}

	public RGBColor evaluate(double evalX, double evalY) 
	{
		RGBColor value = evaluateVariable(toEvaluate.get(1), evalX, evalY);
		
		Variable current = (Variable) toEvaluate.get(0);
		
		String varName = current.getName();

		Expression toChange = toEvaluate.get(2);
		
		changeVarValues(toChange, value, varName);
		
		return toChange.evaluate(evalX, evalY);
	}
	
	public void changeVarValues(Expression toChange, RGBColor value, String varName)
	{
		if (toChange instanceof Variable && ((Variable) toChange).getName().equals(varName))
		{
			((Variable) toChange).setValue(value);
		}
		if (toChange instanceof OperandExp)
		{	
			for (Expression e: ((OperandExp) toChange).getOperands())
			{
				changeVarValues(e, value, varName);
			}
		}
	}
	
	public RGBColor evaluateVariable(Expression toCalculate, double evalX, double evalY)
	{
		return toCalculate.evaluate(evalX, evalY);
	}

	public static class Factory extends ExpressionFactory
	{
		public boolean isThisKindOfExp(String command, List<Expression> currentExp) 
		{
			return(command.equals("let") && currentExp.size() == 3);
		}

		public Expression ParseExpression(double value, List<Expression> currentExp) 
		{
			return new LetExp(currentExp);
		}
	}
}

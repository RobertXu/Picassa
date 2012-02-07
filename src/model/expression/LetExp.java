package model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import model.RGBColor;


public class LetExp extends OperandExp
{	
	public LetExp(List<Expression> toCreate)
	{
		super(toCreate);
	}

	public RGBColor Calculate(List<RGBColor> toModify) 
	{	
		return null;
	}
	
	public RGBColor evaluate(HashMap<String, RGBColor> varMap)
	{		
		ArrayList<Expression> operands = getOperands();
		
		Variable current = (Variable) operands.get(0);
		
		String varName = current.getName();
		
		RGBColor value = operands.get(1).evaluate(varMap);
		
		RGBColor oldValue = varMap.get(varName);
		
		varMap.put(varName, value);
		
		RGBColor myValue = operands.get(2).evaluate(varMap);
		
		varMap.put(varName, oldValue);
		
		return myValue;
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

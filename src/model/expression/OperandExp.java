package model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.RGBColor;

public abstract class OperandExp implements Expression
{
	private ArrayList<Expression> Operands;
	
	abstract RGBColor Calculate(List<RGBColor> toModify);
	
	public OperandExp(List<Expression> toCreate)
	{
		Operands = new ArrayList<Expression>(toCreate);
	}
	
	public ArrayList<Expression> getOperands()
	{
		return Operands;
	}
	
	public RGBColor evaluate(HashMap<String, RGBColor> varMap)
	{	
		ArrayList<RGBColor> toModify = new ArrayList<RGBColor>();
		
		for (Expression e: Operands)
		{
			toModify.add(e.evaluate(varMap));
		}
	
		return Calculate(toModify);
	}
}

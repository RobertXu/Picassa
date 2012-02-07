package model.expression;

import java.util.HashMap;

import model.RGBColor;



public class Constant implements Expression
{
	private double myValue;
	
	public Constant(double value)
	{
		myValue = value;
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) 
	{
		return new RGBColor(myValue);
	}
}

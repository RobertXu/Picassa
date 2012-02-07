package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.expression.*;

public class Parser
{	   
	private static ExpressionFactory[] allExpressions = {new ColorMaker.Factory(), 
												 new Divide.Factory(), 
												 new Exponent.Factory(), 
												 new Minus.Factory(), 
												 new Modulus.Factory(), 
												 new Multiply.Factory(),
												 new Negate.Factory(),
												 new Plus.Factory(),
												 new RandomColor.Factory(),
												 new Floor.Factory(),
												 new Ceiling.Factory(),
												 new AbsValue.Factory(),
												 new Clamp.Factory(),
												 new SinExp.Factory(),
												 new CosExp.Factory(),
												 new TanExp.Factory(),
												 new ArcTanExp.Factory(),
												 new LogExp.Factory(),
												 new RGBToYCrCb.Factory(),
												 new YCrCbtoRGB.Factory(),
												 new PerlinColor.Factory(),
												 new PerlinBW.Factory(),
												 new WrapExp.Factory(),
												 new LetExp.Factory(),
												 new IfExp.Factory(),
												 new SumExp.Factory(),
												 new ProductExp.Factory(),
												 new AverageExp.Factory(),
												 new Min.Factory(),
												 new Max.Factory()};
	
	// double is made up of an optional negative sign, followed by a sequence 
    // of one or more digits, optionally followed by a period, then possibly 
    // another sequence of digits
    private static final Pattern DOUBLE_REGEX =
        Pattern.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
    // expression begins with a left paren followed by the command name, 
    // which is a sequence of alphabetic characters
    private static final Pattern EXPRESSION_BEGIN_REGEX =
        Pattern.compile("\\(([a-z+-/%*^!]+)");
    private static final Pattern VARIABLE_REGEX =
    		Pattern.compile("\\w+");
    private static HashMap<Pattern, ExpressionType> patternMap = new HashMap<Pattern, ExpressionType>()
    		{{put(DOUBLE_REGEX, ExpressionType.NUMBER);
    		  put(EXPRESSION_BEGIN_REGEX, ExpressionType.PAREN_EXPRESSION);
    		  put(VARIABLE_REGEX, ExpressionType.VARIABLE);}};

    // different possible kinds of expressions
    private static enum ExpressionType
    {
        NUMBER, PAREN_EXPRESSION, VARIABLE;
    }

    // state of the parser
    private int myCurrentPosition;
    private String myInput;

    /**
     * Converts given string into expression tree.
     * 
     * @param input expression given in the language to be parsed
     * @return expression tree representing the given formula
     */
    public Expression makeExpression (String input)
    {
        myInput = input;
        myCurrentPosition = 0;
        Expression result = parseExpression();
        skipWhiteSpace();
        if (notAtEndOfString())
        {
            throw new ParserException("Unexpected characters at end of the string: " +
                                      myInput.substring(myCurrentPosition),
                                      ParserException.Type.EXTRA_CHARACTERS);
        }
        return result;
    }

    private ExpressionType getExpressionType ()
    {
    	skipWhiteSpace();
    	
    	for(Pattern p: patternMap.keySet())
    	{
    		Matcher expMatch = p.matcher(myInput.substring(myCurrentPosition));
    		if(expMatch.lookingAt())
    			return patternMap.get(p);
    	}
    	
       throw new ParserException("Unexpected Character " + currentCharacter());
    }
    
    private Expression expressionCreator(String command, ArrayList<Expression> currentExp)
    {    	
    	for (ExpressionFactory now: allExpressions)
    	{
    		if (now.isThisKindOfExp(command, currentExp))
    			return now.ParseExpression(currentExp);	
    	}
    	throw new ParserException("Unexpected Input");
    }

    private Expression parseExpression ()
    {	
        switch (getExpressionType())
        {
            case NUMBER:
                return parseNumber();
            case PAREN_EXPRESSION:
                return parseParenExpression();
            case VARIABLE:
            	return parseVariable();
            default:
                throw new ParserException("Unexpected expression type " +
                                          getExpressionType().toString());
        }
    }

    private Expression parseNumber ()
    {
        Matcher doubleMatcher = DOUBLE_REGEX.matcher(myInput);
        doubleMatcher.find(myCurrentPosition);
        String numberMatch =
            myInput.substring(doubleMatcher.start(), doubleMatcher.end());
        myCurrentPosition = doubleMatcher.end();
        // this represents the color gray of the given intensity
        double value = Double.parseDouble(numberMatch);
        
        return new Constant(value);
    }
    
    private Expression parseVariable()
    {
    	Matcher varMatcher = VARIABLE_REGEX.matcher(myInput);
    	varMatcher.find(myCurrentPosition);
    	String varMatch = myInput.substring(varMatcher.start(), varMatcher.end());
    	myCurrentPosition = varMatcher.end();
    	
    	return new Variable(varMatch);
    }


    private Expression parseParenExpression ()
    {
    	ArrayList<Expression> elements = new ArrayList<Expression>();
    	
        Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(myInput);
        expMatcher.find(myCurrentPosition);
        String commandName = expMatcher.group(1);
        myCurrentPosition = expMatcher.end();

        while (notAtEndOfString())
        {        
        	skipWhiteSpace();
        	if (currentCharacter() == ')')
        	{
        		myCurrentPosition++;
        		return expressionCreator(commandName, elements);
        	}
        	
        	elements.add(parseExpression());
        }
       
            throw new ParserException("Expected close paren, instead found " +
                                      myInput.substring(myCurrentPosition));
    }

    private void skipWhiteSpace ()
    {
        while (notAtEndOfString() && Character.isWhitespace(currentCharacter()))
        {
            myCurrentPosition++;
        }
    }

    private char currentCharacter ()
    {
        return myInput.charAt(myCurrentPosition);
    }

    private boolean notAtEndOfString ()
    {
        return myCurrentPosition < myInput.length();
    }
}

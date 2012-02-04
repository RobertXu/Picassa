package expression;

import java.util.List;



public abstract class ExpressionFactory 
{
	public abstract boolean isThisKindOfExp(String command, List<Expression> currentExp);
	
	public abstract Expression ParseExpression(double value, List<Expression> currentExp);
}

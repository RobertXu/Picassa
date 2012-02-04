package expression;

import model.RGBColor;

public interface Expression 
{   
    abstract RGBColor evaluate(double evalX, double evalY);
}

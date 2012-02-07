package model.expression;

import java.util.HashMap;


import model.RGBColor;

public interface Expression 
{   
    abstract RGBColor evaluate(HashMap<String, RGBColor> varMap);
}

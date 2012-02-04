package model.util;

import model.RGBColor;


/**
 * Combine two colors by combining their components.
 * 
 * This is a separate class from color since it is just one set of
 * ways to combine colors, many may exist and we do not want to keep
 * modifying the RGBColor class.
 * 
 * @author Robert C. Duvall
 */
public class ColorCombinations
{
    /**
     * Combine two colors by adding their components.
     */
    public static RGBColor add (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() + right.getRed(), 
                            left.getGreen() + right.getGreen(),
                            left.getBlue() + right.getBlue());
    }
    
    //Create RGB Color from three constants
    
    public static RGBColor color(RGBColor left, RGBColor center, RGBColor right)
    {
    	return new RGBColor(left.getRed(), center.getRed(), right.getRed());
    }
    
    /**
    * Negates (inverts) a given color
    */
    public static RGBColor negate(RGBColor color)
    {
    	return new RGBColor(-1*color.getRed(),
    						-1*color.getGreen(),
    						-1*color.getBlue());
    }
    
    /**
     * Combine two colors by taking the first component to the power of the second component
     */
    public static RGBColor exponent(RGBColor left, RGBColor right)
    {
    	return new RGBColor(Math.pow(left.getRed(), right.getRed()),
    						Math.pow(left.getGreen(), right.getGreen()),
    						Math.pow(left.getBlue(), right.getBlue()));
    }
    
    /**
     * Combine two colors by finding the remainder of the first component when divided by the second component
     */
    public static RGBColor modulus (RGBColor left, RGBColor right)
    {
    	return new RGBColor(left.getRed() % right.getRed(),
    						left.getGreen() % right.getGreen(),
    						left.getBlue() % right.getBlue());
    }

    /**
     * Combine two colors by subtracting their components.
     */
    public static RGBColor subtract (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() - right.getRed(), 
                            left.getGreen() - right.getGreen(),
                            left.getBlue() - right.getBlue());
    }

    /**
     * Combine two colors by multiplying their components.
     */
    public static RGBColor multiply (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() * right.getRed(), 
                            left.getGreen() * right.getGreen(),
                            left.getBlue() * right.getBlue());
    }

    /**
     * Combine two colors by dividing their components.
     */
    public static RGBColor divide (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() / right.getRed(), 
                            left.getGreen() / right.getGreen(),
                            left.getBlue() / right.getBlue());
    }
}

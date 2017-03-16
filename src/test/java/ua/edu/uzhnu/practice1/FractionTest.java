package ua.edu.uzhnu.practice1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Таня on 10.03.2017.
 */
public class FractionTest {

    @Test
    public void test_SanityTest_JUnitWorks(){
        Assert.assertEquals(2, 1+1);
    }

    @Test
    public void test_Constructor2Parameters_Fraction2Parameters (){
        Assert.assertEquals(2+"/"+3, new Fraction(2,3).toString());
    }


    @Test
    public void test_Constructor1Parameter_Fraction1Parameter (){
        Assert.assertEquals ((2+"/"+1), new Fraction(2).toString());
    }

    @Test
    public void test_NoParameter_Fraction0 (){
        Assert.assertEquals ((0 + "/" + 1), new Fraction().toString());
    }

    @Test
    public void test_NegativeDenominator_NegativeNumerator (){
        Fraction f = new Fraction(3,-4);
        Assert.assertEquals ((-3+"/" +4), f.toString());
    }

    @Test
    public void test_NegativeFraction_PositiveFraction (){
        Fraction f = new Fraction(-3,-4);
        Assert.assertEquals ((3+"/"+4), f.toString());
    }

    @Test
    public void test_ToString_StringFraction (){
        Fraction f = new Fraction(3,-4);
        Assert.assertEquals (("-3/4"), f.toString());
    }

   @Test
    public void test_ToDouble_Double (){
        Fraction f = new Fraction(7,5);
        Assert.assertEquals (((double)7/5),f.toDouble(), 0.0001 );
    }

    @Test
    public void test_Inverse_FractionInverse (){
        Fraction f = new Fraction(6,4);
        Fraction h = new Fraction(-1,2);
        Assert.assertEquals ((4+"/"+6), f.inverse().toString());
        Assert.assertEquals ((-2+"/"+1), h.inverse().toString()
        );
    }

    @Test
    public void test_isProper_Property (){
        Fraction f = new Fraction(6,4);
        Fraction g = new Fraction(1,1);
        Fraction h = new Fraction(-1,2);
        Assert.assertEquals (false, f.isProper());
        Assert.assertEquals (false, g.isProper());
        Assert.assertEquals (true, h.isProper());
    }

    @Test
    public void test_Simplify_SimplifiedFraction (){
        Fraction f = new Fraction(6,4);
        Fraction g = new Fraction(-5,10);
        Assert.assertEquals ((3+"/"+2), f.simplify().toString());
        Assert.assertEquals ((-1+"/"+2), g.simplify().toString());
    }

    @Test
    public void test_Addition_FractionAdd (){
        Fraction f = new Fraction(6,4);
        Fraction g = new Fraction(-5,10);
        Fraction h = new Fraction(7,10);
        Assert.assertEquals ((1+"/"+1), Fraction.add(f,g).simplify().toString());
        Assert.assertEquals ((11+"/"+5), Fraction.add(f,h).simplify().toString());
    }

    @Test
    public void test_Subtraction_FractionSubtract (){
        Fraction f = new Fraction(6,4);
        Fraction g = new Fraction(-5,10);
        Fraction h = new Fraction(7,10);
        Assert.assertEquals ((2+"/"+1), Fraction.subtract(f,g).simplify().toString());
        Assert.assertEquals ((4+"/"+5), Fraction.subtract(f,h).simplify().toString());
    }

    @Test
    public void test_Multiplication_FractionMultiply (){
        Fraction f = new Fraction(6,4);
        Fraction g = new Fraction(-5,10);
        Fraction h = new Fraction(7,10);
        Assert.assertEquals ((-3+"/"+4), Fraction.multiply(f,g).simplify().toString());
        Assert.assertEquals ((21+"/"+20), Fraction.multiply(f,h).simplify().toString());
    }

    @Test
    public void test_Division_FractionDivide (){
        Fraction f = new Fraction(6,4);
        Fraction g = new Fraction(-5,10);
        Fraction h = new Fraction(7,10);
        Assert.assertEquals ((-3+"/"+1), Fraction.divide(f,g).simplify().toString());
        Assert.assertEquals ((15+"/"+7), Fraction.divide(f,h).simplify().toString());
    }
}

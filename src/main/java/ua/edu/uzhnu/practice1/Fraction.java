package ua.edu.uzhnu.practice1;

/**
 * Created by Таня on 02.03.2017.
 */
public class Fraction {

    private  int numerator;
    private  int denominator;

    public  Fraction (){

    }

    public Fraction ( int a ) {
        numerator = a;
        denominator = 1;
    }

    public  Fraction ( int a, int b) {
        numerator = a;
        denominator = b;
        if ( b == 0) {
            throw  new IllegalArgumentException( " ділення на 0");
        }
    }

    public String toString() {
        return ( numerator + "/" + denominator);
    }

    public Double toDouble() {
        return ( ( double ) numerator / denominator);
    }

    public boolean isProper() {
        int a = numerator;
        int b = denominator;
        return (a < b);
    }


    public Fraction inverse() {
        Fraction inv = new Fraction();
        inv.numerator = denominator;
        inv.denominator = numerator;
        return inv;
    }


    public Fraction simplify() {
        Fraction simplified = new Fraction();
        int n = gcd(numerator, denominator);
        simplified.numerator = numerator / n;
        simplified.denominator = denominator / n;
        return simplified;
    }

    public static Fraction add (Fraction a, Fraction b) {
        Fraction result = new Fraction();
        result.denominator =  a.denominator * b.denominator;
        result.numerator = a.numerator * b.denominator + b.numerator * a.denominator ;
        int r = gcd ( result.numerator, result.denominator);
        result.numerator = result.numerator / r;
        result.denominator = result.denominator / r;
        return result;
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        Fraction result = new Fraction();
        result.denominator = a.denominator * b.denominator;
        result.numerator = a.numerator * b.denominator - b.numerator * a.denominator;
        int r = gcd ( Math.abs( result.numerator ), Math.abs(result.denominator));
        result.numerator = result.numerator / r;
        result.denominator = result.denominator / r;
        return result;
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        Fraction result = new Fraction();
        result.numerator = a.numerator * b.numerator;
        result.denominator = a.denominator * b.denominator;
        int t = gcd ( result.numerator, result.denominator);
        result.numerator = result.numerator / t;
        result.denominator = result.denominator / t;
        return result;
    }

    public static Fraction divide(Fraction a, Fraction b) {
        Fraction result = new Fraction();
        result.numerator = a.numerator * b.denominator;
        result.denominator = a.denominator * b.numerator;
        int t = gcd ( result.numerator, result.denominator);
        result.numerator = result.numerator / t;
        result.denominator = result.denominator / t;
        return result;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public static Fraction valueOf ( String s) {
        Fraction result = new Fraction();
        char t = s.charAt(0);
        String t1 = String.valueOf(t);
        char h = s.charAt(2);
        String h1 = String.valueOf(h);
        result.numerator = Integer.parseInt(t1);
        result.denominator = Integer.parseInt(h1);
        return result;
    }

    private static int gcd (int a, int b) {
        if (a == b) {
            return b;
        }
        while (b!=0) {
            if (a>b) {
                a -= b;
            }
            else {
                b-=a;
            }
        }
        return a;

    }
}


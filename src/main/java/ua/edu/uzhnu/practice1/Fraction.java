package ua.edu.uzhnu.practice1;

/**
 * Created by Таня on 02.03.2017.
 */
public class Fraction {

    private  int numerator;
    private  int denominator;

    public Fraction ( int a ) {
        numerator = a;
        denominator = 1;
    }

    public Fraction ( ) {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменник не може дорівнювати 0");
        }

        if (denominator > 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        } else {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
    }


    public String toString() {
        return ( numerator + "/" + denominator);
    }

    public Double toDouble() {
        return ( ( double ) numerator / denominator);
    }

    public boolean isProper() {
        return (Math.abs(numerator)<denominator);
    }


    public Fraction inverse() {
        Fraction inv = new Fraction();
        if (numerator>0 && denominator>0) {
            inv.numerator = denominator;
            inv.denominator = numerator;
        } else if (numerator<0 && denominator>0){
            inv.numerator = - denominator;
            inv.denominator = - numerator;
        }
            return inv;
    }

    public Fraction simplify() {
        int gcd = gcd(numerator, denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    public static Fraction add (Fraction a, Fraction b) {
        Fraction result = new Fraction();
        result.denominator =  a.denominator * b.denominator;
        result.numerator = a.numerator * b.denominator + b.numerator * a.denominator ;
        return result.simplify();
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        Fraction result = new Fraction();
        result.denominator = a.denominator * b.denominator;
        result.numerator = a.numerator * b.denominator - b.numerator * a.denominator;
        return result.simplify();
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        Fraction result = new Fraction();
        result.numerator = a.numerator * b.numerator;
        result.denominator = a.denominator * b.denominator;
        return result.simplify();
    }

    public static Fraction divide(Fraction a, Fraction b) {
        Fraction result = new Fraction();
        result.numerator = a.numerator * b.denominator;
        result.denominator = a.denominator * b.numerator;
        return result.simplify();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}


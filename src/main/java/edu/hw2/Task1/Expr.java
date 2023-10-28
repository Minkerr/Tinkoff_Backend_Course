package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    public record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return this.value;
        }
    }

    public record Negate(double value) implements Expr {
        @Override
        public double evaluate() {
            return -value;
        }
    }

    public record Exponent(double base, double exponent) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(base, exponent);
        }
    }

    public record Addition(double firstValue, double secondValue) implements Expr {
        @Override
        public double evaluate() {
            return firstValue + secondValue;
        }
    }

    public record Multiplication(double firstValue, double secondValue) implements Expr {
        @Override
        public double evaluate() {
            return firstValue * secondValue;
        }
    }
}

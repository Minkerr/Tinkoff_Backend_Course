package edu.hw10;

public class FibonacciCalculator implements FibCalc {
    @Override
    public long fib(int number) {
        if (number == 0 || number == 1) {
            return number;
        }
        int f1 = 0;
        int f2 = 1;
        for (int i = 1; i < number; i++) {
            f2 = f2 + f1;
            f1 = f2 - f1;
        }
        return f2;
    }
}

package edu.hw10;

public interface FibCalc {
    @Cache(true)
    long fib(int number);
}

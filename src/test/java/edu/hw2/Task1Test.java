package edu.hw2;

import edu.hw2.Task1.Expr;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Task1Test {
    final double ACCURACY = 0.0001;

    @Test
    void evaluateExponent_shouldReturnSixteenIfArgumentsEqualArgumentsTwoAndFour() {
        //arrange
        double expected = 16;
        double base = 2;
        double exponent = 4;
        //act
        Expr res = new Expr.Exponent(base, exponent);
        double act = res.evaluate();
        //assert
        assertThat(act).isLessThan(expected + ACCURACY).isGreaterThan(expected - ACCURACY);
    }

    @Test
    void evaluateExponent_shouldReturnThreeIfArgumentsEqualNineAndOneHalf() {
        //arrange
        double expected = 3;
        double base = 9;
        double exponent = 0.5;
        //act
        Expr res = new Expr.Exponent(base, exponent);
        double act = res.evaluate();
        //assert
        assertThat(act).isLessThan(expected + ACCURACY).isGreaterThan(expected - ACCURACY);
    }

    @Test
    void evaluateConstant_shouldReturnTheSameValue() {
        //arrange
        double expected = 2.39;
        double someValue = 2.39;
        //act
        Expr res = new Expr.Constant(someValue);
        double act = res.evaluate();
        //assert
        assertThat(act).isLessThan(expected + ACCURACY).isGreaterThan(expected - ACCURACY);
    }

    @Test
    void evaluateNegate_shouldReturnOppositeValue() {
        //arrange
        double expected = -13;
        double someValue = 13;
        //act
        Expr res = new Expr.Negate(someValue);
        double act = res.evaluate();
        //assert
        assertThat(act).isLessThan(expected + ACCURACY).isGreaterThan(expected - ACCURACY);
    }

    @Test
    void evaluateNegate_shouldReturnZeroIfArgumentEqualZero() {
        //arrange
        double expected = 0;
        double someValue = 0;
        //act
        Expr res = new Expr.Negate(someValue);
        double act = res.evaluate();
        //assert
        assertThat(act).isLessThan(expected + ACCURACY).isGreaterThan(expected - ACCURACY);
    }

    @Test
    void evaluateAddition_shouldAddTwoNumbers() {
        //arrange
        double expected = 33.11;
        double firstNumber = 35.78;
        double secondNumber = -2.67;
        //act
        Expr res = new Expr.Addition(firstNumber, secondNumber);
        double act = res.evaluate();
        //assert
        assertThat(act).isLessThan(expected + ACCURACY).isGreaterThan(expected - ACCURACY);
    }

    @Test
    void evaluateAddition_shouldAddZeroPointOneAndZeroPointTwo() { // tricky test: (0.1 + 0.2 = 0.3000.....004)
        //arrange
        double expected = 0.3;
        double firstNumber = 0.2;
        double secondNumber = 0.1;
        //act
        Expr res = new Expr.Addition(firstNumber, secondNumber);
        double act = res.evaluate();
        //assert
        assertThat(act).isLessThan(expected + ACCURACY).isGreaterThan(expected - ACCURACY);
    }

    @Test
    void evaluateMultiplication_shouldMultipleTwoNumbers() { // tricky test: (0.1 + 0.2 = 0.3000.....004)
        //arrange
        double expected = 3.18;
        double firstNumber = 2.12;
        double secondNumber = 1.5;
        //act
        Expr res = new Expr.Multiplication(firstNumber, secondNumber);
        double act = res.evaluate();
        //assert
        assertThat(act).isLessThan(expected + ACCURACY).isGreaterThan(expected - ACCURACY);
    }
}




package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SquareTest {

    @Test
    void setWidthFromSquare_shouldReturnRectangleWithEqualSides() {
        //arrange
        Square square1 = new Square();
        Rectangle square = square1.setWidth(20);
        //assert
        assertThat(square.area()).isEqualTo(400.0);
    }

    @Test
    void setWidth_shouldNotChangeFields() {
        //arrange
        Rectangle square = new Square();
        //act
        square.setWidth(20); //this method don't change any fields. It only returns new object
        //assert
        assertThat(square.area()).isEqualTo(1.0);
    }
}




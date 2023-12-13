package edu.hw10;

import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void nextObject_shouldGenerateRandomObjects()
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        //arrange
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        //act
        var obj = randomObjectGenerator.nextObject(Person.class);
        //assert
        assertThat(obj.getClass()).isEqualTo(Person.class);
    }
}

package edu.hw10;

import org.junit.jupiter.api.RepeatedTest;
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
        var obj = (Person) randomObjectGenerator.nextObject(Person.class);
        //assert
        assertThat(obj.getClass()).isEqualTo(Person.class);
    }

    @Test
    void nextObject_shouldGenerateRandomObjectsForRecords()
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        //arrange
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        //act
        var obj = randomObjectGenerator.nextObject(Student.class);
        //assert
        assertThat(obj.getClass()).isEqualTo(Student.class);
    }

    @RepeatedTest(10)
    void nextObject_shouldGenerateRandomObjectsByFabricMethodAndGenerate()
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        //arrange
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        //act
        var obj = randomObjectGenerator.nextObject(Person.class, "create");
        Person pers = (Person) obj;
        //assert
        assertThat(obj.getClass()).isEqualTo(Person.class);
        assertThat(pers.getDoubleField()).isLessThan(10);
        assertThat(pers.getAge()).isGreaterThan(18);
    }
}

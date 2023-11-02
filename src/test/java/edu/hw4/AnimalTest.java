package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static edu.hw4.Animal.*;
import static edu.hw4.StreamOperationsWithAnimals.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AnimalTest {
    @Test
    void sortAnimalsByHeight_shouldSortThreeAnimalsByHeight() {
        //arrange
        Animal a1 = new Animal("name", Type.BIRD, Sex.M, 1, 1, 1, false);
        Animal a2 = new Animal("name", Type.BIRD, Sex.M, 1, 4, 1, false);
        Animal a3 = new Animal("name", Type.BIRD, Sex.M, 1, 2, 1, false);
        Animal a4 = new Animal("name", Type.BIRD, Sex.M, 1, 3, 1, false);
        List<Animal> exp = List.of(a1, a3, a4, a2);
        //act
        List<Animal> act = sortAnimalsByHeight(List.of(a1, a2, a3, a4));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void sortAnimalsByWeight_shouldReturnFirstKTheHeaviestAnimals() {
        //arrange
        Animal a1 = new Animal("name", Type.BIRD, Sex.M, 1, 1, 1, false);
        Animal a2 = new Animal("name", Type.BIRD, Sex.M, 1, 1, 2, false);
        Animal a3 = new Animal("name", Type.BIRD, Sex.M, 1, 1, 3, false);
        Animal a4 = new Animal("name", Type.BIRD, Sex.M, 1, 1, 4, false);
        Animal a5 = new Animal("name", Type.BIRD, Sex.M, 1, 1, 5, false);
        List<Animal> exp = List.of(a5, a4, a3);
        //act
        List<Animal> act = sortAnimalsByWeight(List.of(a1, a2, a3, a4, a5), 3);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void countAnimalsByType_shouldGroupAnimalsByType() {
        //arrange
        Animal a1 = new Animal("name", Type.BIRD, Sex.M, 1, 1, 1, false);
        Animal a2 = new Animal("name", Type.BIRD, Sex.M, 1, 1, 2, false);
        Animal a3 = new Animal("name", Type.CAT, Sex.M, 1, 1, 3, false);
        Animal a4 = new Animal("name", Type.CAT, Sex.M, 1, 1, 4, false);
        Animal a5 = new Animal("name", Type.SPIDER, Sex.M, 1, 1, 5, false);
        Map<Animal.Type, Long> exp = new HashMap<>();
        exp.put(Type.CAT, 2L);
        exp.put(Type.BIRD, 2L);
        exp.put(Type.SPIDER, 1L);
        //act
        var act = countAnimalsByType(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void findTheLongestAnimalName_shouldFindTheLongestAnimalName() {
        //arrange
        Animal a1 = new Animal("name", Type.BIRD, Sex.M, 1, 1, 1, false);
        Animal a2 = new Animal("longName", Type.BIRD, Sex.M, 1, 1, 2, false);
        Animal a3 = new Animal("veryLongName", Type.CAT, Sex.M, 1, 1, 3, false);
        Animal a4 = new Animal("Bob", Type.CAT, Sex.M, 1, 1, 4, false);
        Animal a5 = new Animal("longName", Type.SPIDER, Sex.M, 1, 1, 5, false);
        Animal exp = a3;
        //act
        var act = findTheLongestAnimalName(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void compareAnimalsBySex_shouldFindTheMostFrequentSex() {
        //arrange
        Animal a1 = new Animal("name", Type.BIRD, Sex.M, 1, 1, 1, false);
        Animal a2 = new Animal("name", Type.BIRD, Sex.F, 1, 1, 2, false);
        Animal a3 = new Animal("name", Type.CAT, Sex.M, 1, 1, 3, false);
        Animal a4 = new Animal("name", Type.CAT, Sex.M, 1, 1, 4, false);
        Animal a5 = new Animal("name", Type.SPIDER, Sex.F, 1, 1, 5, false);
        Sex exp = Sex.M;
        //act
        var act = compareAnimalsBySex(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void findTheHeaviestAnimalForEveryType_shouldFindTheHeaviestAnimalForEveryType() {
        //arrange
        Animal a1 = new Animal("name", Type.BIRD, Sex.M, 1, 1, 1, false);
        Animal a2 = new Animal("name", Type.BIRD, Sex.F, 1, 1, 2, false);
        Animal a3 = new Animal("name", Type.CAT, Sex.M, 1, 1, 3, false);
        Animal a4 = new Animal("name", Type.CAT, Sex.M, 1, 1, 4, false);
        Animal a5 = new Animal("name", Type.SPIDER, Sex.F, 1, 1, 5, false);
        Map<Animal.Type, Animal> exp = new HashMap<>();
        exp.put(Type.CAT, a4);
        exp.put(Type.BIRD, a2);
        exp.put(Type.SPIDER, a5);
        //act
        var act = findTheHeaviestAnimalForEveryType(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void findTheOldestAnimal_shouldFindTheOldestAnimal() {
        //arrange
        Animal a1 = new Animal("name", Type.BIRD, Sex.M, 10, 1, 1, false);
        Animal a2 = new Animal("name", Type.BIRD, Sex.M, 20, 1, 2, false);
        Animal a3 = new Animal("name", Type.CAT, Sex.M, 50, 1, 3, false);
        Animal a4 = new Animal("name", Type.CAT, Sex.M, 30, 1, 4, false);
        Animal a5 = new Animal("name", Type.SPIDER, Sex.M, 40, 1, 5, false);
        Animal exp = a3;
        //act
        var act = findTheOldestAnimal(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void findTheHeaviestAnimalBelowK_shouldFindTheHeaviestAnimalBelowK() {
        //arrange
        Animal a1 = new Animal("name", Type.BIRD, Sex.M, 1, 40, 1, false);
        Animal a2 = new Animal("name", Type.BIRD, Sex.M, 1, 30, 2, false);
        Animal a3 = new Animal("name", Type.BIRD, Sex.M, 1, 20, 3, false);
        Animal a4 = new Animal("name", Type.BIRD, Sex.M, 1, 10, 4, false);
        Animal a5 = new Animal("name", Type.BIRD, Sex.M, 1, 50, 5, false);
        Optional<Animal> exp = Stream.of(a4).findFirst();
        //act
        var act = findTheHeaviestAnimalBelowK(List.of(a1, a2, a3, a4, a5), 35);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void sumPaws_shouldSumAllAnimalPaws() {
        //arrange
        Animal a1 = new Animal("name", Type.BIRD, Sex.M, 1, 40, 1, false);
        Animal a2 = new Animal("name", Type.CAT, Sex.M, 1, 30, 2, false);
        Animal a3 = new Animal("name", Type.SPIDER, Sex.M, 1, 20, 3, false);
        Animal a4 = new Animal("name", Type.FISH, Sex.M, 1, 10, 4, false);
        Animal a5 = new Animal("name", Type.DOG, Sex.M, 1, 50, 5, false);
        int exp = 18;
        //act
        var act = sumPaws(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void filterAnimalsWithDifferentAgeAndPawQuantity_shouldFilterAnimalsWithDifferentAgeAndPawQuantity() {
        //arrange
        Animal a1 = new Animal("name", Type.BIRD, Sex.M, 2, 40, 1, false);
        Animal a2 = new Animal("name", Type.CAT, Sex.M, 1, 30, 2, false);
        Animal a3 = new Animal("name", Type.SPIDER, Sex.M, 8, 20, 3, false);
        Animal a4 = new Animal("name", Type.FISH, Sex.M, 1, 10, 4, false);
        Animal a5 = new Animal("name", Type.DOG, Sex.M, 4, 50, 5, false);
        List<Animal> exp = List.of(a2, a4);
        //act
        var act = filterAnimalsWithDifferentAgeAndPawQuantity(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void filterBitingHighAnimals_shouldFilterBitingHighAnimals() {
        //arrange
        Animal a1 = new Animal("name", Type.BIRD, Sex.M, 2, 400, 1, false);
        Animal a2 = new Animal("name", Type.CAT, Sex.M, 1, 300, 2, true);
        Animal a3 = new Animal("name", Type.SPIDER, Sex.M, 8, 200, 3, true);
        Animal a4 = new Animal("name", Type.FISH, Sex.M, 1, 10, 4, false);
        Animal a5 = new Animal("name", Type.DOG, Sex.M, 4, 500, 5, false);
        List<Animal> exp = List.of(a2, a3);
        //act
        var act = filterBitingHighAnimals(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void countAnimalsWithWeightGreaterThanHeight_shouldCountAnimalsWithWeightGreaterThanHeight() {
        //arrange
        Animal a1 = new Animal("name", Type.BIRD, Sex.M, 2, 400, 100, false);
        Animal a2 = new Animal("name", Type.CAT, Sex.M, 1, 300, 200, true);
        Animal a3 = new Animal("name", Type.SPIDER, Sex.M, 8, 200, 300, true);
        Animal a4 = new Animal("name", Type.FISH, Sex.M, 1, 10, 400, false);
        Animal a5 = new Animal("name", Type.DOG, Sex.M, 4, 500, 500, false);
        Long exp = 2L;
        //act
        var act = countAnimalsWithWeightGreaterThanHeight(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void filterAnimalsWithNamesWithTwoOrMOreWords_shouldFilterAnimalsWithNamesWithTwoOrMOreWords() {
        //arrange
        Animal a1 = new Animal("Peter", Type.BIRD, Sex.M, 2, 400, 1, false);
        Animal a2 = new Animal("Mike Mangini", Type.CAT, Sex.M, 1, 300, 2, true);
        Animal a3 = new Animal("Bob", Type.SPIDER, Sex.M, 8, 200, 3, true);
        Animal a4 = new Animal("John", Type.FISH, Sex.M, 1, 10, 4, false);
        Animal a5 = new Animal("Mike Portnoy", Type.DOG, Sex.M, 4, 500, 5, false);
        List<Animal> exp = List.of(a2, a5);
        //act
        var act = filterAnimalsWithNamesWithTwoOrMOreWords(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void filterDogsWithHigherThanK_shouldFilterDogsWithHigherThanK() {
        //arrange
        Animal a1 = new Animal("name", Type.DOG, Sex.M, 2, 400, 1, false);
        Animal a2 = new Animal("name", Type.CAT, Sex.M, 1, 300, 2, true);
        Animal a3 = new Animal("name", Type.CAT, Sex.M, 8, 200, 3, true);
        Animal a4 = new Animal("name", Type.DOG, Sex.M, 1, 10, 4, false);
        Animal a5 = new Animal("name", Type.DOG, Sex.M, 4, 500, 5, false);
        //act
        var act = filterDogsWithHigherThanK(List.of(a1, a2, a3, a4, a5), 100);
        //assert
        assertThat(act).isTrue();
    }

    @Test
    void sumWeightForEveryType_shouldSumWeightForEveryType() {
        //arrange
        Animal a1 = new Animal("name", Type.DOG, Sex.M, 4, 400, 1, false);
        Animal a2 = new Animal("name", Type.CAT, Sex.M, 1, 300, 2, true);
        Animal a3 = new Animal("name", Type.CAT, Sex.M, 8, 200, 3, true);
        Animal a4 = new Animal("name", Type.CAT, Sex.M, 5, 10, 4, false);
        Animal a5 = new Animal("name", Type.DOG, Sex.M, 6, 500, 5, false);
        Map<Animal.Type, Integer> exp = new HashMap<>();
        exp.put(Type.CAT, 4);
        exp.put(Type.DOG, 6);
        //act
        var act = sumWeightForEveryType(List.of(a1, a2, a3, a4, a5), 3, 7);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void sortAnimalsByThreeParameters_shouldSortAnimalsByThreeParameters() {
        //arrange
        Animal a1 = new Animal("Mike", Type.DOG, Sex.M, 4, 400, 1, false);
        Animal a2 = new Animal("Mike", Type.CAT, Sex.M, 1, 300, 2, true);
        Animal a3 = new Animal("John", Type.SPIDER, Sex.M, 8, 200, 3, true);
        Animal a4 = new Animal("John", Type.CAT, Sex.M, 5, 10, 4, false);
        Animal a5 = new Animal("Mike", Type.DOG, Sex.F, 6, 500, 5, false);
        List<Animal> exp = List.of(a4, a2, a1, a5, a3);
        //act
        var act = sortAnimalsByThreeParameters(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void checkWhetherSpidersBiteMoreOftenThanDogs_shouldCheckWhetherSpidersBiteMoreOftenThanDogs() {
        //arrange
        Animal a1 = new Animal("Mike", Type.DOG, Sex.M, 4, 400, 1, false);
        Animal a2 = new Animal("Mike", Type.DOG, Sex.M, 1, 300, 2, true);
        Animal a3 = new Animal("John", Type.SPIDER, Sex.M, 8, 200, 3, true);
        Animal a4 = new Animal("John", Type.SPIDER, Sex.M, 5, 10, 4, false);
        Animal a5 = new Animal("Mike", Type.SPIDER, Sex.F, 6, 500, 5, false);
        //act
        var act = checkWhetherSpidersBiteMoreOftenThanDogs(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isTrue();
    }

    @Test
    void findTheHeaviestFish_shouldFindTheHeaviestFish() {
        //arrange
        Animal a1 = new Animal("Mike", Type.DOG, Sex.M, 4, 400, 1, false);
        Animal a2 = new Animal("Mike", Type.DOG, Sex.M, 1, 300, 2, true);
        Animal a3 = new Animal("John", Type.DOG, Sex.M, 8, 200, 3, true);
        Animal a4 = new Animal("John", Type.FISH, Sex.M, 5, 10, 4, false);
        Animal a5 = new Animal("Mike", Type.FISH, Sex.F, 6, 500, 6, false);
        Animal a6 = new Animal("Mike", Type.FISH, Sex.F, 7, 600, 5, false);
        Animal exp = a5;
        //act
        var act = findTheHeaviestFish(List.of(List.of(a1, a2), List.of(a3, a4), List.of(a5, a6)));
        //assert
        assertThat(act).isEqualTo(a5);
    }

    @Test
    void getValidationErrors_shouldReturnAnimalErrors() {
        //arrange
        Animal a1 = new Animal("Mike Portnoy", Type.DOG, Sex.M, 4, 400, 1, false);
        Animal a2 = new Animal("Mike111", Type.CAT, Sex.M, 100, 20, 2, true);
        Animal a3 = new Animal("John222", Type.SPIDER, Sex.M, 1, 1, 1, true);
        Animal a4 = new Animal("John with err*r", Type.BIRD, Sex.M, 5, 1, 400, false);
        Animal a5 = new Animal("Bad n@me", Type.FISH, Sex.F, 62, 500, 6, false);
        Map<String, Set<ValidationError>> exp = new HashMap<>();
        exp.put("Mike Portnoy", new HashSet<>(List.of(new ValidationError(ValidationError.IncorrectField.HEIGHT))));
        exp.put("Mike111", new HashSet<>(List.of(new ValidationError(ValidationError.IncorrectField.AGE))));
        exp.put("John with err*r", new HashSet<>(List.of(
            new ValidationError(ValidationError.IncorrectField.WEIGHT),
            new ValidationError(ValidationError.IncorrectField.NAME)
        )));
        exp.put("Bad n@me", new HashSet<>(List.of(
            new ValidationError(ValidationError.IncorrectField.HEIGHT),
            new ValidationError(ValidationError.IncorrectField.AGE),
            new ValidationError(ValidationError.IncorrectField.NAME)
            )));
        //act
        var act = getValidationErrors(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void getStringValidationErrors_shouldReturnAnimalErrorsInString() {
        //arrange
        Animal a1 = new Animal("Mike Portnoy", Type.DOG, Sex.M, 4, 400, 1, false);
        Animal a2 = new Animal("Mike111", Type.CAT, Sex.M, 100, 20, 2, true);
        Animal a3 = new Animal("John222", Type.SPIDER, Sex.M, 1, 1, 1, true);
        Animal a4 = new Animal("John with err*r", Type.BIRD, Sex.M, 5, 1, 400, false);
        Animal a5 = new Animal("Bad n@me", Type.FISH, Sex.F, 62, 500, 6, false);
        Map<String, String> exp = new HashMap<>();
        exp.put("Mike Portnoy", "This animal has the following incorrect fields: height");
        exp.put("Mike111", "This animal has the following incorrect fields: age");
        exp.put("John with err*r", "This animal has the following incorrect fields: name, weight");
        exp.put("Bad n@me", "This animal has the following incorrect fields: age, name, height");
        //act
        var act = getStringValidationErrors(List.of(a1, a2, a3, a4, a5));
        //assert
        assertThat(act).isEqualTo(exp);
    }
}

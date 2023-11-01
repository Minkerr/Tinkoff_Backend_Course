package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public final class StreamOperationsWithAnimals {
    private StreamOperationsWithAnimals() {
    }

    public static List<Animal> sortAnimalsByHeight(List<Animal> animals) { //task1
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    public static List<Animal> sortAnimalsByWeight(List<Animal> animals, int k) { //task2
        return animals.stream()
            .sorted((leftAnimal, rightAnimal) -> rightAnimal.weight() - leftAnimal.weight())
            .limit(k)
            .toList();
    }

    public static Map<Animal.Type, Long> countAnimalsByType(List<Animal> animals) { //task3
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, (Collectors.counting())));
    }

    public static Animal findTheLongestAnimalName(List<Animal> animals) { //task4
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .get();
    }

    public static Animal.Sex compareAnimalsBySex(List<Animal> animals) { //task5
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, (Collectors.counting())))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .get()
            .getKey();
    }

    public static Map<Animal.Type, Animal> findTheHeaviestAnimalForEveryType(List<Animal> animals) { //task6
        return animals.stream()
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.maxBy(Comparator.comparingInt(Animal::weight))
            ))
            .entrySet()
            .stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                v -> v.getValue().get()
            ));
    }

    public static Animal findTheOldestAnimal(List<Animal> animals) { //task7
        return animals.stream()
            .max(Comparator.comparingInt(Animal::age))
            .get();
    }

    public static Optional<Animal> findTheHeaviestAnimalBelowK(List<Animal> animals, int k) { //task8
        return animals.stream()
            .filter(o -> o.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer sumPaws(List<Animal> animals) { //task9
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    public static List<Animal> filterAnimalsWithDifferentAgeAndPawQuantity(List<Animal> animals) { //task10
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
    }

    @SuppressWarnings("MagicNumber")
    public static List<Animal> filterBitingHighAnimals(List<Animal> animals) { //task11
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > 100)
            .toList();
    }

    public static Long countAnimalsWithWeightGreaterThanHeight(List<Animal> animals) { //task12
        return animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    public static List<Animal> filterAnimalsWithNamesWithTwoOrMOreWords(List<Animal> animals) { //task13
        return animals.stream()
            .filter(animal -> animal.name().contains(" "))
            .toList();
    }

    public static boolean filterDogsWithHigherThanK(List<Animal> animals, int k) { //task14
        return animals.stream()
            .anyMatch(animal -> animal.height() > k && animal.type() == Animal.Type.DOG);
    }

    public static Map<Animal.Type, Integer> sumWeightForEveryType(List<Animal> animals, int k, int l) { //task15
        return animals.stream()
            .filter(animal -> k < animal.age() && animal.age() < l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public static List<Animal> sortAnimalsByThreeParameters(List<Animal> animals) { //task16
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name)
            )
            .toList();
    }
}

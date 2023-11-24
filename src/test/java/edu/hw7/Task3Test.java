package edu.hw7;

import edu.hw7.Task3.Person;
import edu.hw7.Task3.PersonDatabase;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    void findBy_shouldWorkInParallelAndFindOnePerson() {
        // arrange
        PersonDatabase db = new PersonDatabase();
        ExecutorService executor = Executors.newFixedThreadPool(8);
        // act
        for (int i = 0; i < 999999; i++) {
            Person person = new Person(i, "name" + i, "address" + i, "phone" + i);
            executor.execute(() -> db.add(person));
        }

        for (int i = 0; i < 999999; i++) {
            String name = "name" + i;
            String address = "address" + i;
            String phone = "phone" + i;
            executor.execute(() -> {
                    Person byName = db.findByName(name);
                    Person byAddress = db.findByName(address);
                    Person byPhone = db.findByName(phone);

                    assertThat(byName.equals(byAddress) && byName.equals(byPhone)).isTrue();
                }
            );

        }
        executor.shutdown();
    }

    @Test
    void findBy_shouldWorkWithDelete() {
        // arrange
        PersonDatabase db = new PersonDatabase();
        ExecutorService executor = Executors.newFixedThreadPool(8);
        // act
        for (int i = 0; i < 99999; i++) {
            Person person = new Person(i, "name" + i, "address" + i, "phone" + i);
            executor.execute(() -> db.add(person));
        }

        for (int i = 10000; i < 99999; i++) {
            int num = i;
            executor.execute(() -> db.delete(num));
        }

        for (int i = 0; i < 99999; i++) {
            String name = "name" + i;
            String address = "address" + i;
            String phone = "phone" + i;
            executor.execute(() -> {
                    Person byName = db.findByName(name);
                    Person byAddress = db.findByName(address);
                    Person byPhone = db.findByName(phone);

                    assertThat(byName == null && byAddress == null && byPhone == null ||
                        byName.equals(byAddress) && byName.equals(byPhone)).isTrue();
                }
            );

        }
        executor.shutdown();
    }
}



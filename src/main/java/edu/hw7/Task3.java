package edu.hw7;

import java.util.HashMap;
import java.util.Map;

public class Task3 {

    private Task3() {
    }

    public record Person(int id, String name, String address, String phoneNumber) {
    }

    static class PersonDatabase {
        private final static Map<String, Person> PHONE_MAP = new HashMap<>();
        private final static Map<String, Person> ADDRESS_MAP = new HashMap<>();
        private final static Map<String, Person> NAME_MAP = new HashMap<>();
        private final static Map<Integer, Person> ID_MAP = new HashMap<>();

        public synchronized void add(Person person) {
            PHONE_MAP.put(person.phoneNumber, person);
            NAME_MAP.put(person.name, person);
            ADDRESS_MAP.put(person.address, person);
            ID_MAP.put(person.id, person);
        }

        public synchronized void delete(int id) {
            Person person = ID_MAP.get(id);
            ID_MAP.remove(person.id);
            ADDRESS_MAP.remove(person.address);
            NAME_MAP.remove(person.name);
            PHONE_MAP.remove(person.phoneNumber);
        }

        public synchronized Person findByName(String name) {
            return NAME_MAP.get(name);
        }

        public synchronized Person findByAddress(String address) {
            return ADDRESS_MAP.get(address);
        }

        public synchronized Person findByPhone(String phone) {
            return PHONE_MAP.get(phone);
        }
    }

    static class PersonDatabaseNotSynchronized {
        private final static Map<String, Person> PHONE_MAP = new HashMap<>();
        private final static Map<String, Person> ADDRESS_MAP = new HashMap<>();
        private final static Map<String, Person> NAME_MAP = new HashMap<>();
        private final static Map<Integer, Person> ID_MAP = new HashMap<>();

        public void add(Person person) {
            PHONE_MAP.put(person.phoneNumber, person);
            NAME_MAP.put(person.name, person);
            ADDRESS_MAP.put(person.address, person);
            ID_MAP.put(person.id, person);
        }

        public void delete(int id) {
            Person person = ID_MAP.get(id);
            ID_MAP.remove(person.id);
            ADDRESS_MAP.remove(person.address);
            NAME_MAP.remove(person.name);
            PHONE_MAP.remove(person.phoneNumber);
        }

        public Person findByName(String name) {
            return NAME_MAP.get(name);
        }

        public Person findByAddress(String address) {
            return ADDRESS_MAP.get(address);
        }

        public Person findByPhone(String phone) {
            return PHONE_MAP.get(phone);
        }
    }
}

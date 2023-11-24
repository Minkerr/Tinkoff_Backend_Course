package edu.hw7;

import java.util.HashMap;
import java.util.Map;

public class Task3 {

    private Task3() {
    }

    public record Person(int id, String name, String address, String phoneNumber) {
    }

    static class PersonDatabase {
        PersonDatabase() {
            phoneMap = new HashMap<>();
            addressMap = new HashMap<>();
            nameMap = new HashMap<>();
            idMap = new HashMap<>();
        }

        private static Map<String, Person> phoneMap;
        private static Map<String, Person> addressMap;
        private static Map<String, Person> nameMap;
        private static Map<Integer, Person> idMap;

        public synchronized void add(Person person) {
            phoneMap.put(person.phoneNumber, person);
            nameMap.put(person.name, person);
            addressMap.put(person.address, person);
            idMap.put(person.id, person);
        }

        public synchronized void delete(int id) {
            Person person = idMap.get(id);
            idMap.remove(person.id);
            addressMap.remove(person.address);
            nameMap.remove(person.name);
            phoneMap.remove(person.phoneNumber);
        }

        public synchronized Person findByName(String name) {
            return nameMap.get(name);
        }

        public synchronized Person findByAddress(String address) {
            return addressMap.get(address);
        }

        public synchronized Person findByPhone(String phone) {
            return phoneMap.get(phone);
        }
    }

    static class PersonDatabaseNotSynchronized {
        PersonDatabaseNotSynchronized() {
            phoneMap = new HashMap<>();
            addressMap = new HashMap<>();
            nameMap = new HashMap<>();
            idMap = new HashMap<>();
        }

        private static Map<String, Person> phoneMap;
        private static Map<String, Person> addressMap;
        private static Map<String, Person> nameMap;
        private static Map<Integer, Person> idMap;

        public void add(Person person) {
            phoneMap.put(person.phoneNumber, person);
            nameMap.put(person.name, person);
            addressMap.put(person.address, person);
            idMap.put(person.id, person);
        }

        public void delete(int id) {
            Person person = idMap.get(id);
            idMap.remove(person.id);
            addressMap.remove(person.address);
            nameMap.remove(person.name);
            phoneMap.remove(person.phoneNumber);
        }

        public Person findByName(String name) {
            return nameMap.get(name);
        }

        public Person findByAddress(String address) {
            return addressMap.get(address);
        }

        public Person findByPhone(String phone) {
            return phoneMap.get(phone);
        }
    }
}

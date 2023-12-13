package edu.hw10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class RandomObjectGenerator {
    private final int generatingBound = 100;

    public RandomObjectGenerator() {
    }

    public Object nextObject(Class<?> objectClass)
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?>[] constructors = objectClass.getDeclaredConstructors();
        int constructorNumber = ThreadLocalRandom.current().nextInt(0, constructors.length);
        Constructor<?> constructor = constructors[constructorNumber];
        Class<?>[] parameterTypes = constructor.getParameterTypes();

        Object[] parameters = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> paramClass = parameterTypes[i];
            parameters[i] = generateParameter(paramClass);
        }

        constructor.setAccessible(true);
        return constructor.newInstance(parameters);
    }

    private Object generateParameter(Class<?> c) {
        if (c.equals(String.class)) {
            return generateString();
        } else if (c.equals(int.class)) {
            return generateInteger();
        } else if (c.equals(double.class)) {
            return generateDouble();
        } else if (c.equals(long.class)) {
            return generateLong();
        } else {
            throw new ClassFormatError();
        }
    }

    private int generateInteger() {
        return ThreadLocalRandom.current().nextInt(1, generatingBound);
    }

    private double generateDouble() {
        return ThreadLocalRandom.current().nextDouble(1, generatingBound);
    }

    private long generateLong() {
        return ThreadLocalRandom.current().nextLong(1, generatingBound);
    }

    private String generateString() {
        return "random_string";
    }

}

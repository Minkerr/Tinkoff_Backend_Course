package edu.hw10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomObjectGenerator {
    private final int GENERATING_BOUND = 100;

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
        return ThreadLocalRandom.current().nextInt(1, GENERATING_BOUND);
    }

    private double generateDouble() {
        return ThreadLocalRandom.current().nextDouble(1, GENERATING_BOUND);
    }

    private long generateLong() {
        return ThreadLocalRandom.current().nextLong(1, GENERATING_BOUND);
    }

    private String generateString() {
        return "random_string";
    }

}

package edu.hw10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomObjectGenerator {
    private final int defaultMax = 100;
    private final int defaultMin = 1;
    private final List<String> defaultNames = List.of("John", "Mike", "Kevin", "James");

    public RandomObjectGenerator() {
    }

    public Object nextObject(Class<?> objectClass)
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?>[] constructors = objectClass.getDeclaredConstructors();
        int constructorNumber = ThreadLocalRandom.current().nextInt(0, constructors.length);
        Constructor<?> constructor = constructors[constructorNumber];
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Parameter[] parameters = constructor.getParameters();

        Object[] resultParameters = generateParametersForNewObject(parameters, parameterTypes);
        constructor.setAccessible(true);
        return constructor.newInstance(resultParameters);
    }

    public Object nextObject(Class<?> objectClass, String methodName)
        throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method method = null;
        try {
            method = getMethodByName(objectClass, methodName);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        Parameter[] parameters = method.getParameters();

        Object[] resultParameters = generateParametersForNewObject(parameters, parameterTypes);
        method.setAccessible(true);
        return method.invoke(nextObject(objectClass), resultParameters);
    }

    private Object[] generateParametersForNewObject(Parameter [] parameters, Class<?>[] parameterTypes){
        Object[] resultParameters = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> paramClass = parameterTypes[i];
            Parameter param = parameters[i];
            int min = defaultMin;
            int max = defaultMax;
            boolean notNull = false;
            if (param.getAnnotation(Min.class) != null) {
                min = (param.getAnnotation(Min.class)).value();
            }
            if (param.getAnnotation(Max.class) != null) {
                max = (param.getAnnotation(Max.class)).value();
            }
            if (param.getAnnotation(NotNull.class) != null) {
                notNull = true;
            }
            resultParameters[i] = generateParameter(paramClass, min, max, notNull);
        }
        return resultParameters;
    }

    private Method getMethodByName(Class<?> objectClass, String methodName) throws NoSuchMethodException {
        Method[] methods = objectClass.getDeclaredMethods();
        for (var method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        throw new NoSuchMethodException();
    }


    private Object generateParameter(Class<?> c, int min, int max, boolean notNull) {
        if (c.equals(String.class)) {
            return generateString(notNull);
        } else if (c.equals(int.class)) {
            return generateInteger(min, max);
        } else if (c.equals(double.class)) {
            return generateDouble(min, max);
        } else if (c.equals(long.class)) {
            return generateLong(min, max);
        } else {
            throw new ClassFormatError();
        }
    }

    private int generateInteger(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    private double generateDouble(int min, int max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    private long generateLong(int min, int max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    private String generateString(boolean notNull) {
        String name = null;
        if (notNull) {
            int ind = generateInteger(0, defaultNames.size());
            name = defaultNames.get(ind);
        }
        return name;
    }

}

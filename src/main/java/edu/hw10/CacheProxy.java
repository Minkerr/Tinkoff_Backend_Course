package edu.hw10;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Path;

public class CacheProxy {
    private static final Path CACHE_PATH =
        Path.of("src" + File.separator + "main" + File.separator + "java" + File.separator
            + "edu" + File.separator + "hw10" + File.separator + "cache" + File.separator + "cache.txt");

    private static void writeMethodResultToFile(Object result) throws IOException {
        if (!Files.exists(CACHE_PATH)) {
            Files.createFile(CACHE_PATH);
        }
        try {
            Files.write(CACHE_PATH, result.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T create(Object object, Class<? extends T> objClass) {
        ClassLoader objectClassLoader = objClass.getClassLoader();
        Class<?>[] interfaces = objClass.getInterfaces();
        var proxyObject = Proxy.newProxyInstance(objectClassLoader, interfaces,
            new ObjectInvocationHandler(object)
        );
        return (T) proxyObject;
    }

    public static class ObjectInvocationHandler implements InvocationHandler {
        private Object object;

        public ObjectInvocationHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = method.invoke(object, args);
            if (method.getAnnotation(Cache.class).value()) {
                writeMethodResultToFile(result);
            }
            return result;
        }
    }
}

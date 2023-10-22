package edu.hw2.Task4;

public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        Thread current = Thread.currentThread();

        StackTraceElement[] methods = current.getStackTrace();
        StackTraceElement method = current.getStackTrace()[methods.length - 1];
        return new CallingInfo(method.getClassName(), method.getMethodName());
    }
}

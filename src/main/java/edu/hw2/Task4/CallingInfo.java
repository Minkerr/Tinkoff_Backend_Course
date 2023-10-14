package edu.hw2.Task4;

public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        Thread current = Thread.currentThread();
        StackTraceElement method = current.getStackTrace()[1]; //getStackTrace[0] contains itself
        return new CallingInfo(method.getClassName(), method.getMethodName());
    }
}

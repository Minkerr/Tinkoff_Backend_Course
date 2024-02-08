package edu.project5;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.LambdaMetafactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Thread)
public class ReflectionBenchmark {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(ReflectionBenchmark.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(1)
            .warmupForks(1)
            .warmupIterations(1)
            .warmupTime(TimeValue.seconds(5))
            .measurementIterations(1)
            .measurementTime(TimeValue.seconds(5))
            .build();

        new Runner(options).run();
    }

    record Student(String name, String surname) {
    }

    private Student student;
    private Method method;
    private MethodHandle methodMH;
    private Supplier<?> lm;

    @Setup
    public void setup() throws Throwable {
        student = new Student("Alexander", "Biryukov");

        method = student.getClass().getMethod("name");
        method.setAccessible(true);

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(String.class);
        methodMH = lookup.findVirtual(Student.class, "name", mt);

        CallSite site = LambdaMetafactory.metafactory(
            lookup,
            "get",
            MethodType.methodType(Supplier.class, Student.class),
            MethodType.methodType(Object.class),
            methodMH,
            mt
        );
        lm = (Supplier<?>) site.getTarget().invokeExact(student);
    }

    @Benchmark
    public void lambdaMetafactoryAccess(Blackhole bh) throws Throwable {
        Object name = lm.get();
        bh.consume(name);
    }

    @Benchmark
    public void methodHandleAccess(Blackhole bh) throws Throwable {
        Object name = methodMH.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void directAccess(Blackhole bh) {
        String name = student.name();
        bh.consume(name);
    }

    @Benchmark
    public void reflection(Blackhole bh) throws InvocationTargetException, IllegalAccessException {
        Object name = method.invoke(student);
        bh.consume(name);
    }
}
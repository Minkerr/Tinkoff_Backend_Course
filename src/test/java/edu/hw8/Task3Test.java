package edu.hw8;

import org.junit.jupiter.api.Test;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import static edu.hw8.Task3.Task3.nextPassword;
import static edu.hw8.Task3.Task3.passwordEncoding;
import static edu.hw8.Task3.Task3.passwordEncodingMultithread;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    void passwordEncoding_test() throws NoSuchAlgorithmException {
        //arrange
        Map<String, String> given = new HashMap<>();
        given.put("e10adc3949ba59abbe56e057f20f883e", "a.v.petrov");
        given.put("d8578edf8458ce06fbc5bb76a58c5ca4", "v.v.belov");
        given.put("482c811da5d5b4bc6d497ffa98491e38", "a.s.ivanov");
        given.put("5f4dcc3b5aa765d61d8327deb882cf99", "k.p.maslov");
        given.put("098f6bcd4621d373cade4e832627b4f6", "t.t.testov");
        Map<String, String> exp = new HashMap<>();
        exp.put("t.t.testov", "test");
        //act
        var act = passwordEncoding(given);

        assertThat(act).isEqualTo(exp);
    }

    @Test
    void passwordEncoding_testWithExecutor() throws NoSuchAlgorithmException {
        //arrange
        Map<String, String> given = new HashMap<>();
        given.put("e10adc3949ba59abbe56e057f20f883e", "a.v.petrov");
        given.put("d8578edf8458ce06fbc5bb76a58c5ca4", "v.v.belov");
        given.put("482c811da5d5b4bc6d497ffa98491e38", "a.s.ivanov");
        given.put("5f4dcc3b5aa765d61d8327deb882cf99", "k.p.maslov");
        given.put("098f6bcd4621d373cade4e832627b4f6", "t.t.testov");
        //act
        var act = passwordEncodingMultithread(given);

        for (var i : act.keySet()) {
            System.out.println(i + " " + act.get(i));
        }
    }

    @Test
    void nextPassword_test(){
        assertThat(nextPassword("aaaa")).isEqualTo("aaab");
        assertThat(nextPassword("aaaz")).isEqualTo("aaa0");
        assertThat(nextPassword("aaa9")).isEqualTo("aaba");
        assertThat(nextPassword("c999")).isEqualTo("daaa");
        assertThat(nextPassword("9999")).isEqualTo("aaaaa");
    }
}

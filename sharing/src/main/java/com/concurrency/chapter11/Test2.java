package main.java.com.concurrency.chapter11;

import main.java.com.concurrency.chapter6.ThreadInterrupt;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/11 0:36
 */
public class Test2 {
    public void test(){
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e->!e.isNativeMethod())
                .forEach(e-> Optional.of(e.getClassName() + ":" + e.getMethodName() + ":" + e.getLineNumber())
                .ifPresent(System.out::println)
                );

    }
}

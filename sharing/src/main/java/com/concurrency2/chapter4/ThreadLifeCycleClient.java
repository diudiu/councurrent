package main.java.com.concurrency2.chapter4;

import java.util.Arrays;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/20 17:50
 */
public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1", "2"));
    }
}

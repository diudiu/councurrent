package main.java.com.concurrency2.chapter7;

import java.util.stream.IntStream;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/21 15:57
 */
public class ImmutableClient {
    public static void main(String[] args) {
        // Share data
        Person person = new Person("Alex", "GanSu");

        IntStream.range(0, 5).forEach(i -> {
            new UserPersonThread(person).start();
        });
    }
}

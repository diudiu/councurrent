package main.java.com.concurrency2.chapter7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/21 16:16
 */
public class ImmutableTest {
    private final int age;
    private final String name;
    private final List<String> list;

    public ImmutableTest(int age, String name) {
        this.age = age;
        this.name = name;
        list = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {  // 确保list不可被改变
        return Collections.unmodifiableList(list);
    }
}

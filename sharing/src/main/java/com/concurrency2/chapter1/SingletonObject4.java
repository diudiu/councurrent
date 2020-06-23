package main.java.com.concurrency2.chapter1;

/**
 * @author : lengxin
 * @description : 使用double check解决， 存在dcl失效问题
 *                1） 严格单例
 *                2） 懒加载
 *                3） 性能问题
 *                但是可能会引起空指针异常
 *                原因：
 *                当JVM堆内存中要创建3个对象的空间
 *                obj1        0x0000002
 *                obj2        0x0000003
 *                instance    0x0000001  // volatile修饰，确保instance在obj1,obj2之后创建
 *                这三个对象的开辟是允许重排序的
 * @date : 2020/6/15 23:09
 */
public class SingletonObject4 {
    private static SingletonObject4 instance;  // 可以用volatile修饰， 防止重排序
    private Object obj1;
    private Object obj2;

    private SingletonObject4() {
        obj1 = new Object();
        obj2 = new Object();
    }

    public static SingletonObject4 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject4.class) {
                if (null == instance) {
                    instance = new SingletonObject4();
                }
            }
        }
        return SingletonObject4.instance;
    }
}

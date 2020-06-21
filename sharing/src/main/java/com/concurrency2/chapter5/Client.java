package main.java.com.concurrency2.chapter5;

/**
 * @author : lengxin
 * @description : 单线程执行模式， 有一个门，最终只能一个人通过
 * @date : 2020/6/20 22:40
 */
public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("BaoBao", "Beijing", gate);
        User sh = new User("ShangLao", "Shanghai", gate);
        User gz = new User("GuangLao", "Guangzhou", gate);
        bj.start();
        sh.start();
        gz.start();
    }
}

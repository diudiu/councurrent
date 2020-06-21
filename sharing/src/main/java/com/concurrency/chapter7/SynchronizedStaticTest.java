package main.java.com.concurrency.chapter7;

/**
 * @author : lengxin
 * @description : 因为m1和m2方法是有class锁的， 所以m1和m2是串行执行的；而m3没有锁，所以m3能立即执行。
 *                这么能验证static方法的锁是class锁呢，SynchronizedStatic在中添加静态代码块用class锁锁住，
 *                发现m3只能在先获得锁的线程的静态代码块执行完成之后执行立即执行
 * @date : 2020/6/7 22:57
 */
public class SynchronizedStaticTest {
    public static void main(String[] args) {
        new Thread("T1"){
            @Override
            public void run() {
                SynchronizedStatic.m1();
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                SynchronizedStatic.m2();
            }
        }.start();

        new Thread("T3"){
            @Override
            public void run() {
                SynchronizedStatic.m3();
            }
        }.start();
    }
}

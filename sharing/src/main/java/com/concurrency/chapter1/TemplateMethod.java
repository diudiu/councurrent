package main.java.com.concurrency.chapter1;

/**
 * @author      : lengxin
 * @description : 当某个算法已经基本定型了， 但是有些具体细节是可变的，可以定义一个模板方法。如Thread的start()和run()。
 *                通常模板方法是final的--不允许修改，wrap方法是abstract的，需要用户自己实现。
 * @date        : 2020/6/3 22:37
 */
public class TemplateMethod {
    public final void print(String message) {
        System.out.println("########################");
        wrapPrint(message);
        System.out.println("########################");
    }

    protected void wrapPrint(String message) {}

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*** " + message + " ***");
            }
        };
        t1.print("hello thread");

        TemplateMethod t2 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+++ " + message + " +++");
            }
        };
        t2.print("hello thread");
    }
}

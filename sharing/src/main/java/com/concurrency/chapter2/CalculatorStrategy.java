package main.java.com.concurrency.chapter2;

/**
 * @author : lengxin
 * @description : 策略类，用于定义所有支持算法的公共接口。Runnable就相当于一个策略类
 * @date : 2020/6/4 23:02
 */

@FunctionalInterface
public interface CalculatorStrategy {
    double calculator(double salary, double bonus);
}


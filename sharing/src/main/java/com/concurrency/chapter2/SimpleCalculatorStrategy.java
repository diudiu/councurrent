package main.java.com.concurrency.chapter2;

/**
 * @author : lengxin
 * @description : 具体策略类，封装了具体的算法或行为，继承于Strategy或实现Strategy接口
 * @date : 2020/6/4 23:06
 */
public class SimpleCalculatorStrategy implements CalculatorStrategy{

    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;

    @Override
    public double calculator(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}

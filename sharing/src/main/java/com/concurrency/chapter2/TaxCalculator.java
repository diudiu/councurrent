package main.java.com.concurrency.chapter2;

/**
 * @author : lengxin
 * @description : 税率计算器的主要功能是计算税率， 但是税率计算公式可能会发生变化。如果把业务逻辑（计算税率的方法）和
 *                业务控制混合到一起，以后修改起来很麻烦。可以使用策略模式将其分离，通过注入不同的策略，灵活应对税率公式的变化。
 *                Thread的runnable模式（创建Thread的第二种方法）就是策略模式的应用。
 *                分离之后TaxCalculator就是策略模式的context， 用一个ConcreteStrategy来配置，维护一个对Strategy对象的引用。
 * @date : 2020/6/4 22:38
 */
public class TaxCalculator {
    private final double salary;
    private final double bonus;
    private CalculatorStrategy calculatorStrategy;

    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }

    protected double calcTax() {
//        return 0.0d;
        return calculatorStrategy.calculator(salary,  bonus);
    }

    public double calculate() {
        return this.calcTax();
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }
}

package main.java.com.concurrency.chapter2;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/4 22:41
 */
public class TaxCalculatorMain {
    public static void main(String[] args){
//        TaxCalculator calculator = new TaxCalculator(10000d, 2000d) {
//            @Override
//            protected double calcTax() {
//                return getSalary() * 0.1 + getBonus() * 0.15;
//            }
//        };
//        double tax = calculator.calculate();
//        System.out.println(tax);

        TaxCalculator calculator2 = new TaxCalculator(10000d, 2000d);
        CalculatorStrategy strategy = new SimpleCalculatorStrategy();
        calculator2.setCalculatorStrategy(strategy);  // 可以灵活的注入不同策略
        System.out.println(calculator2.calculate());
    }
}

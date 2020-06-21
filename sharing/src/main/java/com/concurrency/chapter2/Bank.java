package main.java.com.concurrency.chapter2;

/**
 * @author : lengxin
 * @description : 有3个银行柜台（用3个线程表示）对外办理业务，没个
 * @date : 2020/6/3 23:16
 */
public class Bank {
    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("counter 1");
        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("counter 2");
        ticketWindow2.start();

        TicketWindow ticketWindow3 = new TicketWindow("counter 3");
        ticketWindow3.start();


    }
}

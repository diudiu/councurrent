package main.java.com.concurrency2.chapter5;

import javafx.scene.web.WebHistory;

/**
 * @author : lengxin
 * @description : user相当于使用gate资源， client 创建gate和user
 * @date : 2020/6/20 22:37
 */
public class User extends Thread {
    private final String myName;
    private final String myAddress;
    private final Gate gate;

    public User(String myName, String myAddress, Gate gate) {
        this.myName = myName;
        this.myAddress = myAddress;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(myName + "BEGIN");
        while (true) {
            this.gate.pass(myName, myAddress);
        }
    }
}

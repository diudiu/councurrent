package main.java.com.concurrency2.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lengxin
 * @description : subject是事件源
 * @date : 2020/6/20 16:53
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        if (state == this.state) {
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    private void notifyAllObserver() {
        observers.forEach(Observer::update);
    }
}

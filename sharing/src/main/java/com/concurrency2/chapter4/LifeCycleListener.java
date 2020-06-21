package main.java.com.concurrency2.chapter4;

/**
 * @author : lengxin
 * @description :  listener实际上就是observe
 * @date : 2020/6/20 17:36
 */
public interface LifeCycleListener {
    void OnEvent(ObservableRunnable.RunnableEvent event);
}

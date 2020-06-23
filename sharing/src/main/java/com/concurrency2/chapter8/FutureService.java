package main.java.com.concurrency2.chapter8;

import java.util.function.Consumer;

/**
 * @author : lengxin
 * @description : 通过service将future和future task桥接起来（适配器模式？？？）
 *                future什么都不做，相当于空的实现，等FutureTask任务做完后将结果放到future里来
 *                外部通过future方法获取结果的时候， 再将结果给它
 * @date : 2020/6/21 18:46
 */
public class FutureService {
    public <T> Future<T> submit(final FutureTask<T> task) {
        AsyncFuture<T> asyncFuture = new AsyncFuture<>();
        new Thread(()->{
            T result = task.call();
            asyncFuture.done(result);
        }).start();
        return asyncFuture;
    }

    // 带callback的future， 可以返回future， 也可以什么都不返回
    public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer) {
        AsyncFuture<T> asyncFuture = new AsyncFuture<>();
        new Thread(()->{
            T result = task.call();
            asyncFuture.done(result);
            consumer.accept(result);
        }).start();
        return asyncFuture;
    }
}

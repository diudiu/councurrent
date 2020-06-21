package main.java.com.concurrency2.chapter8;

/**
 * @author : lengxin
 * @description : Future: 代表的是未来的一个凭据
 *                FutureTask： 将你的调用逻辑进行了隔离
 *                FutureService： 桥接Future和FutureTask，Future不需要知道FutureTask, FutureTask也不需要Future
 *
 * @date : 2020/6/21 18:40
 */
public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
//        String result = get();
//        System.out.println(result);
        FutureService futureService = new FutureService();
        Future<String> future = futureService.submit(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        }, System.out::print);

        System.out.println("================");
        System.out.println("do other thing.");
        Thread.sleep(1000);
        System.out.println("================");
        // String result = future.get();
        // System.out.println(result);
    }

    private static String get() throws InterruptedException {
        Thread.sleep(10000);
        return "FINISH";
    }
}

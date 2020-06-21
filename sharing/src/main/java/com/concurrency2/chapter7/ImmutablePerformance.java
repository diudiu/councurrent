package main.java.com.concurrency2.chapter7;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/21 16:18
 */
public class ImmutablePerformance {
    public static void main(String[] args) throws InterruptedException {
        // 15614 32187 sync
        // 16027 31604 immutable
        long startTimestamp = System.currentTimeMillis();
        SyncObj obj = new SyncObj();
        obj.setName("Alex");
//        ImmutableObj obj = new ImmutableObj("Alex");
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for(long l = 0; l < 1000000; l++) {
                    System.out.println(Thread.currentThread().getName() + "=" +obj.toString());
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for(long l = 0; l < 1000000; l++) {
                    System.out.println(Thread.currentThread().getName() + "=" +obj.toString());
                }
            }
        };
        t2.start();

        t1.join();
        t2.join();


        long endTimestamp = System.currentTimeMillis();
        System.out.println("Elapsed time " + (endTimestamp - startTimestamp));
    }
}

final class ImmutableObj {
    private final String name;

    ImmutableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ImmutableObj{" +
                "name='" + name + '\'' +
                '}';
    }
}

class SyncObj {
    private String name;

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        return "SyncObj{" +
                "name='" + name + '\'' +
                '}';
    }
}
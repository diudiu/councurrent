package main.java.com.concurrency2.chapter3;

/**
 * @author : lengxin
 * @description : 如果去掉INIT_VALUE的volatile关键字， READER线程将感知不到INIT_VALUE的变化。
 *                java对线程做了优化， 认为READER线程对INIT_VALUE只有读的操作，而没有写的操作
 *                每次都从cache里拿数据而不会去主内存拿
 *
 *     java memory model（JMM）
 *     **************                            ********************************************
 *     *            *                            *  CPU1                                    *
 *     *            *                            *     ************           **********    *
 *     *            *  --------------------->    *     *          *  ------>  *        *    *
 *     *            *                            *     *  CACHE1  *           *   T1   *    *
 *     *            *  <---------------------    *     *          *  <------  *        *    *
 *     *            *                            *     ************           **********    *
 *     *            *                            *                                          *
 *     *            *                            ********************************************
 *     *  MEMORY    *
 *     *            *                            ********************************************
 *     *            *                            *  CPU2                                    *
 *     *            *                            *     ************           **********    *
 *     *            *  --------------------->    *     *          *  ------>  *        *    *
 *     *            *                            *     *  CACHE2  *           *   T2   *    *
 *     *            *  <---------------------    *     *          *  <------  *        *    *
 *     *            *                            *     ************           **********    *
 *     *            *                            *                                          *
 *     **************                            ********************************************
 *
 *     i = i + 1
 *     main memory -> i -> cache -> i+1 -> cache -> main memory
 *
 *     出现上述问题的原因是缓存不一致
 *     解决办法：
 *         1. 给数据总线加锁（太重， 导致CPU串行化）
 *         2. CPU高速缓存一致性协议
 *     CPU高速缓存一致性协议核心思想：
 *         1. 当CPU写入数据的时候， 如果发现该变量被共享（也就是说，其他CPU中也存在该变量的副本），
 *            会发出一个信号，通知其他CPU该变量的缓存无效。
 *         2. 当其他CPU访问该变量的时候，重新到主内存获取数据
 *
 * @date : 2020/6/16 23:54
 */
public class VolatileTest {
    private volatile static int INIT_VALUE = 0;
    private final static int MAX_LIMIT = 10;

    public static void main(String[] args) {
        new Thread(()->{
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                if (localValue != INIT_VALUE) {
                    System.out.printf("The value updated to [%d]\n", INIT_VALUE);
                    localValue = INIT_VALUE;
                }

            }
        }, "READER").start();

        new Thread(()->{
            int localValue = INIT_VALUE;
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.printf("Update the value to [%d]\n", ++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "UPDATER").start();
    }
}

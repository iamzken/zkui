package com.zhangkenan.zkui.test.redisson;
import org.redisson.Redisson;
import org.redisson.core.RLock;

public class Temp {

    public static void main(String[] args) throws Exception {
        Redisson redisson = Redisson.create();

        RLock lock = redisson.getLock("zhangkenan");
        lock.lock();
        try {
            System.out.println("zhangkenan");
        }
        finally {
            lock.unlock();
        }

        redisson.shutdown();
    }

}
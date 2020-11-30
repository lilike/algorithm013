package com.lilike.daily;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author llk
 * @Date 2020/11/10 17:02
 * @Version 1.0
 */
public class LockDemo {

    public synchronized void method01() {
        System.out.println("method01");
    }

    public synchronized void method02() {
        System.out.println("method02 start");
        this.method01();
        System.out.println("method02 end");
    }

    public static void main(String[] args) {

        LockDemo lockDemo = new LockDemo();
        lockDemo.method02();

        Lock lock = new ReentrantLock(true);
        lock.tryLock();
    }



}

class Account {
    private int balance;
    private final Lock lock
            = new ReentrantLock();
    // 转账
    void transfer(Account tar, int amt){
        while (true) {
            if(this.lock.tryLock()) {
                try {
                    if (tar.lock.tryLock()) {
                        try {
                            this.balance -= amt;
                            tar.balance += amt;
                        } finally {
                            tar.lock.unlock();
                        }
                    }//if
                } finally {
                    this.lock.unlock();
                }
            }//if
        }//while
    }//transfer
}
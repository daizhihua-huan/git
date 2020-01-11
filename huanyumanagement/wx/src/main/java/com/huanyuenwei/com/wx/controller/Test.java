package com.huanyuenwei.com.wx.controller;

import com.huanyuenwei.com.wx.common.MyLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Test {


    private int m=0;
    private ReentrantLock lock=new ReentrantLock(true);
    public int next(){
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(2);
            return m++;
        } catch (InterruptedException e) {
            throw new RuntimeException("ERROR");
        } finally {
            lock.unlock();
        }
    }
    public void a(){
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }
    public void b(){
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }
    public static void main(String[] args) {
        Test demo=new Test();
        Thread[] th=new Thread[20];
        for (int i = 0; i < 20; i++) {
            th[i]=new Thread(()->{
                demo.a();
            });
            th[i].start();
        }
    }

}

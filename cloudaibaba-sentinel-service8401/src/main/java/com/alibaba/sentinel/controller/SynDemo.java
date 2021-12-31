package com.alibaba.sentinel.controller;

import org.openjdk.jol.info.ClassLayout;

/**
 * @auther chenyf
 * @date 2021年12月16日9:09
 */
public class SynDemo {
    public void doSth(){
        synchronized (SynDemo.class){
            System.out.println("test synchronized");
        }
    }

    public static void main(String[] args) {
        SynDemo obj = new SynDemo();

        //查看对象内部信息
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

    }
}

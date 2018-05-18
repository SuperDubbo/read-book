package com.hz.chapter02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * VM Args:-Xmx20M -XX:MaxDirectMemorySize=10M
 * @author HuangZhu
 * @version V1.0
 */
public class DirectMemoryOOM {

    private static final int _1MB=1024*1024;

    public static void main(String[] args) throws IllegalAccessException, InterruptedException {
        Field unsafeField=Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe= (Unsafe) unsafeField.get(null);
        while (true){
            System.out.println("A");
//            Thread.sleep(1);
            unsafe.allocateMemory(_1MB);
        }
    }
}

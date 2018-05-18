package com.hz.chapter02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * VM Args
 * JDK6: -XX:PermSize=10M -XX:MaxPermSize=10M
 * JDK8: 字符串常量池放入堆中，故受到堆的大小限制-Xmx10M同样会触发OOM
 * @author HuangZhu
 * @version V1.0
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true){
            String a=String.valueOf(i++);
            System.out.println(a);
            list.add(a.intern());
        }
    }
}

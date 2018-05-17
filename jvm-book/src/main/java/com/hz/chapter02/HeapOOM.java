package com.hz.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 可以借助Eclipse Memory Analyzer、IBMHeapAnalyzer等工具分析内存溢出原因
 * @author HuangZhu
 * @version V1.0
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}

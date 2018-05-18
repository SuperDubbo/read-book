package com.hz.chapter02;

/**
 * @author HuangZhu
 * @version V1.0
 */
public class RuntimeConstantPoolOOM2 {
    public static void main(String[] args) {
        String str1=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);
        //这个地方说之前已经出现过java，我的猜想是不是java已经存入常量池中过，目前不是很清晰。
        String str2=new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
    }
}

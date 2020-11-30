package com.lilike.daily;

/**
 * @Author llk
 * @Date 2020/11/9 17:11
 * @Version 1.0
 */
public class TestVolatile {


    int x = 0;
     boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        System.out.println(x);
        if (v == true) {
            // 这里x会是多少呢？
            System.out.println(x);
        }
    }

    public static void main(String[] args) {

        TestVolatile testVolatile = new TestVolatile();
        testVolatile.writer();
        testVolatile.reader();


    }

}

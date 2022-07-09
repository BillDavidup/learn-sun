package com.dening.learn.sun.common;

public class Singleton {
    public Singleton() {
    }
    private volatile static Singleton s = null;

    public static Singleton getInstance() {
        if (null == s) {
           synchronized (Singleton.class) {
               if (null == s) {
                  s = new Singleton();
               }
            }
        }
        return s;
    }
}

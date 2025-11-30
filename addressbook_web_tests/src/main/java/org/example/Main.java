package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        var conf = new File("sandbox/build.gradle");
        System.out.println("Hello world!");
        System.out.println(conf.getAbsolutePath());
        System.out.println(new File("").getAbsolutePath());
    }
}
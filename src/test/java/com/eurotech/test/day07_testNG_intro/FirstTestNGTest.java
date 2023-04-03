package com.eurotech.test.day07_testNG_intro;

import org.testng.annotations.Test;

public class FirstTestNGTest {
    //short way =>Win  alt + Insert  Mac=> command + N
    //short way => ctrl+ shift+F => to find annotations

    @Test
    public void test3(){
        System.out.println("My First Test Case");

    }

    @Test
    public void test2(){
        System.out.println("My Second Test Case");
    }

    @Test
    public void test1(){
        System.out.println("My Third Test Case");
    }


}

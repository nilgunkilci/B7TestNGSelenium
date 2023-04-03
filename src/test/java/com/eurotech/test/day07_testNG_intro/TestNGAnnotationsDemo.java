package com.eurotech.test.day07_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {
    @BeforeMethod
    public void setUp() {
        System.out.println("Open Browser");
    }

    @Test
    public void test1() {

        System.out.println("First Assertion");

        Assert.assertEquals("title", "title"); // true = true => Pass

        System.out.println("Second Assertion");

        Assert.assertEquals("url", "url", "verify that url are equals");


    }

    @Test
    public void test2() {
        System.out.println("Test 2 Assertion");
        Assert.assertEquals("test2", "test2");
    }

    @Test
    public void test3() {
        String expectedTitle = "Dev";
        String actualTitle = "DevEx";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verify that title starting with Dev ");

    }

    @Test
    public void test4() {
        //verify that email contains @ sign
        String email = "teacher@eurotech.com";

//        if (email.contains("@")){
//            System.out.println("PASSED");
//        }else{
//            System.out.println("FAILED");
//        }
        Assert.assertTrue(email.contains("@")); //expected=> True

    }

    @Test
    public void test5() {
        Assert.assertFalse(0 > 1, "Verify that 0 is NOT greater than 1 "); //expected=> False
    }

    @Test
    public void test6() {
        Assert.assertNotEquals("two", "one");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }
}

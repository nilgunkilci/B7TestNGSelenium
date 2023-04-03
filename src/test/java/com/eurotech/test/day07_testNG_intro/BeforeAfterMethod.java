package com.eurotech.test.day07_testNG_intro;

import org.testng.annotations.*;

public class BeforeAfterMethod {
    @BeforeClass
    public void setUpClass() {
        System.out.println("------------- Before Class ----------");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("**************** Before Method ************");
        System.out.println("WebDriver,Opening Browser");
    }

    @Test
    @Ignore
    public void test1() {
        System.out.println("First Test Case");
    }

    @Test
    public void test2() {
        System.out.println("Second Test Case");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("*********** After Metod ***********");
        System.out.println("Closing Browser, quit");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("--------------After Class ------------");
    }

}

package com.eurotech.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.module.Configuration;
import java.util.concurrent.TimeUnit;

public class TestBase {

    // bunlarin protected olma sebebi sadece ayni package icinde cagirmak icin. public olursa tüm proje icinden cagrilir.
   protected  WebDriver driver;
   protected Actions actions;
   protected WebDriverWait wait;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;
    @BeforeTest
    public void setUpTest(){
        //initialize the class
        report=new ExtentReports();
        //project path
        String projectPath=System.getProperty("user.dir");
        //String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //path for report
        String path= projectPath + "/test-output/report.html";
        // String path= projectPath + "/test-output/report"+date+".html";

        //initialize the html report with the report path
        htmlReporter=new ExtentHtmlReporter(path);
        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        // title in report
        htmlReporter.config().setReportName("Eurotech smoke test");
        report.setSystemInfo("Environment","Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Fatih T");

    }
    @AfterTest
    public void tearDownTest(){
        report.flush();
    }

    @BeforeMethod
    public void setUp() {
        driver= Driver.get();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        actions= new Actions(driver);
        wait= new WebDriverWait(Driver.get(),15);


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}

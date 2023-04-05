package com.eurotech.test.day18_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportsDemo {

    // NOT: TestBase classini extends yapmiyoruz. cünkü buradaki before ve after lari daha sonra testBase clasa kpyalayacagiz.

    // classi baslatip insa edecek(This class is used for starting and building report;)
    ExtentReports report;


    // Html report olusturacak(This class is used to create HTML report file)
    ExtentHtmlReporter htmlReporter ;

    //Test step bilgilerini giriyoruz . (This will define a test, enable adding logs, authors and test steps)
    ExtentTest extentLoger;


    @BeforeMethod
    public void setUp(){
        // initialize the class (classi yukarida declare ettik,burada initialized ediyoruz)
        report= new ExtentReports();

        //  project path. ( projenin path adresi alinir)
        String projectPath = System.getProperty("user.dir");

        //path for report. ( rapor dosyasi icin path olusturulur. bu dosya html dosyasi olarak olusturulur.)
        String path = projectPath+"/test-output/report.html";

        // Yukarida olusturular pathi htmlreporta dönüstürmek icin object olusturulur..( //initialize the html report with the report path)
        htmlReporter = new ExtentHtmlReporter(path);

        // report objesi, html rapora dönüstürülür.( //attach the html report to the report object)html dosyasi rapora tutturulur
        report.attachReporter(htmlReporter);

        // raporun ismi yazilir.(title in report)
        htmlReporter.config().setReportName("Eurotech smoke test");

        // rapor icin bilgileri giriyoruz.
        report.setSystemInfo("Environment","Production");
        // report.setSystemInfo("Browser","chrome"); // bu sekilde olabilir fakat dinamik olmasi icin asagidaki gibi yaziyoruz
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name")); //sistem adini girmek icin
        report.setSystemInfo("Test Engineer","Nilgün K.");  // testi yapan kisinin adini giriyoruz


    }
    @Test
    public void test1(){
        //give a name to the current test.(testcase adini gir)
        extentLoger = report.createTest("TC001 Login Test");

        //Test Steps
        extentLoger.info(("open the browser"));
        extentLoger.info("go to url http://eurotech.study/login");
        extentLoger.info("login as a Teacher");
        extentLoger.info("enter Teacher userEmail");
        extentLoger.info("enter Teacher password");
        extentLoger.info("click login button");
        extentLoger.info("verify logged in");
        extentLoger.info("TC001 LoginTest is passed");

    }
    @AfterMethod
    public void tearDown(){
        report.flush(); // Browser kapatmak icin
    }




}

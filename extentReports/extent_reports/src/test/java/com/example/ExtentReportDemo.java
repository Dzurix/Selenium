package com.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

  //Kreiranje GLAVNE KLASE =>  EXTENT REPORTS

  ExtentReports extent; //ubacujem varijablu ovde, da bih je mogao svuda koristiti
  WebDriver driver;

  @BeforeTest
  public void config() {
    //DVE KLASE KOJE MORAM IMATI
    //  ExtentReports, ExtentSparkReporter

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    //kreiranje fajla dinamicki, u koji cemo stavljati ExtentReport
    String path = System.getProperty("user.dir") + ("//reports//index.html");

    // kreiranje objekta 'reporter' koji ustvari predstvlja konfigururisanje samo izvestaja (izgled, tabovi,...)
    ExtentSparkReporter reporter = new ExtentSparkReporter(path);

    reporter.config().setReportName("Web Automatisaion by DEXTER");
    reporter.config().setDocumentTitle("ovo je naslov");

    extent = new ExtentReports();
    extent.attachReporter(reporter); //ubacivanje ExtentSparkReportera objekta
    extent.setSystemInfo("Tester", "DeXtER");
  }

  @Test
  public void initialDemo() {
    ExtentTest test = extent.createTest("initialDemo"); //EVO GA => ovako pozivam EXTENT REPORT i dajem ime testu

    driver.get("https://rahulshettyacademy.com");
    System.out.println(driver.getTitle());

    test.fail("Namerno sam oborio test");

    //na kraju testa ovo ubacujemo
    extent.flush();
  }
}

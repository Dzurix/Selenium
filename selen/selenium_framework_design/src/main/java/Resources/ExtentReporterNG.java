package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

  public static ExtentReports getReportObject() {
    String path = System.getProperty("user.dir") + ("//reports//index.html");

    // kreiranje objekta 'reporter' koji ustvari predstvlja konfigururisanje samo izvestaja (izgled, tabovi,...)
    ExtentSparkReporter reporter = new ExtentSparkReporter(path);

    reporter.config().setReportName("Web Automatisaion by DEXTER");
    reporter.config().setDocumentTitle("ovo je naslov");

    ExtentReports extent = new ExtentReports();
    extent.attachReporter(reporter); //ubacivanje ExtentSparkReportera objekta
    extent.setSystemInfo("Tester", "DeXtER");

    return extent;
  }
}

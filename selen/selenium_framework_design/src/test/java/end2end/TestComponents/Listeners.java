package end2end.TestComponents;

import Resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseTest implements ITestListener {

  ExtentTest test;
  ExtentReports extent = ExtentReporterNG.getReportObject();
  ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe

  @Override
  public void onTestStart(ITestResult result) {
    test = extent.createTest(result.getMethod().getMethodName()); // dinamicki dajem ime testu
    extentTest.set(test); // unique thread id of ErrorValidation Test
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    extentTest.get().log(Status.PASS, "Test je prosao");
  }

  @Override
  public void onTestFailure(ITestResult result) {
    extentTest.get().fail(result.getThrowable());

    // specificno odredjujemo koji tacno se driver koristi u odredjenom test case
    try {
      driver =
        (WebDriver) result
          .getTestClass()
          .getRealClass()
          .getField("driver")
          .get(result.getInstance());
    } catch (Exception e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    String filePath = null;

    //Screenshoot,

    try {
      filePath = getScreenShoot(result.getMethod().getMethodName(), driver); // ovo je taj specificni driver
    } catch (IOException e) {
      e.printStackTrace();
    }
    //Attach screeenshot to report
    extentTest
      .get()
      .addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
  }

  @Override
  public void onTestSkipped(ITestResult result) {}

  @Override
  public void onStart(ITestContext context) {}

  @Override
  public void onFinish(ITestContext context) {
    extent.flush();
  }
}

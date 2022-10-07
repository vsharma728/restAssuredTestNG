package modules;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonUtilities.webUtilities.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class ReportBuilder {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    protected WebDriver objWebDriver;

    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.getInstance();
    }

    @BeforeClass
    public void beforeClass() {
        ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        ExtentTest child = parentTest.get().createNode(method.getName());
        test.set(child);
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.get().log(Status.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.get().log(Status.SKIP, result.getThrowable());
        } else {
            test.get().log(Status.PASS, result.getThrowable());
        }
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        extent.flush();
        //Desktop.getDesktop().browse(new File("src/resources/extentReports/extent_TestReport.html").toURI());
    }
}
package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utils.ExtentManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private ExtentReports extent =
            ExtentManager.getInstance();

    private ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(
                result.getMethod().getMethodName()
        );

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        Object testClass =
                result.getInstance();

        if (testClass instanceof BaseTest) {

            BaseTest baseTest = (BaseTest) testClass;

            if (baseTest.getDriver() != null) {

                String screenshotPath =
                        ScreenshotUtils.captureScreenshot(
                                baseTest.getDriver(),
                                result.getMethod().getMethodName()
                        );

                test.get().addScreenCaptureFromPath(
                        screenshotPath
                );
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test was skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
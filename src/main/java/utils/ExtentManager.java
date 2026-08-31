package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportPath =
                    System.getProperty("user.dir")
                    + File.separator
                    + "reports"
                    + File.separator
                    + "ExtentReport.html";

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(reportPath);

            reporter.config().setDocumentTitle(
                    "Selenium Automation Report"
            );

            reporter.config().setReportName(
                    "SauceDemo Test Results"
            );

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Tester", "Satish");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Environment", "Demo");
        }

        return extent;
    }
}
package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public static WebDriver driver;
    public static ExtentReports report;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest extentTest;


    @BeforeSuite
    public void beforeSuite(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");
        initReport();
    }

    public void initReport(){
        htmlReporter = new ExtentHtmlReporter("src/test/java/reports/TestReport.Html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
        report.setSystemInfo("Tester Name","Naveen");
        report.setSystemInfo("Application Name","Zero Bank");
        report.setSystemInfo("OS","Win 10");

        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setReportName("Zero Bank Testing");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" - Failed", ExtentColor.RED));
        }
        else{
            extentTest.log(Status.PASS,MarkupHelper.createLabel(result.getName()+" - Passed",ExtentColor.GREEN));
        }
    }

    @AfterSuite
    public void afterSuite(){
        report.flush();
        //driver.quit();
    }
}

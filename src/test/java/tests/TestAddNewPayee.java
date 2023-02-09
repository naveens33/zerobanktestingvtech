package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountSummaryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PayBillsPage;
import testdata.ReadExcelData;

import java.io.IOException;

public class TestAddNewPayee extends BaseTest {


    @BeforeClass
    public void beforeClass(){
        HomePage homepage = new HomePage(driver);
        homepage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("username","password");
        driver.get("http://zero.webappsecurity.com/bank/account-summary.html");
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage(driver);
        accountSummaryPage.clickPayBillsLink();
    }

    @BeforeMethod
    public void beforeMethod(){
        PayBillsPage payBillsPage = new PayBillsPage(driver);
        payBillsPage.clickAddNewPayeeLink();
    }

    @Test(dataProvider = "dataProvider1")
    public void testAddNewPayee(String name, String address, String account, String details){
        extentTest = report.createTest("Add New Payee for test data "+name);
        extentTest.log(Status.INFO,"Test Data are: "+name+" "+address+" "+account+" "+details);
        PayBillsPage payBillsPage = new PayBillsPage(driver);
        payBillsPage.doAddPayee(name, address, account, details);
    }

    @DataProvider(name = "dataProvider1")
    public Object[][] dataProvider() throws IOException {
        ReadExcelData data = new ReadExcelData();
        return data.getData();
    }
}

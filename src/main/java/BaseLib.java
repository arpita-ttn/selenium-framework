import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.List;

public class BaseLib extends ExcelUtility{
    static WebDriver driver;
    static List<String> datalist;
    static ExtentReports extentReports;
    static ExtentTest extentTest;
    @BeforeSuite
    void setUp(){
        extentReports=new ExtentReports();
        ExtentSparkReporter report=new ExtentSparkReporter("ExtentReports/report.html");
        extentReports.attachReporter(report);
    }
    @Parameters("browser")
    @BeforeTest
    void launch(String browser) throws IOException {
        driver = BrowserFactory.getBrowser(browser);
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        datalist=ExcelUtility.excelUtil();
    }
    @AfterTest
    void close() throws IOException {
        fis.close();
        driver.quit();
    }
    @AfterTest
    void closeSetUp(){
        extentReports.flush();
    }
}

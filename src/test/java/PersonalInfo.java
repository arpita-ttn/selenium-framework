import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalInfo extends BaseLib{
    @Test
    void enterName(){
        extentTest=extentReports.createTest("Enter Name Test");
        WebElement firstname=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstname.sendKeys(datalist.get(0));
        WebElement lastname=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastname.sendKeys(datalist.get(1));
        System.out.println(lastname.getText());
        Assert.assertEquals(driver.getTitle(), "Register");
        extentTest.log(Status.PASS, "Test passed.");
    }
    @Test
    void enterAddress(){
        extentTest=extentReports.createTest("Enter Address Test");
        WebElement address=driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
        address.sendKeys(datalist.get(2));
        Assert.assertEquals(driver.getTitle(), "Register");
        extentTest.log(Status.PASS, "Test passed.");
    }
    @Test
    void enterEmail(){
        extentTest=extentReports.createTest("Enter Email Test");
        WebElement email=driver.findElement(By.xpath("//input[@ng-model='EmailAdress']"));
        email.sendKeys(datalist.get(3));
        Assert.assertEquals(driver.getTitle(), "Register");
        extentTest.log(Status.PASS, "Test passed.");
    }
    @Test
    void enterPhoneNumber(){
        extentTest=extentReports.createTest("Enter Phone Number Test");
        WebElement phone=driver.findElement(By.xpath("//input[@ng-model='Phone']"));
        phone.sendKeys(datalist.get(4));
        Assert.assertEquals(driver.getTitle(), "Register");
        extentTest.log(Status.PASS, "Test passed.");
    }
    @Test
    void selectGender(){
        extentTest=extentReports.createTest("Select Gender Test");
        WebElement gender=driver.findElement(By.xpath("//input[@value='"+datalist.get(5)+"']"));
        gender.click();
        Assert.assertTrue(gender.isSelected());
        extentTest.log(Status.PASS, "Test passed.");
    }
}

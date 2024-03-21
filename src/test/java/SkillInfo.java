import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SkillInfo extends BaseLib{
    @Test
    void selectHobby(){
        extentTest=extentReports.createTest("Select Hobby Test");
        WebElement hobby=driver.findElement(By.xpath("//input[@value='"+datalist.get(6)+"']"));
        hobby.click();
        Assert.assertTrue(hobby.isSelected());
        extentTest.log(Status.PASS, "Test passed.");
    }
    @Test
    void selectLanguage(){
        extentTest=extentReports.createTest("Select Language Test");
        WebElement languages=driver.findElement(By.xpath("//div[@id='msdd']"));
        languages.click();
        WebElement language=driver.findElement(By.xpath("//a[text()='"+datalist.get(7)+"']"));
        language.click();
        Assert.assertEquals(driver.getTitle(), "Register");
        WebElement whitespace=driver.findElement(By.xpath("//label[text()='Languages']"));
        whitespace.click();
        extentTest.log(Status.PASS, "Test passed.");
    }
    @Test
    void selectSkill(){
        extentTest=extentReports.createTest("Select Skill Test");
        Select dropskills=new Select(driver.findElement(By.id("Skills")));
        dropskills.selectByValue(datalist.get(8));
        extentTest.log(Status.PASS, "Test passed.");
    }
    @Test
    void selectCountry(){
        extentTest=extentReports.createTest("Select Country Test");
        WebElement countrydropdown=driver.findElement(By.xpath("//span[@aria-labelledby='select2-country-container']"));
        countrydropdown.click();
        WebElement country=driver.findElement(By.xpath("//li[text()='"+datalist.get(9)+"']"));
        country.click();
        Assert.assertEquals(driver.getTitle(), "Register");
        extentTest.log(Status.PASS, "Test passed.");
    }
    @Test
    void selectDOB(){
        extentTest=extentReports.createTest("Select Date of Birth Test");
        Select dropyear=new Select(driver.findElement(By.id("yearbox")));
        dropyear.selectByValue(datalist.get(10));
        Select dropmonth=new Select(driver.findElement(By.xpath("//select[@ng-model='monthbox']")));
        dropmonth.selectByValue(datalist.get(11));
        Select dropday=new Select(driver.findElement(By.id("daybox")));
        dropday.selectByValue(datalist.get(12));
        Assert.assertTrue(driver.findElement(By.xpath("//option[@value='"+datalist.get(10)+"']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[@value='"+datalist.get(11)+"']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[@value='"+datalist.get(12)+"']")).isSelected());
        extentTest.log(Status.PASS, "Test passed.");
    }
    @Test
    void enterPassword(){
        extentTest=extentReports.createTest("Enter Password Test");
        WebElement password1=driver.findElement(By.xpath("//input[@id='firstpassword']"));
        password1.sendKeys(datalist.get(13));
        WebElement password2=driver.findElement(By.xpath("//input[@id='secondpassword']"));
        password2.sendKeys(datalist.get(14));
        Assert.assertEquals(datalist.get(13), datalist.get(14));
        extentTest.log(Status.PASS, "Test passed.");
    }
}

package practiceTestAutomation.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Open page
//Type username student into Username field
//Type password Password123 into Password field
//Push Submit button
//Verify new page URL contains practicetestautomation.com/logged-in-successfully/
//Verify new page contains expected text ('Congratulations' or 'successfully logged in')
//Verify button Log out is displayed on the new page

public class PositiveLoginTests {
    WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test(priority = 1)
    public void verifyLogIn()
    {
        WebElement usern = driver.findElement(By.xpath("//input[@id='username']"));
        usern.sendKeys("student");

        WebElement passw = driver.findElement(By.xpath("//input[@id='password']"));
        passw.sendKeys("Password123");
        WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));
        submitBtn.click();

        String expected = "practicetestautomation.com/logged-in-successfully/";
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));

        String text = "Logged In Successfully";

        String logInMsg = driver.findElement(By.xpath("//h1[contains(text(),'"+ text +"')]")).getText();
        Assert.assertTrue(logInMsg.contains(text));

        WebElement logOutBtn = driver.findElement(By.linkText("Log out"));
        boolean a =  logOutBtn.isDisplayed();
        if(a)
        {
            System.out.println("logOut btn is being displayed.");
        }
    }
}

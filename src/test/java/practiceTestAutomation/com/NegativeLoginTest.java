package practiceTestAutomation.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NegativeLoginTest
{
    WebDriver driver = new ChromeDriver();
        @BeforeClass
        public void setUp()
        {
            driver.get("https://practicetestautomation.com/practice-test-login/");
        }

        @Test(priority = 1)
        public void wrongUserName()
        {
            WebElement userName = driver.findElement(By.id("username"));
            userName.sendKeys("incorrectUser");

            WebElement psw = driver.findElement(By.id("password"));
            psw.sendKeys("Password123");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            submitBtn.click();

            WebElement errorUsername = driver.findElement(By.id("error"));
            if(errorUsername.isDisplayed())
            {
                System.out.println("error message is displayed.");
            }
            if(errorUsername.getText().equals("Your username is invalid!")) {
                System.out.println("error msg for the username.");
            }
        }

        @Test(priority = 2)
        public void wrongPsw()
        {
            WebElement userName = driver.findElement(By.id("username"));
            userName.sendKeys("student");

            WebElement psw = driver.findElement(By.id("password"));
            psw.sendKeys("incorrectPassword");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            submitBtn.click();

            WebElement errorUsername = driver.findElement(By.id("error"));
            if(errorUsername.isDisplayed())
            {
                System.out.println("error message for test2 is displayed.");
            }

            if(errorUsername.getText().equals("Your password is invalid!")) {
                System.out.println("error msg for the password.");
            }
        }
}

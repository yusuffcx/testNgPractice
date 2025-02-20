package practiceTestAutomation.com;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ChallengeTest {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp()
    {
        driver.get("http://cloud.google.com/?hl=tr");
    }

    @Test(priority = 1)
    public void searchField()
    {
        driver.manage().window().maximize();

        WebElement clickToSearch = driver.findElement(By.className("YSM5S"));
        clickToSearch.click();

        WebElement inputField = driver.findElement(By.id("i3"));
        inputField.sendKeys("Google Cloud Platform Pricing Calculator");
        inputField.sendKeys(Keys.ENTER);

        /*
        WebElement searchBtn = driver.findElement(By.className("PETVs-OWXEXe-UbuQg"));
        searchBtn.click();
        */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Google Cloud Pricing Calculator")));

        WebElement pricingPage = driver.findElement(By.partialLinkText("Google Cloud Pricing Calculator"));
        pricingPage.click();

        WebElement addEstimateBtn = driver.findElement(By.className("UywwFc-vQzf8d"));
        addEstimateBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='d5NbRd-EScbFb-JIbuQc PtwYlf']")));

        WebElement computeEngine = driver.findElement(By.xpath("//div[@class='d5NbRd-EScbFb-JIbuQc PtwYlf']"));
        computeEngine.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(text(),'add')]")));

        /*
        WebElement addInstances = driver.findElement(By.xpath("//i[contains(text(),'add')]"));
        for (int i=0;i<4;i++)
        {
            addInstances.click();
        }*/

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Increment']")));
        WebElement addInstances = driver.findElement(By.xpath("//button[@aria-label='Increment']"));
        for (int i=0;i<3;i++)
        {
            addInstances.click();
        }

//<span class="S8daBe-uusGie-fmcmS" jsname="Fb0Bif">N1</span>
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,420)", "");
        WebElement textBelowOsPanel = driver.findElement(By.xpath("//div[@class='xl1FBb']"));

        WebElement openOsChoosePanel = driver.findElement(RelativeLocator.with(By.xpath("//div[@class='S8daBe-aPP78e']")).below(textBelowOsPanel));
        openOsChoosePanel.click();
        WebElement freeOS = driver.findElement(By.xpath("//li[@data-value='free-debian-centos-coreos-ubuntu-or-byol-bring-your-own-license']"));
        freeOS.click();

        WebElement vmLabel = driver.findElement(By.id("ucc-26"));
        WebElement vmClass = driver.findElement(RelativeLocator.with(By.xpath("//label[@for='107regular']")).below(vmLabel));
        vmClass.click();

        js.executeScript("window.scrollBy(0,200)", "");


        WebElement seriesLabel = driver.findElement(By.xpath("//span[text()='N1']"));

        WebElement seriesClass = driver.findElement(RelativeLocator.with(By.xpath("//div[@class='S8daBe-aPP78e']")).below(seriesLabel));
        seriesClass.click();

        WebElement chooseSeries = driver.findElement(By.xpath("//li[@data-value='n1-standard-8']"));
        chooseSeries.click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        js.executeScript("window.scrollBy(0,900)", "");

        WebElement addGpusBtn = driver.findElement(By.xpath("//button[@aria-label='Add GPUs']"));
        addGpusBtn.click();


        js.executeScript("window.scrollBy(0,300)", "");


        WebElement gpuText = driver.findElement(By.xpath("//span[text()='GPUs are only available for N1, G2, and A2 machine series']"));


        WebElement gpuModel = driver.findElement((By.xpath("//span[text()='GPU Model']/following-sibling::div")));
        gpuModel.click();

        WebElement chooseGpu = driver.findElement(By.xpath("//li[@data-value='nvidia-tesla-p100']"));
        chooseGpu.click();

        js.executeScript("window.scrollBy(0,300)", "");

        WebElement SSD = driver.findElement((By.xpath("//span[text()='Local SSD']/following-sibling::div")));
        SSD.click();

        WebElement chooseSSD = driver.findElement(By.xpath("//span[text()='2x375 GB']/ancestor::li"));
        chooseSSD.click();

        WebElement region = driver.findElement(By.xpath("//span[text()='Region']/following-sibling::div"));
        region.click();
        WebElement chooseRegion = driver.findElement(By.xpath("//li[@data-value='europe-west4']"));
        chooseRegion.click();

        WebElement useYear = driver.findElement(By.xpath("//label[@for='1161-year']"));
        useYear.click();

     /*   WebElement addToEstimateBtn = driver.findElement(By.xpath("//button[@data-idom-class='VVEJ3d']"));
        addToEstimateBtn.click();*/
    }

    @Test(priority = 2)
    public void confirm() {
        WebElement options = driver.findElement(By.xpath("//button[@data-idom-class='yY29zb']"));
        options.click();

        WebElement viewDetails = driver.findElement(By.xpath("//li[@jsname='EHme7e']"));
        viewDetails.click();

        //WebElement vmClassNear = driver.findElement(By.xpath("//div[text()='Provisioning Model']/parent::div//div[contains(text(),'Regular')]"));
        WebElement vmClassNear = driver.findElement(By.xpath("//div[text()='Provisioning Model']/parent::div//div[contains(@class,'EWphe HY0Uh')]"));


        String vmClass = vmClassNear.getText();
        System.out.println(vmClass);
        assertEquals(vmClass,"Regular");
        options.click();
        viewDetails.click();

/*
        WebElement regionNear = driver.findElement(By.xpath("//div[text()='Region']/parent::div//div[contains(@class,'EWphe HY0Uh')]"));
        String region = regionNear.getText();
        System.out.println(region);
        assertEquals(region,"Netherlands (europe-west4)");
*/
        WebElement ssdNear = driver.findElement(By.xpath("//div[text()='Local SSD']/parent::div//div[contains(@class,'EWphe HY0Uh')]"));
        String ssd = ssdNear.getText();
        System.out.println(ssd);
        assertEquals(ssd,"2x375 GB");
        /*options.click();
        viewDetails.click();*/

        WebElement yearNear = driver.findElement(By.xpath("//div[text()='Committed use discount options']/parent::div//div[contains(@class,'EWphe HY0Uh')]"));
        String year = yearNear.getText();
        System.out.println(year);
        assertEquals(year,"1 year");

        String rentPrice = driver.findElement(By.xpath("//label[contains(@class,'D0aEmf')]")).getText();
        assertEquals(rentPrice,"$3,883.62");

    }
}

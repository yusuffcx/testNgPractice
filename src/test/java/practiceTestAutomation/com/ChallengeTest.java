package practiceTestAutomation.com;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ChallengeTest {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp()
    {
        driver.get("http://cloud.google.com/?hl=tr");
    }

    @Test(priority = 1)
    public void searchField() throws InterruptedException {
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


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Increment']")));
        WebElement addInstances = driver.findElement(By.xpath("//button[@aria-label='Increment']"));
        for (int i=0;i<3;i++)
        {
            addInstances.click();
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,420)", "");
        WebElement textAboveOsPanel = driver.findElement(By.xpath("//div[@class='xl1FBb']"));
        System.out.println("Element with text(): " + textAboveOsPanel.getText() );
       // WebElement e = driver.findElement(By.xpath("//*[text()='Operating System / Software']"));

        WebElement openOsChoosePanel = driver.findElement(RelativeLocator.with(By.xpath("//div[@class='rHGeGc-aPP78e']")).below(textAboveOsPanel));
        openOsChoosePanel.click();
        WebElement freeOS = driver.findElement(By.xpath("//li[@data-value='free-debian-centos-coreos-ubuntu-or-byol-bring-your-own-license']"));
        freeOS.click();

        js.executeScript("window.scrollBy(0,350)", "");


        WebElement vmLabel = driver.findElement(By.id("ucc-26"));
        System.out.println("vmLabel" + vmLabel.getText());
        WebElement vmClass = driver.findElement(RelativeLocator.with(By.xpath("//label[@for='107regular']")).below(vmLabel));
        vmClass.click();

        js.executeScript("window.scrollBy(0,100)", "");

        WebElement seriesLabel = driver.findElement(By.id("ucc-40"));
        System.out.println("sdaas sd" + seriesLabel.getText());

        Thread.sleep(1000);

        WebElement seriesClass = driver.findElement(By.xpath("//*[text()='Machine Family']"));

        WebElement seriesClassClick = driver.findElement(RelativeLocator.with(By.xpath("//div[@class='rHGeGc-aPP78e']")).below(seriesClass));
        seriesClassClick.click();

        WebElement chooseSeries = driver.findElement(By.xpath("//li[@data-value='n1']"));
        chooseSeries.click();

        Thread.sleep(2000);

        WebElement machineTypeClass = driver.findElement(By.xpath("//*[text()='Series']"));

        WebElement chooseMachineTypeClick = driver.findElement(RelativeLocator.with(By.xpath("//div[@class='rHGeGc-aPP78e']")).below(machineTypeClass));
        chooseMachineTypeClick.click();

        WebElement chooseMachineType = driver.findElement(By.xpath("//li[@data-value='n1-standard-8']"));
        chooseMachineType.click();

        Thread.sleep(1500);
        js.executeScript("window.scrollBy(0,900)", "");

        WebElement addGpusBtn = driver.findElement(By.xpath("//button[@aria-label='Add GPUs']"));
        addGpusBtn.click();

        js.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(3000);

        WebElement gpuText = driver.findElement(By.xpath("//span[text()='GPUs are only available for N1, G2, and A2 machine series']"));

        WebElement gpuModelClick = driver.findElement(RelativeLocator.with(By.xpath("//div[@class='rHGeGc-aPP78e']")).below(gpuText));
        gpuModelClick.click();

        WebElement chooseGpuModel = driver.findElement(By.xpath("//li[@data-value='nvidia-tesla-p100']"));
        chooseGpuModel.click();

        js.executeScript("window.scrollBy(0,150)", "");

        WebElement SSD = driver.findElement((By.xpath("//span[text()='Local SSD']/following-sibling::div")));
        SSD.click();

        WebElement chooseSSD = driver.findElement(By.xpath("//span[text()='2x375 GB']/ancestor::li"));
        chooseSSD.click();

        js.executeScript("window.scrollBy(0,100)", "");


        WebElement region = driver.findElement(By.xpath("//span[text()='Region']/following-sibling::div"));
        region.click();

        Thread.sleep(1000);


        WebElement chooseRegion = driver.findElement(By.xpath("//li[@data-value='europe-west4']"));
        chooseRegion.click();


        WebElement usageYearText = driver.findElement(By.xpath("//p[text()='Regional availability depends on the machine type and GPU selected.']"));

        WebElement useYearClick = driver.findElement(RelativeLocator.with(By.xpath("//div[@class='rHGeGc-aPP78e']")).below(usageYearText));
        useYearClick.click();

        WebElement useYear = driver.findElement(By.xpath("//li[@data-value='1-year']"));
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

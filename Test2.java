package dev.selenium.drivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Set;
import java.io.File;


public class Test2 {
    public static void main(String[]
                                    args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rafus\\Downloads\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://xtm.cloud/");
        Thread.sleep(3000);
        WebElement acceptAllCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptAllCookiesButton.click();

        WebElement menuResources = driver.findElement(By.xpath("//span[@class='menu-title' and text()='Resources']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuResources).perform();
        Thread.sleep(3000);
        WebElement doc = driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/nav/ul/li[3]/div/ul/li[2]/div/ul/li[3]/a/div/span/span[1]"));
        doc.click();
        Thread.sleep(3000);

        String mainWindowHandle = driver.getWindowHandle();
        WebElement cloud = driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/ul/li[1]/a"));
        cloud.click();
        Set<String> handles = driver.getWindowHandles();
        for(String windowHandle : handles) {
            if (!mainWindowHandle.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement version = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("XTM Cloud documentation version 13.7")));
        version.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = (String) js.executeScript("return document.title;");
        System.out.println("Tytuł aktywnego okna: " + title);

        Set<String> handless = driver.getWindowHandles();
        for (String windowHandle : handless) {
            if (!mainWindowHandle.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        String title2 = (String) js2.executeScript("return document.title;");
        System.out.println("Tytuł aktywnego okna: " + title2);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement linkToAdditionalInfo = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[normalize-space()='Additional Information']")));
        linkToAdditionalInfo.click();

        WebElement wordslink = driver.findElement(By.xpath("//a[@href='stop-words.html']"));
        wordslink.click();
        Thread.sleep(5000);

        WebElement downloadLink = driver.findElement(By.xpath("//*[@id=\"UUID-03f00f1b-e88a-abad-ca2a-bebff55e0cfd\"]/div[2]/ul/li[44]/p/a"));
        downloadLink.click();
        try {
            Thread.sleep(5000); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File downloadedFile = new File("C:\\Users\\rafus\\Downloads\\sk.txt");
        if (downloadedFile.exists()) {
            System.out.println("Plik został pobrany pomyślnie.");
        } else {
            System.out.println("Plik nie został znaleziony.");
        }

    }
}
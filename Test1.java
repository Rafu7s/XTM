package dev.selenium.drivers;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeOptions;


public class Test1 {
    public static void main(String[]
  args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rafus\\Downloads\\chromedriver-win64\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //ChromeOptions chromeOptions = new ChromeOptions();
        //String name = chromeOptions.getBrowserName();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        WebDriver driver = new ChromeDriver(options);

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://xtm.cloud/");
        WebElement buyXTMCloudLink = driver.findElement(By.linkText("Buy XTM Cloud"));
        buyXTMCloudLink.click();

        try {
            Thread.sleep(3000); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        driver.quit();
        }
    }
}

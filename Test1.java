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
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;
import java.text.ParseException;


public class Test1 {
    public static void main(String[]
  args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rafus\\Downloads\\chromedriver-win64\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //ChromeOptions chromeOptions = new ChromeOptions();
        //String name = chromeOptions.getBrowserName();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://xtm.cloud/");

        WebElement buyXTMCloudLink = driver.findElement(By.linkText("Buy XTM Cloud"));
        buyXTMCloudLink.click();
        WebElement acceptAllCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptAllCookiesButton.click();
        Thread.sleep(3000);
        WebElement iframe = driver.findElement(By.cssSelector("iframe[src='https://login.xtm.cloud/saas-manager/buy.jsp']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);

        WebElement Account = driver.findElement(By.xpath("//*[@id=\"new-xtm-subscription-form\"]/div/div[2]/fieldset[1]/div/div[1]/div[1]/div/span[1]/span[1]/span/span[2]"));
        Account.click();
        WebElement AccountType = driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[2]"));
        AccountType.click();

        WebElement Users = driver.findElement(By.xpath("//*[@id=\"new-xtm-subscription-form\"]/div/div[2]/fieldset[1]/div/div[1]/div[2]/div/span[1]/span[1]/span"));
        Users.click();
        WebElement number = driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[2]"));
        number.click();

        WebElement duration = driver.findElement(By.xpath("//*[@id=\"new-xtm-subscription-form\"]/div/div[2]/fieldset[1]/div/div[2]/div[1]/div/span[1]/span[1]/span"));
        duration.click();
        WebElement months = driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[3]"));
        months.click();

        WebElement words = driver.findElement(By.xpath("//*[@id=\"new-xtm-subscription-form\"]/div/div[2]/fieldset[1]/div/div[2]/div[2]/div/span[1]/span[1]/span"));
        words.click();
        WebElement no = driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]"));
        no.click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.id("USD")));

        WebElement element = driver.findElement(By.xpath("//div[@class='total-cost']/p/span"));
        String textValue = element.getText();
        String cleanValue = textValue.replace(",", ".").replace("$", "");
        double cost = Double.parseDouble(cleanValue);

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedCost = currencyFormatter.format(cost);
        System.out.println("Koszt wynosi: " + formattedCost);

        double expectedCost = 831.60;

        if (cost == expectedCost) {
            System.out.println("Koszt jest równy $831.60");
        } else {
            System.out.println("Koszt nie jest równy $831.60");
        }

        try {
            Thread.sleep(4000); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        driver.quit();
        }
    }
}

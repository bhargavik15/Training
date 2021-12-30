package alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckingAlerts {
    static WebDriver driver;
    static String url1 = "https://demoqa.com/alerts";
    static String xpath = "//*[@id=\"confirmButton\"]";
    static String output="text-success";
    //static String xpath2 = "//*[@id=\"confirmResult\"]/text()[2]";


    public static void main(String[] args) throws InterruptedException, AWTException {

        // String url1="https://demoqa.com/alerts";
        // String url2="//*[@id=\"confirmButton\"]";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        validateUrl(driver);
        validate_dialog_enabled(driver);
        validate_dialog_disable(driver);


    }

    static void validateUrl(WebDriver driver) {
        CheckingAlerts.driver.get(url1);
        List<WebElement> linksList = CheckingAlerts.driver.findElements(By.tagName("a"));
        System.out.println("=========================================");
        System.out.println("Total links:" + linksList.size());

        for (int i = 0; i < linksList.size(); i++) {
            System.out.println("Links on page are:" + linksList.get(i).getAttribute("href"));

            System.out.println("Link Name :" + linksList.get(i).getText());

        }
    }

    static void validate_dialog_enabled(WebDriver driver) {
        System.out.println("============================================");
        WebElement element = CheckingAlerts.driver.findElement(By.xpath(xpath));
        element.click();
        //Thread.sleep(2000);
        Alert alert = CheckingAlerts.driver.switchTo().alert();
        String message = alert.getText();
        System.out.println("content in alert box:" + message);
        alert.accept();
        System.out.println("Confirmation message:"+driver.findElement(By.className(output)).getText());
        if (element.isEnabled()) {
            System.out.println("Confirm Dialog box is enabled.Return:" + element.isEnabled());
        } else {
            System.out.println("Confirm Dialog box is disabled.Return:" + element.isEnabled());
        }
        System.out.println("========================================");
    }

    static void validate_dialog_disable(WebDriver driver) {
        WebElement element = CheckingAlerts.driver.findElement(By.xpath(xpath));
        element.click();
        //Thread.sleep(2000);
        Alert alert = CheckingAlerts.driver.switchTo().alert();
        String message = alert.getText();
        System.out.println("content in alert box:" + message );
        alert.dismiss();
        System.out.println("confirmation message:"+driver.findElement(By.className(output)).getText());


        if (element.isEnabled()) {
            System.out.println("Confirm Dialog box is enabled.Return:" + element.isEnabled());
        } else {
            System.out.println("Confirm Dialog box is disabled.Return:" + element.isEnabled());
        }
        System.out.println("=======================================");
         CheckingAlerts.driver.quit();


    }

}








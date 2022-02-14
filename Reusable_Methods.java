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

public class Reusable_Methods {
    static WebDriver driver;
    static String url1 = "https://demoqa.com/alerts";
    static String xpath = "//*[@id=\"confirmButton\"]";
    static String output = "text-success";
    static String url2 = "https://www.facebook.com";
    static String user_id = "email";
    static String pwd = "pass";
    static String signIn = "//button[@type='submit']";
    static String is_Element_Present = "Honey";


    static void launching() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    static void validateUrl(WebDriver driver) {
        Reusable_Methods.driver.get(url1);
        List<WebElement> linksList = Reusable_Methods.driver.findElements(By.tagName("a"));
        System.out.println("=========================================");
        System.out.println(" link count:" + linksList.size());

        for (int count= 0; count< linksList.size(); count++) {
            System.out.println("Links on page are:" + linksList.get(count).getAttribute("href"));

            System.out.println("Link Name :" + linksList.get(count).getText());

        }
    }

    static void validate_dialogbox_enabled(WebDriver driver) {
        System.out.println("============================================");
        WebElement element = Reusable_Methods.driver.findElement(By.xpath(xpath));
        element.click();
        //Thread.sleep(2000);
        Alert alert = Reusable_Methods.driver.switchTo().alert();
        String message = alert.getText();
        System.out.println("content in alert box:" + message);
        alert.accept();
        System.out.println("Confirmation message:" + driver.findElement(By.className(output)).getText());
        if (element.isEnabled()) {

            System.out.println("Confirm Dialog box is ok.Return:" + element.isEnabled());
        } else {


            System.out.println("Confirm Dialog box is cancel");
        }
        System.out.println("=========================================");


    }

    static void validate_dialogbox_disable(WebDriver driver) {
        WebElement element = Reusable_Methods.driver.findElement(By.xpath(xpath));
        element.click();
        //Thread.sleep(2000);
        Alert alert = Reusable_Methods.driver.switchTo().alert();
        String message = alert.getText();
        System.out.println("content in alert box:" + message);
        alert.dismiss();
        System.out.println("confirmation message:" + driver.findElement(By.className(output)).getText());


        if (element.isEnabled()) {
            System.out.println("Confirm Dialog box is cancel.Return:" + element.isEnabled());
        } else {
            System.out.println("confirm dialog box is not disabled");
        }
        System.out.println("=======================================");
    }


    static void Login_Fb(WebDriver driver) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url2);
        System.out.println(driver.getTitle());
        driver.findElement(By.id(user_id)).sendKeys(is_Element_Present);
        driver.findElement(By.id(pwd)).sendKeys("12345666");
        driver.findElement(By.xpath(signIn)).click();
        Thread.sleep(2000);

    }
}

















package alerts;

import org.openqa.selenium.WebDriver;

public class Run extends Reusable_Methods {
                public static void main(String[] args) throws InterruptedException {
                   launching();
                   validateUrl(driver);
                   validate_dialogbox_enabled(driver);
                   validate_dialogbox_disable(driver);
                    Login_Fb(driver);



               }
}







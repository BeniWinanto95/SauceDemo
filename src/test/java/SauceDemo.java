import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SauceDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://www.saucedemo.com/");
        WebElement inputEmail = chromeDriver.findElement(By.cssSelector("input[id*='user-name']"));
        inputEmail.sendKeys("standard_user");
        WebElement inputPassword = chromeDriver.findElement(By.cssSelector("input[id*='password']"));
        inputPassword.sendKeys("secret_sauce");
        WebElement buttonLogin = chromeDriver.findElement(By.cssSelector("input[id*='login-button']"));
        buttonLogin.click();
        WebElement labelProducts = chromeDriver.findElement(By.cssSelector("span[class*='title']"));
        String productLabelText = labelProducts.getText();
        assertEquals("PRODUCTS", productLabelText);


        Thread.sleep(3000);
        chromeDriver.quit();
    }
}

package pl.coderslab.zad2;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class zad2 {

    private WebDriver driver;
    private final String login = "bdtirtuaxkjzytebkb@tmmwj.net";
    private final String password = "JWick1";

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void newOrder() throws IOException {
        driver.get("https://mystore-testlab.coderslab.pl/");
        WebElement loginPage = driver.findElement(By.className("user-info"));
        loginPage.click();
        WebElement emailInput = driver.findElement(By.id("field-email"));
        WebElement passwordInput = driver.findElement(By.id("field-password"));
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        emailInput.sendKeys(login);
        passwordInput.sendKeys(password);
        signInButton.click();
        WebElement clothes = driver.findElement(By.id("category-3"));
        clothes.click();
        WebElement HummSweater = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div[1]/div[2]/article/div/div[2]/h2/a"));
        HummSweater.click();
        Select size = new Select(driver.findElement(By.id("group_1")));
        size.selectByValue("2");
        WebElement quantityUp = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/span[3]/button[1]/i"));
        quantityUp.click();
        quantityUp.click();
        quantityUp.click();
        quantityUp.click();
        WebElement addToCart = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button"));
        addToCart.click();
        WebElement checkout = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a"));
        checkout.click();
        WebElement checkout2 = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a"));
        checkout2.click();
        WebElement addressConfirmation = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[1]/section[2]/div/div/form/div[2]/button"));
        addressConfirmation.click();
        WebElement prestaShop = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[1]/section[3]/div/div[2]/form/div/div[1]/div[1]/div"));
        prestaShop.click();
        WebElement shippingConfirmation = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[1]/section[3]/div/div[2]/form/button"));
        shippingConfirmation.click();
        WebElement payByCheck = driver.findElement(By.id("payment-option-1"));
        WebElement termsApproval = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[1]/section[4]/div/form/ul/li/div[1]/span/input"));
        payByCheck.click();
        termsApproval.click();
        WebElement placeOrder = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button"));
        placeOrder.click();

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("D:\\studiuje IT\\CodersLab - Tester Automatyzujący\\Projekty Github\\SeleniumCourse\\pictures\\" + "orderscreenshot" + ".jpeg"));

        driver.quit();
    }
}

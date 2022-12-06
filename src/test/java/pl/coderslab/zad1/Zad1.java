package pl.coderslab.zad1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Zad1 {

    private WebDriver driver;
    private final String login = "bdtirtuaxkjzytebkb@tmmwj.net";
    private final String password = "JWick1";
    private final String alias = "Wicky";
    private final String address = "Puppystreet";
    private final String zip = "000-000";
    private final String city = "Londyn";
    private final String phone = "+48100200300";

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void newAddress() {
        driver.get("https://mystore-testlab.coderslab.pl/");
        WebElement loginPage = driver.findElement(By.className("user-info"));
        loginPage.click();
        WebElement emailInput = driver.findElement(By.id("field-email"));
        WebElement passwordInput = driver.findElement(By.id("field-password"));
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        emailInput.sendKeys(login);
        passwordInput.sendKeys(password);
        signInButton.click();
        WebElement addresses = driver.findElement(By.cssSelector("a[title=\"Addresses\"]"));
        addresses.click();
        WebElement createNewAddress = driver.findElement(By.cssSelector("a[data-link-action=\"add-address\"]"));
        createNewAddress.click();
        WebElement aliasField = driver.findElement(By.id("field-alias"));
        WebElement addressField = driver.findElement(By.id("field-address1"));
        WebElement cityField = driver.findElement(By.id("field-city"));
        WebElement zipField = driver.findElement(By.id("field-postcode"));
        Select countryField = new Select(driver.findElement(By.id("field-id_country")));
        WebElement phoneField = driver.findElement(By.id("field-phone"));
        WebElement saveButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/footer/button"));
        aliasField.sendKeys(alias);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        zipField.sendKeys(zip);
        countryField.selectByValue("17");
        phoneField.sendKeys(phone);
        saveButton.click();

    }
}

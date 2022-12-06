package pl.coderslab.seleniumcourse;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuckDuckGoSearchTest {
    @Test
    public void duckDuckGoSearch() {
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.clear();
        searchInput.sendKeys("Czy w Polsce można legalnie mieć Kapibarę?");
        searchInput.submit();
    }
}

package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.junit.Assert.assertEquals;


public class ScooterStartPageTest {
    private WebDriver driver;

    @Before
    public void startUpChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void checkAnswersChrome() {
        driver = new ChromeDriver();
        ScooterStartPage startPage = new ScooterStartPage(driver);
        startPage.openStartPage();
        startPage.coockyButtonClick();
        startPage.scrollToQuestions();
        for (int i = 0; i < 8; i++) {
            driver.findElement(By.xpath(".//div[@id = 'accordion__heading-" + i + "']")).click();
            WebElement element = driver.findElement(By.xpath(".//div[@id = 'accordion__panel-" + i +"']/p"));
                assertEquals(startPage.getExpectedTexts(i), element.getText());
            }
    }

    @Test
    public void checkAnswersFireFox() {
        driver = new FirefoxDriver();
        ScooterStartPage startPage = new ScooterStartPage(driver);
        startPage.openStartPage();
        startPage.coockyButtonClick();
        startPage.scrollToQuestions();
        for (int i = 0; i < 8; i++) {
            driver.findElement(By.xpath(".//div[@id = 'accordion__heading-" + i + "']")).click();
            WebElement element = driver.findElement(By.xpath(".//div[@id = 'accordion__panel-" + i +"']/p"));
            assertEquals(startPage.getExpectedTexts(i), element.getText());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
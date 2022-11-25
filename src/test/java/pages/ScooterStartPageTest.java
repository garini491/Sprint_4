package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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
        startPage.cookieButtonClick();
        startPage.scrollToQuestions();
        for (int i = 0; i < 8; i++) {
            startPage.questionClick(i);
            assertEquals(startPage.getExpectedTexts(i), startPage.getAnswer(i));
        }
    }

    @Test
    public void checkAnswersFireFox() {
        System.setProperty("webdriver.gecko.driver", "/home/a.zmei/WebDriver/bin/geckodriver/geckodriver");
        driver = new FirefoxDriver();
        ScooterStartPage startPage = new ScooterStartPage(driver);
        startPage.openStartPage();
        startPage.cookieButtonClick();
        startPage.scrollToQuestions();
        for (int i = 0; i < 8; i++) {
            startPage.questionClick(i);
            assertEquals(startPage.getExpectedTexts(i), startPage.getAnswer(i));
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
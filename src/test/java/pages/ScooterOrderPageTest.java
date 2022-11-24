package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ScooterOrderPageTest {
    private WebDriver driver;
    private final String name;
    private final String adres;
    private final String lname;
    private final String station;
    private final String phone;
    private final String day;
    private final String period;
    private final String color;
    private final String comment;

    public ScooterOrderPageTest(String name, String lname, String adres, String station, String phone, String day, String period, String color, String comment) {
        this.name = name;
        this.lname = lname;
        this.adres = adres;
        this.station = station;
        this.phone = phone;
        this.day = day;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "Алексей",
                  "Змей",
                  "пр-т Гагарина 15",
                  "Преображенская площадь",
                  "+79788777777",
                  "14",
                  "четверо суток",
                  "чёрный жемчуг",
                  ""},
                {
                        "Марина",
                        "Хавро",
                        "Арбатская 20",
                        "Сокольники",
                        "+79788777777",
                        "26",
                        "сутки",
                        "серая безысходность",
                        "тестовый комментарий"
                },
        };
    }

    @Before
    public void startUpChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void createOrderChromeHigh() {
        driver = new ChromeDriver();
        ScooterStartPage startPage = new ScooterStartPage(driver);
        startPage.openStartPage();
        startPage.coockyButtonClick();
        startPage.highClick();
        ScooterOrderPage createOrder = new ScooterOrderPage(driver);
        createOrder.regData(name,lname,adres,station,phone);
        createOrder.regScooter(day,period,color,comment);
        createOrder.yesClick();
        String expected = "Заказ оформлен";
        assertEquals(expected,createOrder.orderCreated());
        createOrder.cancelOrder();
    }
    @Test
    public void createOrderChromeLow() {
        driver = new ChromeDriver();
        ScooterStartPage startPage = new ScooterStartPage(driver);
        startPage.openStartPage();
        startPage.coockyButtonClick();
        startPage.lowClick();
        ScooterOrderPage createOrder = new ScooterOrderPage(driver);
        createOrder.regData(name,lname,adres,station,phone);
        createOrder.regScooter(day,period,color,comment);
        createOrder.yesClick();
        String expected = "Заказ оформлен";
        assertEquals(expected,createOrder.orderCreated());
        createOrder.cancelOrder();
    }
    @Test
    public void createOrderFirefoxHigh() {
        driver = new FirefoxDriver();
        ScooterStartPage startPage = new ScooterStartPage(driver);
        startPage.openStartPage();
        startPage.coockyButtonClick();
        startPage.highClick();
        ScooterOrderPage createOrder = new ScooterOrderPage(driver);
        createOrder.regData(name,lname,adres,station,phone);
        createOrder.regScooter(day,period,color,comment);
        createOrder.yesClick();
        String expected = "Заказ оформлен";
        assertEquals(expected,createOrder.orderCreated());
        createOrder.cancelOrder();
    }
    @Test
    public void createOrderFirefoxLow() {
        driver = new FirefoxDriver();
        ScooterStartPage startPage = new ScooterStartPage(driver);
        startPage.openStartPage();
        startPage.coockyButtonClick();
        startPage.lowClick();
        ScooterOrderPage createOrder = new ScooterOrderPage(driver);
        createOrder.regData(name,lname,adres,station,phone);
        createOrder.regScooter(day,period,color,comment);
        createOrder.yesClick();
        String expected = "Заказ оформлен";
        assertEquals(expected,createOrder.orderCreated());
        createOrder.cancelOrder();
    }

    @After
    public void tierDown() {
        driver.quit();
    }
}
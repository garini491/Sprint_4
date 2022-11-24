package pages;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.hamcrest.core.Is.is;

public class ScooterOrderPage {

    WebDriver driver;

    public ScooterOrderPage(WebDriver driver){
        this.driver = driver;
    }
    // Поле "Имя"
    private By firstname = By.xpath(".//input[@placeholder = '* Имя']");
    // Поле "Фамилия"
    private By lastname = By.xpath(".//input[@placeholder = '* Фамилия']");
    // Поле "Адрес"
    private By adres = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // Поле "Станция"
    private By station = By.xpath(".//input[@placeholder = '* Станция метро']");
    // Поле "Телефон"
    private By phone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private By nextButton = By.xpath(".//button[text() = 'Далее']");

    // Поле даты
    private By date = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    // Модальное окно подтверждения заказа
    private By orderModal = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']");

    // Кнопка "Да" модального окна
    private By yesButton = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']/button[text() = 'Да']");

    // Поле Периода аренды
    private By periodRent = By.className("Dropdown-control");

    // Цвета самоката
    private By blackScooter = By.id("black");
    private By greyScooter = By.id("grey");

    // Кнопка "Посмотреть статус"
    private By lookStatus = By.xpath(".//button[text() = 'Посмотреть статус']");

    // Кнопка "Отменить заказ"
    private By orderCancel = By.xpath(".//button[text() = 'Отменить заказ']");

    // Модальное окно отмены заказа
    private By cancelModal = By.xpath(".//div[text() = 'Хотите отменить заказ?']");

    // Кнопка Отменить в модальном окне
    private By cancel = By.xpath(".//button[text() = 'Отменить'");

    // Окно подтверждения отмененного заказа
    private By orderCancelModal = By.xpath(".div[text() = 'Заказ отменён'");

    // Кнопка "Хорошо"
    private  By goodButton = By.xpath(".//button[text() = 'Хорошо']");

    // Поле комментария
    private By comment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    // Кнопка "Заказать"
    private By createButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    // Метод заполнения поля Имя
    public void sendName(String name) {
        driver.findElement(firstname).sendKeys(name);
    }
    // Метод заполнения поля Фамилия
    public void sendLastname(String lname) {
        driver.findElement(lastname).sendKeys(lname);
    }
    // Метод заполнения поля Адрес
    public void setAdress(String adress) {
        driver.findElement(adres).sendKeys(adress);
    }

    // Метод заполнения поля Станция метро
    public void setStation(String stationName) {
        driver.findElement(station).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[text() ='" + stationName + "']")));
        driver.findElement(By.xpath(".//div[text() ='" + stationName + "']")).click();
    }
    // Метод клика на кнопку Далее
    public void nextClick() {
        driver.findElement(nextButton).click();
    }

    // Метод заполнения поля Телефон
    public void setPhone(String telephone) {
        driver.findElement(phone).sendKeys(telephone);
    }


    // Шаг заполнения первой страницы
    public void regData(String name, String lname, String adress, String stationName, String telephone) {
        sendName(name);
        sendLastname(lname);
        setAdress(adress);
        setStation(stationName);
        setPhone(telephone);
        nextClick();
    }

    // Метод заполнения поля даты
    public void setDate(String day) {
        driver.findElement(date).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.className("react-datepicker__month-container"))));
        driver.findElement(By.xpath(".//div[text() = '" + day + "']")).click();
    }

    // Метод указания периода аренды
    public void setPeriod(String range) {
        driver.findElement(periodRent).click();
        driver.findElement(By.xpath(".//div[text() = '" + range + "']")).click();
    }

    // Метод выюора самоката
    public void setScooter (String color) {
        if(color == "чёрный жемчуг") {
            driver.findElement(blackScooter).click();
        } else {
            driver.findElement(greyScooter).click();
        }
    }

    // Метод заполнения комментария
    public void setComment(String comment1) {
        driver.findElement(comment).sendKeys(comment1);
    }

    // Метод нажатия кнопки заказать
    public void createOrderClick() {
        driver.findElement(createButton).click();
    }

    // Шаг заполнения второй части заказа
    public void regScooter(String day, String period, String color, String coment){
        setDate(day);
        setPeriod(period);
        setScooter(color);
        setComment(coment);
        createOrderClick();
    }

    // Метод клика на кнопку да
    public void yesClick() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderModal)));
        driver.findElement(yesButton).click();
    }

    // Метод получения текста "Заказ оформлен"
    public String orderCreated() {
        return driver.findElement(orderModal).getText();
    }

    // Метод возврата стенда в исходное состояние (отмена заказа)
    public void cancelOrder() {
        driver.findElement(lookStatus).click();
        driver.findElement(orderCancel).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(cancelModal)));
        driver.findElement(cancel).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderCancelModal)));
        driver.findElement(goodButton).click();

    }

}

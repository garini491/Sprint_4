package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class ScooterStartPage {
    WebDriver driver;

    // Ссылка на старотовую страницу
    private String url = "https://qa-scooter.praktikum-services.ru/";
    // Блок c вопросами
    private By homeFAQ = By.className("Home_FAQ__3uVm4");

    // Верхняя кнопка "Заказать"
    private By createOrderHigh = By.className("Button_Button__ra12g");
    // Нижняя кнопка "Заказать"
    private By createOrderLow = By.className("Home_FinishButton__1_cWm");
    // Кнопка подтверждения куки
    private By cookieButton = By.id("rcc-confirm-button");

    public ScooterStartPage(WebDriver driver){
        this.driver = driver;
    }


    // Открытие страницы
    public void openStartPage() {
        driver.get(url);
    }

    // Скролл до вопросов
    public void scrollToQuestions() {
        WebElement element = driver.findElement(homeFAQ);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Метод нажатия на кнопку куки
    public void cookieButtonClick() {
        driver.findElement(cookieButton).click();
    }


    // Метод клика на верхнюю кнопку "Заказать"
    public void highClick(){
        driver.findElement(createOrderHigh).click();
    }

    // Метод клика на нижнюю кнопку "Заказать"
    public void lowClick() {
        driver.findElement(createOrderLow).click();
    }

    // Метод для клика на вопрос
    public void questionClick(String question) {
        driver.findElement(By.xpath(".//div[text() = '" + question + "']")).click();
    }

    // Метод получения текста после нажатия на кнопку
    public String getAnswer(String question) {
        return driver.findElement(By.xpath(".//div[text() = '" + question +"']/parent::div/parent::div/div[2]/p")).getText();
    }

    // Метод прокрутки до нижней кнопки
    public void findLowCreateButton() {
        WebElement element = driver.findElement(createOrderLow);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}

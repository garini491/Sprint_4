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
    private By createOrderLow = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    // Кнопка подтверждения куки
    private By coockyButton = By.id("rcc-confirm-button");

    public ScooterStartPage(WebDriver driver){
        this.driver = driver;
    }

    // Массив текстов
    private String[] expectedTexts = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    // Открытие страницы
    public void openStartPage() {
        driver.get(url);
    }

    // Скролл до вопросов
    public void scrollToQuestions() {
        WebElement element = driver.findElement(homeFAQ);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public String getExpectedTexts(int i) {
        return expectedTexts[i];
    }
    // Метод нажатия на кнопку куки
    public void coockyButtonClick() {
        driver.findElement(coockyButton).click();
    }


    // Метод клика на верхнюю кнопку "Заказать"
    public void highClick(){
        driver.findElement(createOrderHigh).click();
    }

    // Метод клика на нижнюю кнопку "Заказать"
    public void lowClick() {
        driver.findElement(createOrderLow).click();
    }
}

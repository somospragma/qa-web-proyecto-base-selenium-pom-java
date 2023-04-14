package pages;

import java.time.Duration;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action; 

    //funcion estatica que se ejecuta con el llamado -- configura driver y abre navegador
    static {
        ChromeOptions chromeOptions = new ChromeOptions();
//        System.setProperty("webdriver.chrome.driver", "app/src/test/resources/chromedriver/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //constructor de la clase --
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements (driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //se dirige a una url
    public static void navigateTo(String url) {
        driver.get(url);
    }

    //cerrar navegador
    public static void closeBrowser(){
        driver.quit();
    }

    //retornar un elemento
    private WebElement Find(String locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    //click en un elemento
    public void clickElement(String locator) {
        Find(locator).click();
    }

    //ir a un link text 
    public void goToLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    //escribir en un text field
    public void write(String locator,String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    //selet de un dropdown
    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    //interacciones con Actions
    //mover el mouse sobre un elemento
    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }
    //double click
    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }
    //right click
    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    //tablas
    //get value
    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/body/tr["+row+"]/td["+column+"]";
        return Find(cellINeed).getText();
    }
    //set value
    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToField = locator+"/table/body/tr["+row+"]/td["+column+"]";
        Find(cellToField).sendKeys(stringToSend);
    }

    //iFrames y PopUps
    //Switcheo de Frame (su ventana)
    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }
    //volver al parent
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
    //cerrar alerta (popup)
    public void dismissAlert(){
        try{  // el try nos permite intentar una accion que posiblemente pueda fallar, en este caso puede ser que el popup se presente o no
        driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){ //el catch nos permite indicar el comportamiento cuando el try falle
            e.printStackTrace(); //imprime el error
        } 
    }

    //get text of element -- para Assert del tipo equals
    public String textFromElements(String locator){
        return Find(locator).getText();
    }

    //funciones para Asserts del tipo true o false
    //existencia de un elemento
    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }
    //elemento habilitado para clickear
    public boolean elementEnabled(String locator){
        return Find(locator).isEnabled();
    }
    //elemento esta seleccionado
    public boolean elementSelected(String locator){
        return Find(locator).isSelected();
    }

    //encontrar elementos de una lista
    public List<WebElement> bringAllElements(String locator){
        return driver.findElements(By.className(locator));
    }

}

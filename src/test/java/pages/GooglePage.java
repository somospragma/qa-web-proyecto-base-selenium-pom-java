package pages;

public class GooglePage extends BasePage {

    private String searchButton = "//input[@value='Buscar con Google']";
    private String searchTextField = "//textarea[@id='APjFqb']";
    private String firstResultSearch="//h3[contains(text(),'Hola Colombia: últimas noticias e imágenes - Revis')]";

    public GooglePage() {
   
        super(driver);
    }

    public void navigateToGoogle() {
        navigateTo("https://www.google.com/");
    }

    public void clickGoogleSeach() {
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }

    //funciones para obtener resultados para los asserts
    public String firstResult(){
        return textFromElements(firstResultSearch);
    }
    public boolean FirstResultStatus(){
        return elementIsDisplayed(firstResultSearch);
    }
}

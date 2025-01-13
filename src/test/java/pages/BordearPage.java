package pages;

public class BordearPage extends BasePage {

    private final String usernameInput = "//input[@id='user-name']";
    private final String passwordInput = "//input[@id='password']";
    private final String loginButton="//input[@id='login-button']";
    private final String addProduct = "//div[.='Test.allTheThings() T-Shirt (Red)']//following::button[1]";

    public BordearPage() {
        super(driver);
    }

    public void navigateToLogin() {
        navigateTo("https://www.saucedemo.com/v1/index.html");
    }

    public void enterUsername(String username){
        write(usernameInput, username);
        bordearElemento(usernameInput);
    }

    public void enterPassword(String password){
        write(passwordInput, password);
        bordearElemento(passwordInput);
    }

    public void clickLogin() {
        bordearElemento(loginButton);
        clickElement(loginButton);
    }

    public void addProduct(){
        scrollIntoView(addProduct);
        bordearElemento(addProduct);
        clickElement(addProduct);
    }



}

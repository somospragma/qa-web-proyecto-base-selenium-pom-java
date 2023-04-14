package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import pages.BasePage;

//la clase hooks se usa generalmente en Cucumber para establer cosas que se ejucutan al inicio y al final de un test
public class Hooks extends BasePage{

    public Hooks (){
        super(driver);
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            scenario.log("ESTO FALLO");
            final byte[] screenshot = ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", null);
        }

    }

    
}

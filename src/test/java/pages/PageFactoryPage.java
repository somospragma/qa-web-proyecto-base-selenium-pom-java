package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PageFactoryPage extends BasePage {
    
    @CacheLookup //guarda en caché el elemento en cuestión para que, en posteriores usos, no tenga que hacerse esa llamada a la API de Selenium para buscar nuevamente algo que ya se había encontrado
    @FindBy(id="boton")
    WebElement boton;

    public PageFactoryPage(){
        super(driver);
        driver.get("www.google.com");
    }
}
/*
De nuevo, para recordarles: El framework que hicimos hasta ahora NO NECESITA 
de PageFactory, de hecho funciona mejor, en mi opinión, y es más robusto. El tutorial 
apunta a que aprendan a usarlo porque se que es algo que le van a preguntar o exigir
en muchos puestos de trabajo. 

Observemos un par de cosas acá. Primero y principal, estamos usando dos librerías que vienen
con Selenium, las cuales son FindBy y WebElement por supuesto. Estamos usando acá WebElement 
porque les recuerdo que no estamos más creando el WebElement en la BasePage como lo hacemos 
en nuestro Framework principal. Es por eso que necesitamos crearlos en esta clase. Ven ya una 
de las diferencias? Van a estar necesitando poner esto en todas las clases de página.

La clase que creamos va a extender la clase base de la misma manera para la construcción del 
WebDriver. Luego, vemos el corazón de PageFactory: la anotación @FindBy!.Esta anotación lo que 
va a hacer es ahorrarnos la creación de WebElements de la manera que tradicionalmente se hace. 
Por defecto, busca id o name iguales a lo que le digamos, pero podemos especificar otras maneras 
de localizar los webelements, como XPath, CSS, etc.

Usando la anotación, diciendo cómo se llama el campo por el cual vamos a encontrar el elemento y 
diciendo abajo WebElement además del nombre que queramos darle, vamos a tener creado nuestro WebElement
listo para usarse.

Ahora, otra cosa...como no tenemos la inicialización de los WebElements por ningún lado, nuestros tests
van a fallar diciendo "che...no hay ningún WebElement por acá!" Para eso, en la BasePage 
que estamos heredando en esta nueva clase que creamos, en el constructor de la clase base, vamos a añadir 
lo siguiente: 

PageFactory.initElements (driver, this); //despues del BasePage.driver=driver;

Esto va a permitir que, al instanciar las clases de página que heredan a ésta, los elementos 
con la anotación de PageFactory se inicialicen correctamente para ser usados.

Eso es todo el misterio detrás de PageFactory. La dificultad que tiene la mayoría es en saber dónde 
inicializar los elementos. Pueden hacerlo en el constructor de la clase de la página, pueden hacerlo 
en las step definitions...aunque mi consejo es que lo hagan en la clase base que instancia el 
WebDriver para que siempre esté hecho y no tengan que acordarse de arrancarlo ustedes a mano en cada 
lado que lo quieran usar.
.*/

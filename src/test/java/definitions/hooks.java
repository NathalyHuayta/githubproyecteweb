package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hooks {
    public static WebDriver driver;
    @Before
    public static void setUp(){
    //donde esta ubicado el chrome driver
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        //inicializar la variable driver con el chromedriver
        driver = new ChromeDriver();
        //maximizar el navegador
        driver.manage().window().maximize();
    }
    @After
    public static void tearDown(){
        //manejo del navegador, a veces las cookies se quedan pegadas
        driver.manage().deleteAllCookies();
        //cerrar navegador
        driver.close();  

    }
}


package pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class menuPage extends util {
    @FindBy(xpath = "Generate Card Number") protected WebElement lnkGenerarTarjeta;
    @FindBy(css = "#nav > a:nth-child(2)") protected WebElement lnkGenerarTarjeta2;
    @FindBy(xpath = "//nav/a[@href='cardnumber.php']") protected WebElement lnkGenerarTarjeta3;

    public menuPage() {
    //buscar en el navegador e inicializarlos, referenciar con el this
        PageFactory.initElements(driver, this); }
    //crear metodo
    public void clickGenerarTarjeta(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkGenerarTarjeta2));
        lnkGenerarTarjeta2.click();

    }
}

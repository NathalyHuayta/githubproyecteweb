package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class tarjetaPage extends util {
    //public static le da una libertad completa de poder ser utilizado en cualquier clase
   public static String nro_Tarjeta;
    public static String cvvTarjeta;
   public static String expMes;
    public static String expAnio;

    @FindBy(xpath = "//*[contains(text(),'Card Number:')]") protected WebElement lblnroTarjeta;
    @FindBy(xpath = "//*[contains(text(),'CVV:')]") protected WebElement lblcvvTarjeta;
    @FindBy(xpath= "//*[contains(text(),'Exp:')]") protected WebElement lblexpTarjeta;

    public tarjetaPage() {
        PageFactory.initElements(driver, this);
    }
    //metodos obtenga e imprima lo que se obtiene
    public void obtenerNroTarjeta(){
        js.executeScript("window.scrollBy(0,300)","");
        wait.until(ExpectedConditions.visibilityOf(lblnroTarjeta));
        String texto = lblnroTarjeta.getText();
        nro_Tarjeta= texto.replace("Card Number:- ","");
        System.out.println(nro_Tarjeta);
    }
    public void obtenercvv(){
        String texto = lblcvvTarjeta.getText();
        cvvTarjeta= texto.replace("CVV:- ","");
        System.out.println(cvvTarjeta);
    }
    public void obtenerExp() {
        String texto = lblexpTarjeta.getText();
        String fecha [] = texto.replace("Exp:- ","").split("/");
        expMes= fecha[0];
        expAnio=fecha[1];
        System.out.println(expMes);
        System.out.println(expAnio);
    }
}

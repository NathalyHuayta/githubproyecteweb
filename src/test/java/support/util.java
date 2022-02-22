package support;

import definitions.hooks;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class util extends hooks {
    //variable publica
    public static WebDriverWait wait;
    public static JavascriptExecutor js;
    public static Alert dialogo;

    public util() {
        //wait explicito

        wait = new WebDriverWait( driver ,60);
        js = (JavascriptExecutor) driver;
    }

        //CREANDO METODO
        public void ventanaActiva(){
        //OBTENER IDENTIFICACORES Y GUARDARLOS Y COLOCARSE EN LA ULTIMA VENTANA ACTIVA
            Set<String> identificadores = driver.getWindowHandles();
            //guardar el identificador
            for(String identificador:identificadores){
                //posicionarme en la ultima ventana activa
                driver.switchTo().window(identificador);

            }

    }
    //regresar a la ventana
    public void ventanaInicial(){
    driver.close();
    driver.switchTo().window("");
    }
    public void scrollVertical(){
        js.executeScript("window.scrollBy(0,1000)");
    }

    public  void aceptarDialogo(){
        dialogo = driver.switchTo().alert();
        dialogo.accept();
    }
    public void obtenerTextoDialogo(String mensaje){
        dialogo = driver.switchTo().alert();
        Assert.assertEquals(mensaje, dialogo.getText());
    }
    public static void evidencias() throws IOException {
        //fecha actual
        Date fecha =new Date();
        //formato de fecha
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmssSSS");
        String path = "C:\\Users\\NATHALY\\IdeaProjects\\proyecto\\target\\evidencias\\";
        String nombre= formato.format(fecha)+"evidencia.jpg";

        //captura de evidencia
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //crea la evidencia dentro de la ruta
        FileUtils.copyFile(file, new File(path+nombre));

    }

}

package definitions;
import io.cucumber.java.es.*;
import pageobjects.*;

import java.io.IOException;

import static support.util.evidencias;

public class CarritoDefinition {
    //llamar las clases del pageobjets
    menuPage menu;
    tarjetaPage tarjeta;
    carritoPage carrito;
    pagoPage pago;
    confirmacionPage confirmacion;
    public CarritoDefinition() {
    //inicializar las clases del pageobjetcs
        menu = new menuPage();
        tarjeta = new tarjetaPage();
        carrito = new carritoPage();
        pago = new pagoPage();
        confirmacion = new confirmacionPage();
    }

    @Dado("que la web esta operativa")
    public void queLaWebEstaOperativa() {
        //abrir el navegador, ingresar la url del navegador
        hooks.driver.get("https://demo.guru99.com/payment-gateway/purchasetoy.php");
    }
    @Cuando("se genera el numero de tarjeta")
    public void seGeneraElNumeroDeTarjeta() throws IOException {
        menu.clickGenerarTarjeta();
        menu.ventanaActiva();
        tarjeta.obtenerNroTarjeta();
        tarjeta.obtenercvv();
        tarjeta.obtenerExp();
        evidencias();
        tarjeta.ventanaInicial();
    }

    @Y("selecciona la cantidad {string}")
    public void seleccionaLaCantidad(String cant) throws IOException {
        carrito.seleccionarCantidad(cant);
        evidencias();
    }

    @Y("realiza la compra del producto")
    public void realizaLaCompraDelProducto() {
        carrito.clickComprar();
    }

    @E("ingresa los datos de la tarjeta")
    public void ingresaLosDatosDeLaTarjeta() {
        pago.escribirNrodeTarjeta(tarjetaPage.nro_Tarjeta);
        pago.seleccionarMes(tarjetaPage.expMes);
        pago.seleccionarAnio(tarjetaPage.expAnio);
        pago.escribirCvv(tarjetaPage.cvvTarjeta);
    }

    @Y("paga el producto")
    public void pagaElProducto() {
        pago.scrollVertical();
        pago.clickPagar();
    }

    @Entonces("validar el mensaje de pago {string}")
    public void validarElMensajeDePago(String mensaje) throws IOException {
        confirmacion.validaMensaje(mensaje);
        evidencias();
        confirmacion.mostrarCodigo();
    }


    @Y("selecciona el mes {string}")
    public void seleccionaElMes(String mes) {
        pago.seleccionarMes(mes);
    }

    @Y("selecciona el anio {string}")
    public void seleccionaElAnio(String anio) {
        pago.seleccionarAnio(anio);
    }

    @Entonces("validar el mensaje del cuadro de dialogo {string}")
    public void validarElMensajeDelCuadroDeDialogo(String msj) {
        pago.obtenerTextoDialogo(msj);
        pago.aceptarDialogo();
    }
}


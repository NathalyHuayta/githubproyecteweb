# language: es
  @primerafuncionalidad
Característica: Funcionalidad del carrito de compra version 2
@smoke
  Escenario: Compra de un producto version 2
    Dado que la web esta operativa
    Cuando se genera el numero de tarjeta
    Y selecciona la cantidad "1"
    Y realiza la compra del producto
    E ingresa los datos de la tarjeta
    Y paga el producto
    Entonces validar el mensaje de pago "Payment successfull!"
@regresion
  Esquema del escenario: Compra de un producto con varias cantidades version 2
    Dado que la web esta operativa
    Cuando se genera el numero de tarjeta
    Y selecciona la cantidad "<cantidad>"
    Y realiza la compra del producto
    E ingresa los datos de la tarjeta
    Y paga el producto
    Entonces validar el mensaje de pago "<mensaje>"

    Ejemplos: Tabla de cantidades
    |cantidad| mensaje|
    |3       |Payment successfull!|
    |5       |Payment successfull!|
    |7       |Payment successfull!|

  Esquema del escenario: Compra de un producto con cantidad version 2
    Dado que la web esta operativa
    Cuando se genera el numero de tarjeta
    Y selecciona la cantidad "<opciones>"
    Y realiza la compra del producto
    E ingresa los datos de la tarjeta
    Y paga el producto
    Ejemplos: Tabla de cantidades
      |opciones|
      |2       |
      |3       |
      |9       |
      |1       |
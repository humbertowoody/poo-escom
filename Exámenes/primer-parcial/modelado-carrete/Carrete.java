/**
 * Carrete.java
 * 
 * Descripción:
 *   1.- Modelar un Carrete (o rollo) de cable
 *       -suponga que cada carrete viene con 100 m de cable
 *       -el cable solo se vende al menudeo por metro (o sea no por carrete)
 *       -Si hay suficiente cable entonces se debe cortar del carrete la cantidad de cable que pida el cliente
 *
 * Diagrama de modelado UML:
 *
 * |-----------------------------|
 * |           Carrete           |
 * |-----------------------------|
 * |  metros                     |
 * | - - - - - - - - - - - - - - |
 * | obtenerMetrosDisponibles()  |
 * | cortarMetros(int)           |
 * |-----------------------------|
 *
 *
 * Examen: Primer Parcial
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Profesor: Roberto Tecla
 * Materia: Programación Orientada a Objetos
 * Fecha: 28 de Octubre de 2020.
 *
 */


// Clase Carrete
public class Carrete {
  private int metros; // Variable de instancia
  
  // Constructor de la clase.
  public Carrete() {
    this.metros = 100; // Por default, tenemos 100 metros.
  }
  
  // Función para "cortar" y despachar un cierto número de metros a un cliente.
  public int cortarMetros(int metrosACortar) {
    if ((this.metros - metrosACortar) >= 0) {
      this.metros -= metrosACortar; // Restamos la cantidad a cortar.
      return metrosACortar;
    } else {
      return 0;
    }
  }
  
  // Función para obtener el número de metros disponibles en el carrete.
  public int obtenerMetrosDisponibles() {
    return this.metros;
  }

  /**
   * Función principal
   * Realiza la ejecución del código simulando 3 clientes que llegan a pedir distintas medidas de cable
   * de un carrete y al final imprime las cantidades resultantes.
   */
  public static void main(String[] args) {
    // Creamos un carrete de cable UTP categoría 5e para vender en nuestra miscelánea de equipo de redes.
    Carrete utpCat5e = new Carrete(); 
    
    // Llega nuestro primer cliente (¡wuuu!) y nos pide 200 metros.
    int metrosVendidosCliente1 = utpCat5e.cortarMetros(200);
    
    // Si el carrete que tenemos lo permite, lo despachamos.
    if (metrosVendidosCliente1 > 0) {
      System.out.println("Se vendieron 200 metros al cliente 1");
    } else {
      System.out.println("No se pudieron vender 200 metros al cliente 1 porque únicamente tenemos: " + utpCat5e.obtenerMetrosDisponibles() + " metros.");
    }

    // Llega un cliente 2 y pide 50 metros.
    int metrosVendidosCliente2 = utpCat5e.cortarMetros(50);

    // Si el carrete lo permite, lo despachamos.
    if (metrosVendidosCliente2 > 0) {
      System.out.println("Se vendieron 50 metros al cliente 2");
    } else {
      System.out.println("No se pudieron vender 50 metros al cliente 2 porque únicamente tenemos: " + utpCat5e.obtenerMetrosDisponibles() + " metros");
    }
    
    // Llega un cliente 3 y pide 51 metros.
    int metrosVendidosCliente3  = utpCat5e.cortarMetros(51);  

    // Si el carrete lo permite, lo despachamos por igual.
    if (metrosVendidosCliente3 > 0) {
      System.out.println("Se vendieron 51 metros al cliente 3");
    } else {
      System.out.println("No se pudieron vender 51 metros al cliente 3 porque únicamente tenemos: " + utpCat5e.obtenerMetrosDisponibles() + " metros");
    }

    // Al final hacemos cuentas de cuántos metros vendimos.
    System.out.println("Se vendió un total de: " + (100 - utpCat5e.obtenerMetrosDisponibles()) + " metros.");
    System.out.println("El cliente 1 se llevó: " + metrosVendidosCliente1 + " metros");
    System.out.println("El cliente 2 se llevó: " + metrosVendidosCliente2 + " metros");
    System.out.println("El cliente 3 se llevó: " + metrosVendidosCliente3 + " metros");
  }
}

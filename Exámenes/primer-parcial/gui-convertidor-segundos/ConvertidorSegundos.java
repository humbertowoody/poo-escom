/**
 * ConvertidorSegundos.java
 * 
 * Descripción:
 *  3.-Codificar un applet que tenga un botón, tres campos de entrada y una etiqueta. 
 *     Un campos de entrada es para las horas, otro para el numero de minutos y otro 
 *     mas para el numero de segundos imprima el total de segundos transcurridos en la etiqueta 
 *     si se presiona el boton. Ejemplo si se le dan 18 hrs con 3 min y 20 segundos 
 *     el programa debe imprimir 65000 segundos (18*3600+3*60+20).
 *
 * Diagrama de modelado UML:
 *
 * |----------------------------------------------------------|
 * |                   ConvertidorSegundos                    |
 * |----------------------------------------------------------|
 * | botonConvertir                                           |
 * | campoHoras                                               |
 * | campoMinutos                                             |
 * | campoSegundos                                            |
 * | etiquetaResultado                                        |
 * | ventana                                                  |
 * | - - - - - - - - - - - - - - - - - - - - - - - - - - - - -|
 * | convertirASegundos(int horas, int minutos, int segundos) |
 * |----------------------------------------------------------|
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

import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import javax.swing.*;

/**
 * ConvertidorSegundos
 * GUI para convertir horas, minutos y segundos en un valor de segundos únicamente.
 * Utiliza Swing para realizar el UI porque los Applets (per sé) no me funcionaron.
 */
public class ConvertidorSegundos extends JApplet implements ActionListener {
  private JButton botonConvertir;                             // El botón para realizar la conversión.
  private JTextField campoHoras, campoMinutos, campoSegundos; // Los campos de entradas.
  private JLabel etiquetaResultado;                           // La etiqueta para el resultado.
  private JFrame ventana;                                     // La ventana de nuestro programa.
  
  // Constructor de la clase.
  public ConvertidorSegundos() {
    // Creamos la ventana.
    this.ventana = new JFrame("Convertidor Segundos"); // El título es Convertidor Segundos.
    this.ventana.getContentPane().setLayout(new FlowLayout()); // Usamos FlowLayout para que todo esté alineado.

    // Creamos el botón y lo añadimos a la ventana.
    this.botonConvertir = new JButton("Convertir");
    this.ventana.getContentPane().add(botonConvertir);

    // Creamos los campos de texto y los añadimos a la ventana.
    this.campoHoras = new JTextField("Horas...",10);
    this.campoMinutos = new JTextField("Minutos...", 10);
    this.campoSegundos = new JTextField("Segundos...", 10);
    this.ventana.getContentPane().add(this.campoHoras);
    this.ventana.getContentPane().add(this.campoMinutos);
    this.ventana.getContentPane().add(this.campoSegundos);

    // Creamos la etiqueta para el resultado y la añadimos a la ventana.
    this.etiquetaResultado = new JLabel("Resultado: xxxxxxxxxxxx segundos.");
    this.ventana.getContentPane().add(this.etiquetaResultado);

    // Asignamos la escucha de eventos a nuestra clase.
    this.botonConvertir.addActionListener(this);
    this.ventana.getContentPane().add(this.botonConvertir);

    // El programa debe terminar cuando cerramos la ventana.
    this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // El tamaño de la ventana se determina automáticamente.
    this.ventana.pack();

    // Se hace visible la ventana.
    this.ventana.setVisible(true);
  }

  // Método que convierte un número de horas, minutos y segundos a un total
  // acumulado de segundos.
  private int convertirASegundos(int horas, int minutos, int segundos) {
    return (horas * 3600) + (minutos * 60) + segundos;
  }
  
  // Listener para los eventos a los que está suscrita la clase.
  public void actionPerformed(ActionEvent e) {
    // Extraemos los valores en las entradas.
    int horasEntrada = Integer.parseInt(this.campoHoras.getText());
    int minutosEntrada = Integer.parseInt(this.campoMinutos.getText());
    int segundosEntrada = Integer.parseInt(this.campoSegundos.getText());

    // Calculamos el resultado.
    int resultadoEnSegundos = this.convertirASegundos(horasEntrada, minutosEntrada, segundosEntrada);

    // Mostramos el resultado en el label y en la terminal.
    this.etiquetaResultado.setText("Resultado: " + resultadoEnSegundos + " segundos.");
    System.out.println("La conversión de " + horasEntrada + " horas, " + minutosEntrada + " minutos y " + segundosEntrada + " segundos es: " + resultadoEnSegundos + " segundos.");
  }
  
  /**
   * Función principal del programa.
   */
  public static void main(String[] args) {
    new ConvertidorSegundos(); // Al instanciar la clase, se llama al constructor con las funciones para crear la ventana y demás.
  }
}

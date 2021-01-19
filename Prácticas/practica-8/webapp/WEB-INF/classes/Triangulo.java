
/**
 * Triangulo.java
 *
 * En este archivo se muestra la definición e implementación de la clase Triángulo que
 * representa un servlet en Java. La lógica de la práctica, así como la definición de
 * las operaciones se encuentran contenidas en este archivo.
 *
 * Diagrama UML:
 *
 * |------------------------------------------------|
 * |                    Triangulo                   |
 * |------------------------------------------------|
 * | int noRenglones                                |
 * |- - - - - - - - - - - - - - - - - - - - - - - - |
 * | doGet(HttpServletRequest, HttpServletResponse) |
 * |------------------------------------------------|
 *
 *
 * Datos:
 * ~ Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * ~ Grupo: 2CM1
 * ~ Práctica Número: 8
 * ~ Tema: Servlets.
 * ~ Opción: 2 "Triángulo"
 * ~ Fecha: 19 de Enero de 2020.
 * ~ Materia: Programación Orientada a Objetos.
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

// Clase Triángulo
public class Triangulo extends HttpServlet {
  private int noRenglones;

  // GET /
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // Imprimimos el .html
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    // Obtenemos el query parameter.
    try {
      String parametroStr = req.getParameter("renglones");
      noRenglones = Integer.parseInt(parametroStr);
    } catch (Exception e) {
      // Ignoramos la excepción, el default de renglones es 5.
      noRenglones = 5;
    }

    // Añadimos código HTML para la respuesta.
    out.println("<HTML>");
    out.println("<HEAD><TITLE>Triángulo</TITLE></HEAD>");
    out.println("<BODY>");
    out.println("<H1>Triángulo</H1>");

    // Realizamos la impresión del triángulo.
    for (int i = 0; i < noRenglones; i++) {
      for (int j = 0; j < i + 1; j++) {
        out.println("*");
      }
      out.println("<BR>");
    }

    // Cerramos HTML.
    out.println("<BR><BR><p>Humberto Alejandro Ortega Alcocer (2016630495)</p></BODY></HTML>");
  }

  // Para obtener información del Servlet.
  public String getServletInfo() {
    return "Servlet que muestra un triángulo";
  }
}

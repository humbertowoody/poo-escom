import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Red {
  private Socket cliente;
  private ObjectInputStream oisNet;
  private ObjectOutputStream oosNet;
  private int puerto = 5000;
  private String host = "localhost";
  private LeeRed lr;
  private Thread hiloLectura;

  public Red(LeeRed lr) {
    this.lr = lr;
    setUpNetworking();
  }

  public void setUpNetworking() {
    int i = 0;
    while (i == 0) {
      // System.out.println("Esperando por el servidor...");
      i = 1;
      try {
        cliente = new Socket(host, puerto);
      } catch (IOException e) {
        System.out.println("Fallo creación Socket");
        i = 0;
      }
    }
    // System.out.println("Conectado al servidor.");
    try {
      oosNet = getOOSNet(cliente.getOutputStream());
      oisNet = getOISNet(cliente.getInputStream());
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Error al crear los flujos de objeto: " + e);
    }
    hiloLectura = new Thread(new IncomingReader(lr, oisNet));
    hiloLectura.start();
  }

  public void escribeRed(Object obj) {
    try {
      oosNet.writeObject(obj);
      oosNet.flush();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  ObjectOutputStream getOOSNet(OutputStream os) throws IOException {
    return new ObjectOutputStream(os);
  }

  ObjectInputStream getOISNet(InputStream is) throws IOException {
    return new ObjectInputStream(is);
  }

  public void cerrarRed() {
    this.hiloLectura.stop();
  }
}

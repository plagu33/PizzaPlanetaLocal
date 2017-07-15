/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.mmerino.colas;

import cl.mmerino.clientelocal.Pizzeria;
import cl.mmerino.clientelocal.Pizzeria_Service;
import java.util.ArrayList;
import java.util.Arrays;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Basado en el ejemplo de hello world de Active MQ: http://activemq.apache.org/hello-world.html
 * @author Michel M. <michel@febos.cl>
 */
public class LecturaCliente implements Runnable {

    private static boolean servicioActivo;
    private static Thread brokerThread;
    
    public static void iniciarServicioCliente() {
        brokerThread = new Thread(new LecturaCliente());
        brokerThread.setDaemon(true);
        brokerThread.start();
        servicioActivo = true;
    }

    public static void deterServicioCliente() {
        servicioActivo = false;
        brokerThread.interrupt();
    }

    private static void leerCliente() {
        try {
            
            Pizzeria_Service service = new Pizzeria_Service();
            Pizzeria port = service.getPizzeriaPort();             

            // Crea la conexion a la cola de mensajes
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
            connectionFactory.setTrustedPackages(new ArrayList(Arrays.asList("cl.mmerino.colas".split(","))));
            Connection connection = connectionFactory.createConnection();
            connection.start();

            //connection.setExceptionListener(this);
            // Create una sesion en la cola AUTO_ACKNOWLEDGE->se lleva el mensaje y lo borra inmediatamente
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Lee (o Crea si no existe) una cola con un "topico" o "asunto" 
            Destination destination = session.createQueue("Cliente");

            // Crea un "consumer" es decir un "lector" de la cola
            MessageConsumer consumer = session.createConsumer(destination);

            // Espera hasta recibir un mensaje
            while (servicioActivo) { //mientras el servicio este activo, voy a escuchar por un mensaje
                
                Message message = consumer.receive(3000); //voy a esperar 1 segundo (1000 milisegundos) si es que llega un mensaje                                                

                if (message instanceof ObjectMessage && message!=null) {
                    
                    ObjectMessage obj = (ObjectMessage) message;
                    ColaCliente msje = (ColaCliente) obj.getObject();
                    
                    String nombre   = msje.nombre;
                    String rut      = msje.rut;
                    String telefono = msje.telefono;
                    String email    = msje.email;                    
                    
                    try {
                        port.crearCliente(nombre, rut, telefono, email);
                    } catch (Exception e) {
                        EscrituraCliente.enviarMensajeCliente(msje);
                    }
                    
                }
                
            }
            consumer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void run() {
        leerCliente();
    }
}

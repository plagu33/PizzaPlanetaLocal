/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.mmerino.colas;

import java.io.Serializable;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Basado en el ejemplo de hello world de Active MQ: http://activemq.apache.org/hello-world.html
 * @author Michel M. <michel@febos.cl>
 */
public class Escritura {

    public static void enviarMensaje(ColaVenta mensaje) {
        try {
            // Crea la conexion a la cola de mensajes
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Crea una sesion de conexion
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("PizzaPlaneta");

            // Lee (o Crea si no existe) una cola con un "topico" o "asunto" 
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Crea un mensaje de tipo TEXTO
            //TextMessage message = session.createTextMessage(mensaje);
            ObjectMessage message = session.createObjectMessage(mensaje);

            // Muestra por la consola que encio el mensaje
            //System.out.println("Mensaje enviado: " + message.hashCode());
            producer.send(message);           

            // Cierra la sesion
            session.close();
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

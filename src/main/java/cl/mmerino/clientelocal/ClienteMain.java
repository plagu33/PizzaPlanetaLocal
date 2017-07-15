/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.mmerino.clientelocal;

import cl.mmerino.colas.ColaVenta;
import cl.mmerino.colas.Escritura;
import cl.mmerino.colas.Lectura;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmerino
 */
public class ClienteMain {

    public static void main(String[] args) throws InterruptedException {
        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
        Pizzeria_Service service = new Pizzeria_Service();
        Pizzeria port = service.getPizzeriaPort(); 
        
        String idCliente = null;
       
        System.out.println("iniciando colas");
        Lectura.iniciarServicio();       
        
        while (!salir) {
            
            menu_principal();
            String telefonoCliente;
            
            try {

                System.out.println("Selecciona una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {    
                    case 1:
                        
                        System.out.println("Ingrese el número telefónico de cliente");                                                                               
                        
                        telefonoCliente = sn.next();
                        
                        Cliente buscarCLienteTelefono = null ;
                        
                        try {
                            buscarCLienteTelefono = port.buscarCLienteTelefono(telefonoCliente);    
                        } catch (Exception e) {
                            System.out.println("Error intentando conectarse con el ws");                                                                             
                            break;
                        }
                        
                        if( buscarCLienteTelefono==null ) {
                            System.out.println("No existe cliente");
                        }else{
                            
                            idCliente = buscarCLienteTelefono.idCliente;
                            
                            System.out.println("Cliente nombre :"+buscarCLienteTelefono.nombreCliente);                            
                            System.out.println("");
                            System.out.println("Listado de productos");
                            
                            try {
                                
                                List<Producto> a = port.listarProductos();
                                
                                for( Iterator<Producto> i = a.iterator(); i.hasNext(); ) {
                                    Producto item = i.next();
                                    System.out.println(item.codigo+". "+item.producto);
                                }
                                
                                System.out.println("Ingrese el producto");
                                String nuevoProducto = sn.next();
                                System.out.println("Ingrese la cantidad");
                                int nuevaCantidad = sn.nextInt();   
                                
                                String id_venta = UUID.randomUUID().toString();
                                
                                ColaVenta cv = new ColaVenta();
                                cv.setIdVenta(id_venta);
                                cv.setIdCliente(idCliente);
                                cv.setProducto(nuevoProducto);
                                cv.setCantidad(nuevaCantidad);                                
                                
                                Escritura.enviarMensaje(cv);
                                
                                System.out.println("");                                                                                                                                                                                                                                                
                                
                            } catch (ClassNotFoundException_Exception ex) {
                                Logger.getLogger(ClienteMain.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            
                        }
                        
                    break;
                    case 2:                        

                        System.out.println("Ingrese el nombre del cliente:");
                        String nombre_cliente = sn.next();
                        System.out.println("Ingrese el rut:");
                        String rut = sn.next();
                        System.out.println("Ingrese el teléfono:");
                        String telefono = sn.next();
                        System.out.println("Ingrese el email:");
                        String email = sn.next();
                        
                        idCliente = port.crearCliente(nombre_cliente, rut, telefono, email);
                        
                        System.out.println("Cliente creado con éxito. ("+idCliente+")");
                        
                    break;                    
                    case 0:
                        salir = true;
                    break;
                    default:
                        System.out.println("Opción no válida");                    
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida");
                sn.next();
            }

            
        }

    }    
    
    public static void menu_principal() {
        System.out.println("1. Venta");
        System.out.println("2. Crear Cliente");
        System.out.println("0. Salir");          
    }    

}
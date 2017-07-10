/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.mmerino.clientelocal;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mmerino
 */
public class ClienteMain {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
        String telefonoCliente = "";
        String idCliente       = "";
        
        String nombre_cliente  = "";
        String rut             = "";
        String telefono        = "";
        String email           = "";
        
        boolean datosCliente   = false;
        
        Pizzeria_Service service = new Pizzeria_Service();
        Pizzeria port = service.getPizzeriaPort();

        while (!salir) {

            System.out.println("1. Venta");
            //System.out.println("2. Opcion 2");
            System.out.println("0. Salir");

            try {

                System.out.println("Selecciona una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        
                        System.out.println("Has seleccionado la opcion Venta");                        
                        System.out.println("Ingrese el número telefónico de cliente");                        
                        
                        while (telefonoCliente=="") {
                            
                            telefonoCliente = sn.next();
                            
                            if(telefonoCliente!="") {
                                
                                //System.out.println("Ingreso el número "+telefonoCliente);   
                                
                                Cliente buscarCLienteTelefono = port.buscarCLienteTelefono(telefonoCliente);
                                
                                if( buscarCLienteTelefono==null ) {
                                    
                                    System.out.println("El Cliente ingresado no éxiste, ingrese los datos del nuevo cliente");
                                    
                                    telefonoCliente = "";
                                    
                                    while (!datosCliente) {
                                        
                                        System.out.println("Ingrese el nombre del cliente:");
                                        nombre_cliente = sn.next();
                                        System.out.println("Ingrese el rut:");
                                        rut = sn.next();
                                        System.out.println("Ingrese el teléfono:");
                                        telefono = sn.next();
                                        System.out.println("Ingrese el email:");
                                        email = sn.next();
                                        
                                        if(nombre_cliente!="" && rut!="" && telefono!="" && email!="") {

                                            idCliente = port.crearCliente(nombre_cliente, rut, telefono, email);
                                            System.out.println(idCliente);
                                            datosCliente = true;

                                        }
                                        
                                        break;   
                                        
                                    }
                                   
                                    
                                    
                                    
                                }else{
                                    idCliente = buscarCLienteTelefono.idCliente;
                                    System.out.println(idCliente);
                                    //aqui tengo el id del cliente, para guardarlo en la venta
                                    
                                }
                                
                            }
                            
                        }                                                                            
                        
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

        /*        

        Pizzeria_Service service = new Pizzeria_Service();
        Pizzeria port = service.getPizzeriaPort();

        String result = port.crearProducto("producto prueba 3",99,"aaaa 1",19990);
        System.out.println("Result = "+result);        

        */

    }

}
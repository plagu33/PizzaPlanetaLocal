
package cl.mmerino.clientelocal;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Pizzeria", targetNamespace = "http://ws.pizzaplaneta.cl/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Pizzeria {


    /**
     * 
     * @param codigo
     * @return
     *     returns cl.mmerino.clientelocal.Producto
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarProductoPorID", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.BuscarProductoPorID")
    @ResponseWrapper(localName = "buscarProductoPorIDResponse", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.BuscarProductoPorIDResponse")
    public Producto buscarProductoPorID(
        @WebParam(name = "codigo", targetNamespace = "")
        int codigo);

    /**
     * 
     * @param descripcion
     * @param codigo
     * @param precio
     * @param producto
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "crearProducto", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.CrearProducto")
    @ResponseWrapper(localName = "crearProductoResponse", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.CrearProductoResponse")
    public String crearProducto(
        @WebParam(name = "producto", targetNamespace = "")
        String producto,
        @WebParam(name = "codigo", targetNamespace = "")
        int codigo,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion,
        @WebParam(name = "precio", targetNamespace = "")
        int precio);

    /**
     * 
     * @param idInternoClte
     * @param idVenta
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "venta", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.Venta")
    @ResponseWrapper(localName = "ventaResponse", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.VentaResponse")
    public String venta(
        @WebParam(name = "id_interno_clte", targetNamespace = "")
        String idInternoClte,
        @WebParam(name = "id_venta", targetNamespace = "")
        String idVenta);

    /**
     * 
     * @param idInternoClte
     * @return
     *     returns cl.mmerino.clientelocal.Cliente
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarCLientePorID", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.BuscarCLientePorID")
    @ResponseWrapper(localName = "buscarCLientePorIDResponse", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.BuscarCLientePorIDResponse")
    public Cliente buscarCLientePorID(
        @WebParam(name = "id_interno_clte", targetNamespace = "")
        String idInternoClte);

    /**
     * 
     * @param rut
     * @param nombreCliente
     * @param telefono
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "crearCliente", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.CrearCliente")
    @ResponseWrapper(localName = "crearClienteResponse", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.CrearClienteResponse")
    public String crearCliente(
        @WebParam(name = "nombre_cliente", targetNamespace = "")
        String nombreCliente,
        @WebParam(name = "rut", targetNamespace = "")
        String rut,
        @WebParam(name = "telefono", targetNamespace = "")
        String telefono,
        @WebParam(name = "email", targetNamespace = "")
        String email);

    /**
     * 
     * @param nombreCliente
     * @return
     *     returns cl.mmerino.clientelocal.Cliente
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarCLientePorNombre", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.BuscarCLientePorNombre")
    @ResponseWrapper(localName = "buscarCLientePorNombreResponse", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.BuscarCLientePorNombreResponse")
    public Cliente buscarCLientePorNombre(
        @WebParam(name = "nombre_cliente", targetNamespace = "")
        String nombreCliente);

    /**
     * 
     * @param cantidad
     * @param codigoProducto
     * @param idVenta
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "detalleVenta", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.DetalleVenta")
    @ResponseWrapper(localName = "detalleVentaResponse", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.DetalleVentaResponse")
    public String detalleVenta(
        @WebParam(name = "id_venta", targetNamespace = "")
        String idVenta,
        @WebParam(name = "codigo_producto", targetNamespace = "")
        String codigoProducto,
        @WebParam(name = "cantidad", targetNamespace = "")
        int cantidad);

    /**
     * 
     * @param producto
     * @return
     *     returns cl.mmerino.clientelocal.Producto
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarProductoNombre", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.BuscarProductoNombre")
    @ResponseWrapper(localName = "buscarProductoNombreResponse", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.BuscarProductoNombreResponse")
    public Producto buscarProductoNombre(
        @WebParam(name = "producto", targetNamespace = "")
        String producto);

    /**
     * 
     * @param telefono
     * @return
     *     returns cl.mmerino.clientelocal.Cliente
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarCLienteTelefono", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.BuscarCLienteTelefono")
    @ResponseWrapper(localName = "buscarCLienteTelefonoResponse", targetNamespace = "http://ws.pizzaplaneta.cl/", className = "cl.mmerino.clientelocal.BuscarCLienteTelefonoResponse")
    public Cliente buscarCLienteTelefono(
        @WebParam(name = "telefono", targetNamespace = "")
        String telefono);

}

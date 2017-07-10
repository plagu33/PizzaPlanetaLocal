
package cl.mmerino.clientelocal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para buscarCLientePorID complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="buscarCLientePorID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_interno_clte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarCLientePorID", propOrder = {
    "idInternoClte"
})
public class BuscarCLientePorID {

    @XmlElement(name = "id_interno_clte")
    protected String idInternoClte;

    /**
     * Obtiene el valor de la propiedad idInternoClte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdInternoClte() {
        return idInternoClte;
    }

    /**
     * Define el valor de la propiedad idInternoClte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdInternoClte(String value) {
        this.idInternoClte = value;
    }

}

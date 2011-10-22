package fr.univ_lyon1.master_info.m2ti.tiw5.services;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.3
 * 2011-10-22T19:06:14.560+02:00
 * Generated source version: 2.4.3
 * 
 */
@WebService(targetNamespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", name = "StockPortType")
@XmlSeeAlso({fr.univ_lyon1.master_info.m2ti.tiw5.ventecd.ObjectFactory.class, ObjectFactory.class})
public interface StockPortType {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "disponible", targetNamespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", className = "fr.univ_lyon1.master_info.m2ti.tiw5.services.Disponible")
    @WebMethod
    @ResponseWrapper(localName = "disponibleResponse", targetNamespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", className = "fr.univ_lyon1.master_info.m2ti.tiw5.services.DisponibleResponse")
    public java.lang.Boolean disponible(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @Oneway
    @RequestWrapper(localName = "commande", targetNamespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", className = "fr.univ_lyon1.master_info.m2ti.tiw5.services.Commande")
    @WebMethod
    public void commande(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "assureCapacite", targetNamespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", className = "fr.univ_lyon1.master_info.m2ti.tiw5.services.AssureCapacite")
    @WebMethod
    @ResponseWrapper(localName = "assureCapaciteResponse", targetNamespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", className = "fr.univ_lyon1.master_info.m2ti.tiw5.services.AssureCapaciteResponse")
    public java.lang.Boolean assureCapacite(
        @WebParam(name = "arg0", targetNamespace = "")
        fr.univ_lyon1.master_info.m2ti.tiw5.services.CoupleAlbumQuantite arg0
    );
}

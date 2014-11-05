
package at.technikumwien.sks.generated;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BookSOAPWebService", targetNamespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BookSOAPWebService {


    /**
     * 
     * @param arg0
     * @throws SOAPException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "importBooks", targetNamespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", className = "at.technikumwien.sks.generated.ImportBooks")
    @ResponseWrapper(localName = "importBooksResponse", targetNamespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", className = "at.technikumwien.sks.generated.ImportBooksResponse")
    public void importBooks(
        @WebParam(name = "arg0", targetNamespace = "")
        List<Book> arg0)
        throws SOAPException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<at.technikumwien.sks.generated.BookDto>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllBookDtos", targetNamespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", className = "at.technikumwien.sks.generated.GetAllBookDtos")
    @ResponseWrapper(localName = "getAllBookDtosResponse", targetNamespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", className = "at.technikumwien.sks.generated.GetAllBookDtosResponse")
    public List<BookDto> getAllBookDtos();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<at.technikumwien.sks.generated.Book>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findBooksByTitle", targetNamespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", className = "at.technikumwien.sks.generated.FindBooksByTitle")
    @ResponseWrapper(localName = "findBooksByTitleResponse", targetNamespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", className = "at.technikumwien.sks.generated.FindBooksByTitleResponse")
    public List<Book> findBooksByTitle(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
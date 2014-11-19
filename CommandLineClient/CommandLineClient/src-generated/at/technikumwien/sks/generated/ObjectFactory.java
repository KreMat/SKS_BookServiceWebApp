
package at.technikumwien.sks.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.technikumwien.sks.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllBookDtosResponse_QNAME = new QName("http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", "getAllBookDtosResponse");
    private final static QName _ImportBooks_QNAME = new QName("http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", "importBooks");
    private final static QName _GetAllBookDtos_QNAME = new QName("http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", "getAllBookDtos");
    private final static QName _Book_QNAME = new QName("http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", "book");
    private final static QName _SOAPException_QNAME = new QName("http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", "SOAPException");
    private final static QName _Author_QNAME = new QName("http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", "author");
    private final static QName _ImportBooksResponse_QNAME = new QName("http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", "importBooksResponse");
    private final static QName _Publisher_QNAME = new QName("http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", "publisher");
    private final static QName _FindBooksByTitle_QNAME = new QName("http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", "findBooksByTitle");
    private final static QName _FindBooksByTitleResponse_QNAME = new QName("http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", "findBooksByTitleResponse");
    private final static QName _BookDto_QNAME = new QName("http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", "bookDto");
    private final static QName _SOAPExceptionMessage_QNAME = new QName("", "message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.technikumwien.sks.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link GetAllBookDtos }
     * 
     */
    public GetAllBookDtos createGetAllBookDtos() {
        return new GetAllBookDtos();
    }

    /**
     * Create an instance of {@link GetAllBookDtosResponse }
     * 
     */
    public GetAllBookDtosResponse createGetAllBookDtosResponse() {
        return new GetAllBookDtosResponse();
    }

    /**
     * Create an instance of {@link ImportBooks }
     * 
     */
    public ImportBooks createImportBooks() {
        return new ImportBooks();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link SOAPException }
     * 
     */
    public SOAPException createSOAPException() {
        return new SOAPException();
    }

    /**
     * Create an instance of {@link Publisher }
     * 
     */
    public Publisher createPublisher() {
        return new Publisher();
    }

    /**
     * Create an instance of {@link ImportBooksResponse }
     * 
     */
    public ImportBooksResponse createImportBooksResponse() {
        return new ImportBooksResponse();
    }

    /**
     * Create an instance of {@link BookDto }
     * 
     */
    public BookDto createBookDto() {
        return new BookDto();
    }

    /**
     * Create an instance of {@link FindBooksByTitleResponse }
     * 
     */
    public FindBooksByTitleResponse createFindBooksByTitleResponse() {
        return new FindBooksByTitleResponse();
    }

    /**
     * Create an instance of {@link FindBooksByTitle }
     * 
     */
    public FindBooksByTitle createFindBooksByTitle() {
        return new FindBooksByTitle();
    }

    /**
     * Create an instance of {@link Book.Authors }
     * 
     */
    public Book.Authors createBookAuthors() {
        return new Book.Authors();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBookDtosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", name = "getAllBookDtosResponse")
    public JAXBElement<GetAllBookDtosResponse> createGetAllBookDtosResponse(GetAllBookDtosResponse value) {
        return new JAXBElement<GetAllBookDtosResponse>(_GetAllBookDtosResponse_QNAME, GetAllBookDtosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", name = "importBooks")
    public JAXBElement<ImportBooks> createImportBooks(ImportBooks value) {
        return new JAXBElement<ImportBooks>(_ImportBooks_QNAME, ImportBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBookDtos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", name = "getAllBookDtos")
    public JAXBElement<GetAllBookDtos> createGetAllBookDtos(GetAllBookDtos value) {
        return new JAXBElement<GetAllBookDtos>(_GetAllBookDtos_QNAME, GetAllBookDtos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", name = "book")
    public JAXBElement<Book> createBook(Book value) {
        return new JAXBElement<Book>(_Book_QNAME, Book.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOAPException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", name = "SOAPException")
    public JAXBElement<SOAPException> createSOAPException(SOAPException value) {
        return new JAXBElement<SOAPException>(_SOAPException_QNAME, SOAPException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Author }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", name = "author")
    public JAXBElement<Author> createAuthor(Author value) {
        return new JAXBElement<Author>(_Author_QNAME, Author.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", name = "importBooksResponse")
    public JAXBElement<ImportBooksResponse> createImportBooksResponse(ImportBooksResponse value) {
        return new JAXBElement<ImportBooksResponse>(_ImportBooksResponse_QNAME, ImportBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Publisher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", name = "publisher")
    public JAXBElement<Publisher> createPublisher(Publisher value) {
        return new JAXBElement<Publisher>(_Publisher_QNAME, Publisher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBooksByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", name = "findBooksByTitle")
    public JAXBElement<FindBooksByTitle> createFindBooksByTitle(FindBooksByTitle value) {
        return new JAXBElement<FindBooksByTitle>(_FindBooksByTitle_QNAME, FindBooksByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBooksByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", name = "findBooksByTitleResponse")
    public JAXBElement<FindBooksByTitleResponse> createFindBooksByTitleResponse(FindBooksByTitleResponse value) {
        return new JAXBElement<FindBooksByTitleResponse>(_FindBooksByTitleResponse_QNAME, FindBooksByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/", name = "bookDto")
    public JAXBElement<BookDto> createBookDto(BookDto value) {
        return new JAXBElement<BookDto>(_BookDto_QNAME, BookDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "message", scope = SOAPException.class)
    public JAXBElement<String> createSOAPExceptionMessage(String value) {
        return new JAXBElement<String>(_SOAPExceptionMessage_QNAME, String.class, SOAPException.class, value);
    }

}

package pl.sda.intermediate12.products;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JDOMToJavaWithJAXBReader {
    @Autowired
    ProductDAO productDAO;

    public static final String PRODUCTS_DATA_TXT = "c:/projects/books.xml";
    private File file = new File(PRODUCTS_DATA_TXT);


    public List<Product> readProductsListFromFile() {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document doc = saxBuilder.build(file);
            Element classElement = doc.getRootElement();

            List<Element> elements = classElement.getChildren("book");
            List<Product> products = new ArrayList<Product>();

            for (Element element : elements) {
                Product prod = new Product();
                prod.setId(element.getAttributeValue("id"));
                prod.setAuthor(element.getChildText("author"));
                prod.setDescription(((element.getChildText("description")).replace("\n","")).replaceAll("( )+", " "));
                prod.setGenre(element.getChildText("genre"));
                prod.setPrice(new BigDecimal(element.getChildText("price").replaceAll(",", "")));

                prod.setPublish_date(element.getChildText("publish_date"));

                prod.setTitle(element.getChildText("title"));

//                prod.setPublish_date(element.getChildText("publih_date"));
                products.add(prod);
            }
            return products;
        } catch (JDOMException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void copyReadedListFromFileToProductDao() {
        productDAO.createProductListFromFile(readProductsListFromFile());
    }

    public Product readObjectFromFile() {
        try {
            JAXBContext jc = JAXBContext.newInstance(Product.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Product product = (Product) unmarshaller.unmarshal(new File("c:/projects/book.xml"));
            return product;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}

package pl.sda.intermediate12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.intermediate12.products.Product;
import pl.sda.intermediate12.products.ProductDAO;
import pl.sda.intermediate12.products.JDOMToJavaWithJAXBReader;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class XMLListReaderTest {

    @Test
    public void testIfListIsCreatedProperly() throws ParseException {
        JDOMToJavaWithJAXBReader reader = new JDOMToJavaWithJAXBReader();
        ProductDAO productDAO = new ProductDAO();
        productDAO.createProductListFromFile(reader.readProductsListFromFile());


        List<Product> testProductList = productDAO.getProductsList();
        Product testProd = new Product();
        testProd.setAuthor("Gambardella, Matthew");
        testProd.setDescription("An in-depth look at creating applications with XML.");
        testProd.setGenre("Computer");
        testProd.setId("bk101");
        testProd.setPrice(BigDecimal.valueOf(44.95));
        testProd.setPublish_date("2000-10-01");
        testProd.setTitle("XML Developer's Guide");
//        System.out.println(testProd.getDescription());
//        System.out.println(testProductList.get(0).getDescription());
        Assertions.assertEquals(testProd.toString(), testProductList.get(0).toString());

    }

    @Test
    public void testIfBookIsCreatedOkFromFile() {
        JDOMToJavaWithJAXBReader JDOMToJavaWithJAXBReader = new JDOMToJavaWithJAXBReader();

        Product product1 = JDOMToJavaWithJAXBReader.readObjectFromFile();
        System.out.println(product1);

    }
}

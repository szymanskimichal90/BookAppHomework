package pl.sda.intermediate12;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.intermediate12.products.Product;
import pl.sda.intermediate12.products.ProductDAO;
import pl.sda.intermediate12.products.XMLToJavaWithJAXBReader;

import java.util.ArrayList;
import java.util.List;
public class XMLListReaderTest {

    @Test
    public void testIfListIsCreatedProperly() {
XMLToJavaWithJAXBReader reader = new XMLToJavaWithJAXBReader();
ProductDAO productDAO = new ProductDAO();
      reader.readProductsListFromFile();

      List<Product>  testProductList = productDAO.getProductsList();


        for (Product product : testProductList) {
            System.out.println(product);

        }
    }

    @Test
    public void testIfBookIsCreatedOkFromFile() {
        XMLToJavaWithJAXBReader XMLToJavaWithJAXBReader = new XMLToJavaWithJAXBReader();

        Product product1 = XMLToJavaWithJAXBReader.readObjectFromFile();
        System.out.println(product1);

    }
}

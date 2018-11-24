package pl.sda.intermediate12.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDAO  {


    private List<Product> productsList = new ArrayList<>();


    public List<Product> getProductsList() {
        return productsList;
    }


    public void createProductListFromFile
            (List<Product> productsList) {
        this.productsList = productsList;
    }



}

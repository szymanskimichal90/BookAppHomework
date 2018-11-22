package pl.sda.intermediate12.products;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@XmlRootElement(name = "book")
public class Product  {

    private String id;


    private String author;
    private String title;
    private String genre;
    private BigDecimal price;
    private Date publish_date;
    private String description;


    public String getId() {
        return id;
    }


//opcjonalnie
//    private String additionalInfo;

    //te wartości można dobrać losowo
//    private Integer stockAmount;






    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", publish_date=" + publish_date +
                ", description='" + description + '\'' +
                '}';
    }
}


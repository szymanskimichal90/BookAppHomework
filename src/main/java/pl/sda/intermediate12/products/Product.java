package pl.sda.intermediate12.products;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Setter
@Getter
@XmlRootElement(name = "book")
//@Builder
public class Product  {

    private String id;


    private String author;
    private String title;
    private String genre;
    private BigDecimal price;
    private String publish_date;
    private String description;

    public Product() {

    }


    public String getId() {
        return id;
    }


//opcjonalnie
//    private String additionalInfo;

    //te wartości można dobrać losowo
//    private Integer stockAmount;


    public Product(String id, String author, String title, String genre, BigDecimal price, String publish_date, String description) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publish_date = publish_date;
        this.description = description;
    }

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


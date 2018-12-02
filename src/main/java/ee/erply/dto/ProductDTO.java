package ee.erply.dto;

import javax.validation.constraints.Size;

public class ProductDTO {

    String name;

    double price;

    public ProductDTO() {
    }

    public ProductDTO(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}

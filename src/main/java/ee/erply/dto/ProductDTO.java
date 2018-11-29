package ee.erply.dto;

import javax.validation.constraints.Size;

public class ProductDTO {

    @Size(min = 1, max = 50)
    String name;

    @Size(min = 16, max = 16, message = "Kuupäev peab olema 16 tähemärki pikk")
    Long price;

    public ProductDTO() {
    }

    public ProductDTO(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}

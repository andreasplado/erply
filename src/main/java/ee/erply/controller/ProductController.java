package ee.erply.controller;

import ee.erply.dao.entity.ProductEntity;
import ee.erply.dto.ProductDTO;
import ee.erply.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController extends WebMvcConfigurerAdapter {

    @Autowired
    private ProductService productService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductEntity>> all() {

        List<ProductEntity> products = productService.getAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> findById(@PathVariable("id") Integer id) {

        ProductEntity productFound = productService.findById(id);
        if (productFound == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(productFound, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity product) {

        ProductEntity productSaved = productService.addProduct(product);

        return new ResponseEntity<>(productSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Integer id, @RequestBody ProductEntity productEntity){
        productService.updateProduct(productEntity, id);
        System.out.println(id);

        return new ResponseEntity<>(productEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductEntity> removeProduct(@PathVariable("id") Integer id) {

        ProductEntity productFound = productService.findById(id);
        if (productFound == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        productService.deleteProduct(productFound);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

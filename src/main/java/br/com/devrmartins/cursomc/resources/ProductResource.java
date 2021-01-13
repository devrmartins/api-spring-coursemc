package br.com.devrmartins.cursomc.resources;

import br.com.devrmartins.cursomc.dao.ProductDTO;
import br.com.devrmartins.cursomc.domains.Product;
import br.com.devrmartins.cursomc.services.ProductService;
import org.apache.coyote.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> list() {
        List<Product> products = productService.list();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ProductDTO productDTO) {
        JSONObject resp = new JSONObject();
        try {
            Product product = productService.save(productDTO);
            resp.put("id",product.getId());
            return new ResponseEntity<String>(resp.toString(), HttpStatus.CREATED);
        } catch(Exception ex) {
            resp.put("error",ex.getMessage());
            return new ResponseEntity<String>(resp.toString(), HttpStatus.CONFLICT);
        }
    }
}

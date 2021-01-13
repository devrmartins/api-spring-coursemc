package br.com.devrmartins.cursomc.services;

import br.com.devrmartins.cursomc.dao.ProductDTO;
import br.com.devrmartins.cursomc.domains.Category;
import br.com.devrmartins.cursomc.domains.Product;
import br.com.devrmartins.cursomc.repositorys.CategoryRepository;
import br.com.devrmartins.cursomc.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product save(ProductDTO productDTO) {
        List<Category> categories = categoryRepository.findAllById(productDTO.getCategories());

        if (categories.isEmpty()) {
            throw new DataIntegrityViolationException("Register at least one category for a product");
        }

        Optional<Product> existProduct = productRepository.findOneByName(productDTO.getName());

        if (existProduct.isPresent()) {
            throw new DataIntegrityViolationException("Product exists");
        }

        Product product = new Product(productDTO.getName(),productDTO.getPrice());
        product.setCategories(categories);
        return productRepository.save(product);
    }

}

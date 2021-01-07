package br.com.devrmartins.cursomc.resources;

import br.com.devrmartins.cursomc.domains.Category;
import br.com.devrmartins.cursomc.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> list() {
        List<Category> categories = categoryService.list();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> show(@PathVariable Integer id) {
        Category category = categoryService.show(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}

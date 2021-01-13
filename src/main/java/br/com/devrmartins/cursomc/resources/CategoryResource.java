package br.com.devrmartins.cursomc.resources;

import br.com.devrmartins.cursomc.domains.Category;
import br.com.devrmartins.cursomc.services.CategoryService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Category category) {
        JSONObject resp = new JSONObject();
        try {
            Category categorySaved = categoryService.save(category);
            resp.put("id",categorySaved.getId());
            return new ResponseEntity<String>(resp.toString(), HttpStatus.CREATED);
        } catch (Exception ex) {
            resp.put("error","Category exists");
            return new ResponseEntity<String>(resp.toString(), HttpStatus.CONFLICT);
        }
    }
}

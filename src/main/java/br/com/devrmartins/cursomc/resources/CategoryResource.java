package br.com.devrmartins.cursomc.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
    @GetMapping
    public ResponseEntity<String> list() {
        return new ResponseEntity<>("Categories", HttpStatus.OK);
    }
}

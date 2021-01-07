package br.com.devrmartins.cursomc.resources;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class MainResource {
    @GetMapping
    public ResponseEntity<String> hello() {
        JSONObject resp = new JSONObject();
        resp.put("message","Welcome to the Spring API");
        return new ResponseEntity<String>(resp.toString(), HttpStatus.OK);
    }
}

package br.com.devrmartins.cursomc.services;

import br.com.devrmartins.cursomc.domains.Category;
import br.com.devrmartins.cursomc.repositorys.CategoryRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepo;

    public List<Category> list() {
        return this.categoryRepo.findAll();
    }

    public Category show(Integer id) {
        Optional<Category> cat =  this.categoryRepo.findById(id);
        return cat.orElse(null);
    }

    public Category save(Category category) throws Exception {
        Optional<Category> catExist = this.categoryRepo.findByName(category.getName());
        if (catExist.isPresent()) throw new Exception("Category exists");
        return this.categoryRepo.save(category);
    }
}

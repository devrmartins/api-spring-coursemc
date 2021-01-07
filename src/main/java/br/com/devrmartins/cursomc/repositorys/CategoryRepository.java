package br.com.devrmartins.cursomc.repositorys;

import br.com.devrmartins.cursomc.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

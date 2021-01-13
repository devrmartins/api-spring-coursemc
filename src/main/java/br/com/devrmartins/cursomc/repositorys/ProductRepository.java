package br.com.devrmartins.cursomc.repositorys;

import br.com.devrmartins.cursomc.domains.Category;
import br.com.devrmartins.cursomc.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT DISTINCT p.name FROM Product p WHERE p.name = ?1")
    Optional<Product> findOneByName(String name);
}

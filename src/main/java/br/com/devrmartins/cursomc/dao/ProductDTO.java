package br.com.devrmartins.cursomc.dao;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private String name;
    private Double price;
    private List<Integer> categories = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }
}

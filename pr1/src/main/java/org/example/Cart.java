package org.example;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> searchProductsByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Product> searchProductsByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public void clear() {
        products.clear();
    }
}


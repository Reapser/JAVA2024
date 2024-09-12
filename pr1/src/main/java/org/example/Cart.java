package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private List<Product> products = new ArrayList<>();

    // Метод для додавання товару в кошик
    public void addProduct(Product product) {
        products.add(product);
    }

    // Метод для видалення товару з кошика
    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Метод для отримання загальної вартості товарів у кошику
    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Метод для отримання копії списку товарів
    public List<Product> getProducts() {
        return new ArrayList<>(products); // Повертаємо копію списку, щоб запобігти змінам ззовні
    }

    // Метод для очищення кошика
    public void clear() {
        products.clear(); // Очищення списку товарів у кошику
    }

    // Пошук товару за назвою
    public List<Product> searchProductsByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Пошук товару за категорією
    public List<Product> searchProductsByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Кошик містить:\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        sb.append("Загальна вартість: ").append(getTotalPrice());
        return sb.toString();
    }
}

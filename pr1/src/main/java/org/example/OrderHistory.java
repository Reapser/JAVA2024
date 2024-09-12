package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<List<Product>> orderHistory = new ArrayList<>();

    // Метод для додавання нового замовлення до історії
    public void addOrder(List<Product> products) {
        orderHistory.add(new ArrayList<>(products)); // Додаємо копію замовлення
    }

    // Метод для перегляду історії замовлень
    public List<List<Product>> getOrderHistory() {
        return new ArrayList<>(orderHistory); // Повертаємо копію списку замовлень
    }

    // Виведення історії замовлень у форматованому вигляді
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Історія замовлень:\n");
        for (int i = 0; i < orderHistory.size(); i++) {
            sb.append("Замовлення ").append(i + 1).append(":\n");
            for (Product product : orderHistory.get(i)) {
                sb.append(product.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}

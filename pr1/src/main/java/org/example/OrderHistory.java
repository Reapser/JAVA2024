package org.example;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class OrderHistory {
    private List<List<Product>> orderHistory = new ArrayList<>();

    public void addOrder(List<Product> products) {
        orderHistory.add(new ArrayList<>(products));
    }

    public List<List<Product>> getOrderHistory() {
        return new ArrayList<>(orderHistory);
    }
}


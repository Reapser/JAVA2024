package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Оголошення категорій
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        // Оголошення товарів
        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        // Мапа товарів для зручного доступу по ID
        Map<Integer, Product> productsMap = new HashMap<>();
        productsMap.put(product1.getId(), product1);
        productsMap.put(product2.getId(), product2);
        productsMap.put(product3.getId(), product3);

        // Створення кошика та історії замовлень
        Cart cart = new Cart();
        OrderHistory orderHistory = new OrderHistory();

        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Видалити товар з кошика");
            System.out.println("4 - Переглянути кошик");
            System.out.println("5 - Зробити замовлення");
            System.out.println("6 - Переглянути історію замовлень");
            System.out.println("7 - Пошук товару за категорією");
            System.out.println("0 - Вийти");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Очищуємо буфер

                switch (choice) {
                    case 1:
                        productsMap.values().forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("Введіть ID товару для додавання до кошика:");
                        int id = scanner.nextInt();
                        Product productToAdd = productsMap.get(id);
                        if (productToAdd != null) {
                            cart.addProduct(productToAdd);
                            System.out.println("Товар додано до кошика.");
                        } else {
                            System.out.println("Товар з таким ID не знайдено.");
                        }
                        break;
                    case 3:
                        System.out.println("Введіть ID товару для видалення з кошика:");
                        id = scanner.nextInt();
                        Product productToRemove = productsMap.get(id);
                        if (productToRemove != null) {
                            cart.removeProduct(productToRemove);
                            System.out.println("Товар видалено з кошика.");
                        } else {
                            System.out.println("Товар з таким ID не знайдено.");
                        }
                        break;
                    case 4:
                        System.out.println(cart);
                        break;
                    case 5:
                        if (cart.getProducts().isEmpty()) {
                            System.out.println("Ваш кошик порожній.");
                        } else {
                            System.out.println("Замовлення оформлено!");
                            orderHistory.addOrder(cart.getProducts()); // Зберігаємо замовлення
                            cart.clear(); // Очищення кошика після замовлення
                        }
                        break;
                    case 6:
                        System.out.println(orderHistory);
                        break;
                    case 7:
                        System.out.println("Введіть категорію для пошуку:");
                        System.out.println("1 - Електроніка, 2 - Смартфони, 3 - Аксесуари");

                        int categoryId = scanner.nextInt();
                        Category category = null;

                        switch (categoryId) {
                            case 1 -> category = electronics;
                            case 2 -> category = smartphones;
                            case 3 -> category = accessories;
                        }

                        if (category != null) {
                            System.out.println(cart.searchProductsByCategory(category));
                        } else {
                            System.out.println("Категорія не знайдена.");
                        }
                        break;
                    case 0:
                        System.out.println("Дякуємо, що використовували наш магазин!");
                        return;
                    default:
                        System.out.println("Невідома опція. Спробуйте ще раз.");
                }
            } catch (Exception e) {
                System.out.println("Невірне введення. Спробуйте ще раз.");
                scanner.nextLine(); // Очищуємо буфер для введення користувачем
            }
        }
    }
}


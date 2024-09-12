package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Оголошення товарів і категорій
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

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
            System.out.println("7 - Пошук товару за назвою");
            System.out.println("8 - Пошук товару за категорією");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    if (id == 1) cart.addProduct(product1);
                    else if (id == 2) cart.addProduct(product2);
                    else if (id == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 3:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    id = scanner.nextInt();
                    if (id == 1) cart.removeProduct(product1);
                    else if (id == 2) cart.removeProduct(product2);
                    else if (id == 3) cart.removeProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 4:
                    System.out.println(cart);
                    break;
                case 5:
                    System.out.println("Замовлення оформлено!");
                    orderHistory.addOrder(cart.getProducts()); // Зберігаємо замовлення
                    cart.clear(); // Очищення кошика після замовлення
                    break;
                case 6:
                    System.out.println(orderHistory);
                    break;
                case 7:
                    System.out.println("Введіть назву товару для пошуку:");
                    scanner.nextLine(); // Очистка буфера
                    String name = scanner.nextLine();
                    System.out.println(cart.searchProductsByName(name));
                    break;
                case 8:
                    System.out.println("Введіть категорію для пошуку:");
                    System.out.println("1 - Електроніка, 2 - Смартфони, 3 - Аксесуари");
                    int categoryId = scanner.nextInt();
                    Category category = null;
                    if (categoryId == 1) category = electronics;
                    else if (categoryId == 2) category = smartphones;
                    else if (categoryId == 3) category = accessories;

                    if (category != null) {
                        System.out.println(cart.searchProductsByCategory(category));
                    } else {
                        System.out.println("Категорія не знайдена");
                    }
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }
}

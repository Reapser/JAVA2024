package org.example;

public class Category {
    private int id;
    private String name;

    // Конструктор класу
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Геттери та сеттери
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Категорія{" +
                "id=" + id +
                ", назва='" + name + '\'' +
                '}';
    }
}


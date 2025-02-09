package kz.aitu.oop.Kassymgali_Bakytzhan.RestaurantManagement.models;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    public MenuItem() {}

    // ✅ Добавленный конструктор с id
    public MenuItem(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // ✅ Оставляем старый конструктор (без id) для создания новых объектов
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

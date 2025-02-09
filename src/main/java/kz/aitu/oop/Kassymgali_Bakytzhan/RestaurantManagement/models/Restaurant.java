package kz.aitu.oop.Kassymgali_Bakytzhan.RestaurantManagement.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<MenuItem> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void addMenuItem(MenuItem menuItem) {
        menu.add(menuItem);
    }

    public List<MenuItem> getMenu() { return menu; }
}

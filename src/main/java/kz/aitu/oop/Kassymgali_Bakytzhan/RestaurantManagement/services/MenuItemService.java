package kz.aitu.oop.Kassymgali_Bakytzhan.RestaurantManagement.services;

import kz.aitu.oop.Kassymgali_Bakytzhan.RestaurantManagement.models.MenuItem;
import kz.aitu.oop.Kassymgali_Bakytzhan.RestaurantManagement.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {

    private final MenuItemRepository repository;

    @Autowired
    public MenuItemService(MenuItemRepository repository) {
        this.repository = repository;
    }


    public List<MenuItem> getAllMenuItems() {
        return repository.findAll();
    }

    public Optional<MenuItem> getMenuItemById(Long id) {
        return repository.findById(id);
    }

    public MenuItem addMenuItem(MenuItem menuItem) {
        return repository.save(menuItem);
    }


    public MenuItem updateMenuItem(Long id, MenuItem updatedMenuItem) {
        return repository.findById(id).map(menuItem -> {
            menuItem.setName(updatedMenuItem.getName());
            menuItem.setPrice(updatedMenuItem.getPrice());
            return repository.save(menuItem);
        }).orElseThrow(() -> new RuntimeException("Меню с ID " + id + " не найдено"));
    }


    public void deleteMenuItem(Long id) {
        repository.deleteById(id);
    }
}

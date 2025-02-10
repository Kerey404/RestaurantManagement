package kz.aitu.oop.Kassymgali_Bakytzhan.RestaurantManagement.controllers;

import kz.aitu.oop.Kassymgali_Bakytzhan.RestaurantManagement.models.MenuItem;
import kz.aitu.oop.Kassymgali_Bakytzhan.RestaurantManagement.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuItemController {

    private final MenuItemService service;

    @Autowired
    public MenuItemController(MenuItemService service) {
        this.service = service;
    }

    
    @GetMapping("/all")
    public List<MenuItem> getAllMenuItems() {
        return service.getAllMenuItems();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        Optional<MenuItem> menuItem = service.getMenuItemById(id);
        return menuItem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    @PostMapping("/add")
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
        MenuItem savedMenuItem = service.addMenuItem(menuItem);
        return ResponseEntity.ok(savedMenuItem);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem updatedMenuItem) {
        try {
            MenuItem updated = service.updateMenuItem(id, updatedMenuItem);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        service.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}

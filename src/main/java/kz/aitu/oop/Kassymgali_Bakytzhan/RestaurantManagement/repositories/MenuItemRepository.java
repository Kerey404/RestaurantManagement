package kz.aitu.oop.Kassymgali_Bakytzhan.RestaurantManagement.repositories;

import kz.aitu.oop.Kassymgali_Bakytzhan.RestaurantManagement.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}

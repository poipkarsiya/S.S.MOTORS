
package com.garage.garagemanagementsystem.repository;

import com.garage.garagemanagementsystem.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
package com.garage.garagemanagementsystem.repository;

import com.garage.garagemanagementsystem.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
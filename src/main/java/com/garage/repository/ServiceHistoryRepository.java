package com.garage.garagemanagementsystem.repository;

import com.garage.garagemanagementsystem.entity.ServiceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceHistoryRepository
        extends JpaRepository<ServiceHistory, Long> {
}
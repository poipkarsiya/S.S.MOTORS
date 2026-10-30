package com.garage.garagemanagementsystem.repository;

import com.garage.garagemanagementsystem.entity.ServiceBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceBookingRepository
        extends JpaRepository<ServiceBooking, Long> {
}
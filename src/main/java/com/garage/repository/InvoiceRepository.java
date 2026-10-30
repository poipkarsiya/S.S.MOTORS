package com.garage.garagemanagementsystem.repository;

import com.garage.garagemanagementsystem.entity.Invoice;
import com.garage.garagemanagementsystem.repository.InvoiceRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}

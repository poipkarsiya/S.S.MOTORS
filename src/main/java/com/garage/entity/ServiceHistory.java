
package com.garage.garagemanagementsystem.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "service_history")
public class ServiceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Column(name = "service_date", nullable = false)
    private LocalDate serviceDate;

    @Column(name = "service_type", length = 100)
    private String serviceType;

    @Column(precision = 10, scale = 2)
    private BigDecimal cost;

    @Column(name = "mechanic_notes", columnDefinition = "TEXT")
    private String mechanicNotes;

    @Column(name = "parts_replaced", columnDefinition = "TEXT")
    private String partsReplaced;

    public ServiceHistory() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getServiceDate() { return serviceDate; }
    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getMechanicNotes() { return mechanicNotes; }
    public void setMechanicNotes(String mechanicNotes) {
        this.mechanicNotes = mechanicNotes;
    }

    public String getPartsReplaced() { return partsReplaced; }
    public void setPartsReplaced(String partsReplaced) {
        this.partsReplaced = partsReplaced;
    }
}
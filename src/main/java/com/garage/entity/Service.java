package com.garage.garagemanagementsystem.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "estimated_hours")
    private Integer estimatedHours;

    @Column(name = "base_price")
    private BigDecimal basePrice;

    private String category;

    public Service() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getEstimatedHours() {
        return estimatedHours;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEstimatedHours(Integer estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
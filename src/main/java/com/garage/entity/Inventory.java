
package com.garage.garagemanagementsystem.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "part_name", nullable = false)
    private String partName;

    @Column(name = "part_number")
    private String partNumber;

    private String category;

    @Column(nullable = false)
    private Integer quantity = 0;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice = BigDecimal.ZERO;

    @Column(name = "reorder_level")
    private Integer reorderLevel = 5;

    private String supplier;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Inventory() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }

    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }

    public Integer getReorderLevel() { return reorderLevel; }
    public void setReorderLevel(Integer reorderLevel) { this.reorderLevel = reorderLevel; }

    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Transient
    public boolean isLowStock() {
        return quantity != null
                && reorderLevel != null
                && quantity <= reorderLevel;
    }
}
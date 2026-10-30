package com.garage.garagemanagementsystem.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "booking_id", unique = true)
    private ServiceBooking booking;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "total_amount")
    private BigDecimal totalAmount = BigDecimal.ZERO;

    private BigDecimal tax = BigDecimal.ZERO;

    private BigDecimal discount = BigDecimal.ZERO;

    @Column(name = "final_amount")
    private BigDecimal finalAmount = BigDecimal.ZERO;

    @Column(length = 20)
    private String status = "UNPAID";

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "paid_date")
    private LocalDate paidDate;

    public Invoice() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ServiceBooking getBooking() { return booking; }
    public void setBooking(ServiceBooking booking) { this.booking = booking; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public BigDecimal getTax() { return tax; }
    public void setTax(BigDecimal tax) { this.tax = tax; }

    public BigDecimal getDiscount() { return discount; }
    public void setDiscount(BigDecimal discount) { this.discount = discount; }

    public BigDecimal getFinalAmount() { return finalAmount; }
    public void setFinalAmount(BigDecimal finalAmount) { this.finalAmount = finalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public LocalDate getPaidDate() { return paidDate; }
    public void setPaidDate(LocalDate paidDate) { this.paidDate = paidDate; }
}

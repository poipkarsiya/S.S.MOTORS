package com.garage.garagemanagementsystem.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "service_bookings")
public class ServiceBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "estimated_completion")
    private LocalDate estimatedCompletion;

    private String priority;

    private String status;

    @Column(name = "mechanic_id")
    private Long mechanicId;

    @Column(columnDefinition = "TEXT")
    private String notes;

    public ServiceBooking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getEstimatedCompletion() {
        return estimatedCompletion;
    }

    public void setEstimatedCompletion(LocalDate estimatedCompletion) {
        this.estimatedCompletion = estimatedCompletion;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Long mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}


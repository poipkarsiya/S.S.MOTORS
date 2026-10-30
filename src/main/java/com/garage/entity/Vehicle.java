package com.garage.garagemanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_number", nullable = false, length = 20)
    private String registrationNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "make", length = 50)
    private String make;

    @Column(name = "model", length = 50)
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "vin", length = 50)
    private String vin;

    @Column(name = "engine_type", length = 50)
    private String engineType;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "vehicle_type", length = 50)
    private String vehicleType;

    @Column(name = "vehicle_year")
    private Integer vehicleYear;

    @Column(name = "brand", length = 50)
    private String brand;

    @Column(name = "vehicle_number", length = 50)
    private String vehicleNumber;

    @Column(name = "fuel_type", length = 50)
    private String fuelType;

    public Vehicle() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String value) {
        this.registrationNumber = value;
    }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public String getEngineType() { return engineType; }
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Integer getMileage() { return mileage; }
    public void setMileage(Integer mileage) { this.mileage = mileage; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getVehicleYear() { return vehicleYear; }
    public void setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}


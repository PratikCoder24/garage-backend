package Garage_System.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model",nullable = false)
    private String model;

    @Column(name = "vehicle_number",nullable = false,unique = true)
    private String vehicleNumber;

    @Column(name = "company",nullable = false)
    private String company;

    @Column(name = "chassis_number",nullable = false,unique = true)
    private String chassisNumber;

    @Column(name = "engine_number",nullable = false)
    private String engineNumber;

    @Column(name = "odometer",nullable = false)
    private int odometer;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}

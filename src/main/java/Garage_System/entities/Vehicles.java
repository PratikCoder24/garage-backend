package Garage_System.entities;

import Garage_System.Enum.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @Column(name = "chassis_number",unique = true)
    private String chassisNumber;

    @Column(name = "engine_number")
    private String engineNumber;

    @Column(name = "odometer",nullable = false)
    private Integer odometer;

    @Enumerated(EnumType.STRING)
    @Column(name="vehicle_type",nullable = false,length = 20)
    private VehicleType vehicleType;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "vehicle",fetch = FetchType.LAZY)
    private List<JobCard> jobCardList;
}

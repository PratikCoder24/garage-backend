package Garage_System.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "service_catalogue")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCatalogue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(name = "service_charge",nullable = false)
    private int serviceCharge;
}

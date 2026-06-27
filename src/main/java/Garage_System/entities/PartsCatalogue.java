package Garage_System.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "parts_catalogue")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartsCatalogue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String partName;

    @Column(name = "price",nullable = false)
    private double price;

    @OneToMany(mappedBy = "parts",fetch = FetchType.LAZY)
    private List<JobCardPartsItem> jobCardPartsItemList;
}


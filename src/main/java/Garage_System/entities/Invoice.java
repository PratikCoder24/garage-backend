package Garage_System.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "job_card_id",nullable = false,unique = true)
    private JobCard jobCard;

    @Column(name = "labour_cost",nullable = false)
    private double labourCost;

    @Column(name = "parts_total",nullable = false)
    private double partsTotal;

    @Column(name = "total_amount",nullable = false)
    private double totalAmount;

    private String paymentQr;

    @Column(name = "created_at",nullable = false)
    private LocalDate createdAt;
}

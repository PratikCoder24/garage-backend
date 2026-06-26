package Garage_System.entities;

import Garage_System.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "job_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "condition_notes",nullable = false,length = 1000)
    private String conditionNotes;

    private LocalDate createdAt;

    private LocalDate deliveryDate;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicle;

    @OneToMany(mappedBy = "jobCard",fetch = FetchType.LAZY)
    private List<JobCardServiceItem> jobCardServiceItemList;

}


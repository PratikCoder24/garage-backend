package Garage_System.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fuel_reading")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuelReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "job_card_id",nullable = false,unique = true)
    private JobCard jobCard;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(
                    name = "readingMode",
                    column = @Column(name = "in_reading_mode", length = 25)
            ),
            @AttributeOverride(
                    name = "fuelLevel",
                    column = @Column(name = "in_fuel_level", precision = 5,scale = 2)
            ),
            @AttributeOverride(
                    name = "meterStatus",
                    column = @Column(name = "in_meter_status", length = 25)
            ),
            @AttributeOverride(
                    name = "reserveStatus",
                    column = @Column(name = "in_reserve_status", length = 25)
            ),
            @AttributeOverride(
                    name = "recordedAt",
                    column = @Column(name = "in_recorded_at")
            )
    }

    )
    private FuelReadingDetails inReading;
}

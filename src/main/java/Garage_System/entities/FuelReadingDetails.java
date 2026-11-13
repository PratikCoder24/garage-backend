package Garage_System.entities;

import Garage_System.Enum.MeterStatus;
import Garage_System.Enum.ReadingMode;
import Garage_System.Enum.ReserveStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuelReadingDetails {

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private ReadingMode readingMode;

    @Column(precision = 5,scale = 2)
    private BigDecimal fuelLevel;

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private MeterStatus meterStatus;

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private ReserveStatus reserveStatus;

    private LocalDateTime recordedAt;

}

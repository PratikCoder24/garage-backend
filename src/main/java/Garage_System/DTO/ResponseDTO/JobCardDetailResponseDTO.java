package Garage_System.DTO.ResponseDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobCardDetailResponseDTO {
    private  Long id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdAt;

    private String conditionNotes;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate deliveryDate;

    private String status;

    private String vehicleNumber;

    private List<JobCardServiceItemResponseDTO> services;
    private double estimate;

    private List<JobCardPartsItemResponseDTO> parts;
    private double partsTotal;
}

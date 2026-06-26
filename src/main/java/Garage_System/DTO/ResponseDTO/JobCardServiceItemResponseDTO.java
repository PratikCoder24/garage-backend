package Garage_System.DTO.ResponseDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobCardServiceItemResponseDTO {
    private Long id;
    private Long jobCardId;
    private Long serviceId;
    private String serviceName;
    private double defaultFee;
    private double labourFee;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdAt;
}

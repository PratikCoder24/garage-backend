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
public class JobCardPartsItemResponseDTO {
    private Long id;
    private Long jobCardId;
    private Long partId;
    private String partName;
    private double price;
    private double priceUsed;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdAt;

}

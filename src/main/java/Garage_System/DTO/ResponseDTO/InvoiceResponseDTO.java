package Garage_System.DTO.ResponseDTO;

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
public class InvoiceResponseDTO {
    private Long invoiceId;
    private Long jobCardId;
    private List<JobCardServiceItemResponseDTO> services;
    private Double labourCost;
    private List<JobCardPartsItemResponseDTO> parts;
    private Double partsCost;
    private Double totalAmount;
    private String paymentQr;
    private LocalDate createdAt;
}

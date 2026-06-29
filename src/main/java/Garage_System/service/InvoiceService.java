package Garage_System.service;

import Garage_System.DTO.ResponseDTO.InvoiceResponseDTO;

public interface InvoiceService {
    InvoiceResponseDTO generateInvoice(Long jobCardId);

    InvoiceResponseDTO getInvoice(Long invoiceId);
}

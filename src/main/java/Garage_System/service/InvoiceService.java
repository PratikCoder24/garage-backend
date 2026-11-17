package Garage_System.service;

import Garage_System.DTO.ResponseDTO.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO generateInvoice(Long jobCardId);

    InvoiceResponseDTO getInvoice(Long invoiceId);

    InvoiceResponseDTO getInvoiceByJobCardId(Long jobCardId);

    List<InvoiceResponseDTO> getAllInvoice();
}

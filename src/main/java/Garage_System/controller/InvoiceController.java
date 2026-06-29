package Garage_System.controller;

import Garage_System.DTO.ResponseDTO.InvoiceResponseDTO;
import Garage_System.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceResponseDTO>  getInvoice(@PathVariable Long invoiceId){
        return ResponseEntity.ok(invoiceService.getInvoice(invoiceId));
    }

    @PostMapping("/job-card/{jobCardId}")
    public ResponseEntity<InvoiceResponseDTO> generateInvoice(@PathVariable Long jobCardId){
        InvoiceResponseDTO response = invoiceService.generateInvoice(jobCardId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

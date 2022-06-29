package com.be.be_app.service;

import com.be.be_app.model.Contract;
import com.be.be_app.model.Invoice;
import com.be.be_app.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService{
    @Autowired

    public InvoiceRepository invoiceRepository;
    @RequestMapping("/invoices")
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoiceRepository.findAll().forEach(invoices::add);
        return invoices;
    }

    public void addInvoice(Invoice invoice){
        invoiceRepository.save(invoice);
    }
    public void updateInvoice(Long id, Invoice invoice) {
        Invoice invoice1 = invoiceRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Invoice was not found")
        );
        invoice.setId(id);
        invoice1 = invoice;
        invoiceRepository.save(invoice1);
    }
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}

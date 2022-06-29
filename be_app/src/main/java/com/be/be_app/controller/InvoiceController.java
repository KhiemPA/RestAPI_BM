package com.be.be_app.controller;


import com.be.be_app.model.Invoice;
import com.be.be_app.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @RequestMapping("/invoices")
    public List<Invoice> getALlInvoices() {
        return invoiceService.getAllInvoices();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/invoices")
    public void addInvoice(@RequestBody Invoice invoice) {
        invoiceService.addInvoice(invoice);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/invoices/{id}")
    public void updateInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        invoiceService.updateInvoice(id,invoice);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/invoices/{id}")
    public void deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
    }


}

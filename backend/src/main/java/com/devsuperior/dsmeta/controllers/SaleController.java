package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleDto;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    public SaleService saleService;

    @Autowired
    public SmsService smsService;

    @GetMapping
    public ResponseEntity<Page<SaleDto>> findSales(@RequestParam(value="minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value="maxDate", defaultValue = "") String maxDate,
                                                 Pageable pageable) {

        Page<SaleDto> sales = saleService.findSales(minDate,maxDate, pageable);

        return ResponseEntity.ok().body(sales);
    }

    @GetMapping("/{id}/notification")
    public ResponseEntity<String> notifySms(@PathVariable Long id) {

       String message =  smsService.sendSms(id);

        return ResponseEntity.ok().body(message);
    }
}

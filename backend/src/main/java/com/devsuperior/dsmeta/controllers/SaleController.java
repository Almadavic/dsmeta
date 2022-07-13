package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleDto;
import com.devsuperior.dsmeta.services.SaleService;
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

    @GetMapping
    public ResponseEntity<Page<SaleDto>> findSales(@RequestParam(value="minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value="maxDate", defaultValue = "") String maxDate,
                                                 Pageable pageable) {

        Page<SaleDto> sales = saleService.findSales(minDate,maxDate, pageable);

        return ResponseEntity.ok().body(sales);
    }
}

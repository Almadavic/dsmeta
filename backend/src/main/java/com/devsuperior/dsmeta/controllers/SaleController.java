package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleDto;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    public SaleService saleService;

    @GetMapping
    public ResponseEntity<List<SaleDto>> findAll() {

        List<SaleDto> sales = saleService.findAll();

        return ResponseEntity.ok().body(sales);
    }
}

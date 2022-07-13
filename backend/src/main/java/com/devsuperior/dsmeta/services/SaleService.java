package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleDto;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

      @Autowired
      private SaleRepository saleRepository;

       public List<SaleDto> findAll() {

           List<Sale> sales = saleRepository.findAll();

           return sales.stream().map(SaleDto::new).collect(Collectors.toList());
       }
}

package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleDto;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;


@Service
public class SaleService {

      @Autowired
      private SaleRepository saleRepository;

       public Page<SaleDto> findSales(String minDate, String maxDate, Pageable page) {

           LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

           LocalDate min = minDate.equals("") ?  today.minusYears(1): LocalDate.parse(minDate);
           LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

           Page<Sale> sales = saleRepository.findSales(min,max,page);

           return sales.map(SaleDto::new);
       }
}

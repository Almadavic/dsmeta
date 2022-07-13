package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class SaleDto {

    private Long id;
    private String sellerName;
    private Integer visited;
    private Integer deals;
    private Double amount;
    private LocalDate date;

    public SaleDto(Sale sale) {
        this.id=sale.getId();
        this.sellerName=sale.getSellerName();
        this.visited=sale.getVisited();
        this.deals=sale.getDeals();
        this.amount=sale.getAmount();
        this.date=sale.getDate();
    }

    public Long getId() {
        return id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Integer getVisited() {
        return visited;
    }

    public Integer getDeals() {
        return deals;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}

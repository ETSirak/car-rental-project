package com.sda.carrentalproject.dto;

import com.sda.carrentalproject.domain.PriceList;
import com.sda.carrentalproject.domain.enumeration.Color;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;

import java.time.YearMonth;

@Builder
public record CarDto(Long id,

        String brand,

        String model,

        YearMonth productionYear,

        @Enumerated(EnumType.STRING)
                Color color,

        boolean available,

        PriceList priceList) {


}
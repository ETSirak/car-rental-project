package com.sda.carrentalproject.dto;


import com.sda.carrentalproject.domain.Client;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record BookingRecordDto(
        Long Id,
        CarDto bookedCar,
        Client client,
        LocalDate startDate,
        LocalDate endDate,
        long fullPriceInEuroCents

) {
}

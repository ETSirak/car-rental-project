package com.sda.carrentalproject.service;

import com.sda.carrentalproject.domain.Client;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @Test
    void checkInjectedService(){
        Assertions.assertNotNull(clientService, "Bean should be injected");
    }

    @Test
    void creatingNewClient(){
        //create new client
        Client client = Client.builder()
                .name("Marko")
                .surname("Kalamees")
                .phone("555-555-212")
                .email("mk@et.et")
                .address("Estonia")
                .hasDrivingLicense(true)
                .dateOfBirth(LocalDate.of(1991, Month.APRIL, 27))
                .build();
        //save it
        var saved = clientService.saveClient(client);
        //verify it after saving
        Assertions.assertNotNull(saved.getId(), "Entity should have id!");
        Assertions.assertEquals(client.getName(), saved.getName());
        Assertions.assertEquals(client.getSurname(), saved.getSurname());
        Assertions.assertEquals(client.getPhone(), saved.getPhone());
        Assertions.assertEquals(client.getEmail(), saved.getEmail());
        Assertions.assertEquals(client.getAddress(), saved.getAddress());
        Assertions.assertEquals(client.getDateOfBirth(), saved.getDateOfBirth());
        Assertions.assertEquals(client.getRegistrationDateTime(), saved.getRegistrationDateTime());
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllClients() {
    }
}
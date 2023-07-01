package com.sda.carrentalproject.configuration.data;

import com.sda.carrentalproject.domain.Client;
import com.sda.carrentalproject.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

//TODO: move to develop profile
@Component
@Slf4j
public class ClientDataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;

    public ClientDataInitializer(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Creating some clients");

        Client client = Client.builder()
                .name("Erki")
                .surname("Sirak")
                .phone("123123")
                .email("et@et.et")
                .address("Estonia")
                .hasDrivingLicense(true)
                .dateOfBirth(LocalDate.of(1991, Month.APRIL, 27))
                .build();

        clientRepository.save(client);
    }
}

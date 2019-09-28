package com.sergio.brewery.bootstrap;

import com.sergio.brewery.domain.Beer;
import com.sergio.brewery.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Sagres")
                    .beerStyle("Lager")
                    .quantityToBrew(200)
                    .upc(33700101L)
                    .price(new BigDecimal("12.3"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Super Bock")
                    .beerStyle("Lager")
                    .quantityToBrew(200)
                    .upc(33700101L)
                    .price(new BigDecimal("12.4"))
                    .build());
        }

    }
}

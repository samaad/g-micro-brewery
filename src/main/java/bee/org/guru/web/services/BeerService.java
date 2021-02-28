package bee.org.guru.web.services;

import bee.org.guru.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
    BeerDto saveBeerDto(BeerDto beerDto);
    BeerDto updateBear(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}

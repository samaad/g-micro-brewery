package bee.org.guru.web.services.v2;

import bee.org.guru.web.model.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveBeerDto(BeerDtoV2 beerDto);

    BeerDtoV2 updateBear(UUID beerId, BeerDtoV2 beerDto);

    void deleteBeer(UUID beerId);
}

package bee.org.guru.web.services.v2;

import bee.org.guru.web.model.BeerDtoV2;
import bee.org.guru.web.model.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDtoV2 saveBeerDto(BeerDtoV2 beerDtoV2) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public BeerDtoV2 updateBear(UUID beerId, BeerDtoV2 beerDtoV2) {
        return null;
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleteing the element......");
    }
}

package bee.org.guru.web.mappers;

import bee.org.guru.domain.Beer;
import bee.org.guru.web.model.BeerDtoV2;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDtoV2 beerTobeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDtoV2 beerDtoV2);
}

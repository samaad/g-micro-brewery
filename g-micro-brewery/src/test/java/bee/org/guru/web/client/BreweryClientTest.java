package bee.org.guru.web.client;

import bee.org.guru.web.model.BeerDtoV2;
import bee.org.guru.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById(){
        BeerDtoV2 dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveBeer(){
        BeerDtoV2 beerDto = BeerDtoV2.builder().beerName("New beer")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .price(new BigDecimal("1.00"))
                .upc(2L)
                .build();
        URI uri = client.sendRequest(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer(){
        BeerDtoV2 beerDto = BeerDtoV2.builder().beerName("New Beer")
                .beerStyle(BeerStyleEnum.LAGER)
                .price(new BigDecimal("2.00"))
                .upc(66L)
                .build();
        client.updateBear(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }
}
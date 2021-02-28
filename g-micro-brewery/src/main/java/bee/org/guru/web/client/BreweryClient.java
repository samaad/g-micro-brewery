package bee.org.guru.web.client;

import bee.org.guru.web.model.BeerDtoV2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "my.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH__V1 = "/api/v2/beer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDtoV2 getBeerById(UUID beerId){
        return restTemplate.getForObject(apihost+BEER_PATH__V1 + beerId.toString(), BeerDtoV2.class);
    }

    public URI sendRequest(BeerDtoV2 beerDto){
        return restTemplate.postForLocation(apihost+BEER_PATH__V1, beerDto);
    }

    public void updateBear(UUID uuid, BeerDtoV2 beerDtoV2){
        restTemplate.put(apihost + BEER_PATH__V1 + uuid.toString(), beerDtoV2);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apihost + BEER_PATH__V1 + uuid.toString());
    }
    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}

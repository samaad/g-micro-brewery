package bee.org.guru.web.client;

import bee.org.guru.web.model.BeerDtoV2;
import bee.org.guru.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Configuration
@ConfigurationProperties(value = "my.brewery", ignoreUnknownFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID cid){
        return restTemplate.getForObject(apihost+CUSTOMER_PATH_V1 + cid.toString(), CustomerDto.class);
    }

    public URI saveCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apihost+CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + uuid.toString(), customerDto);
    }

    public void deleteCustomer(UUID cid){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + cid.toString());
    }
    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}

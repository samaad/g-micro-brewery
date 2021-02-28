package bee.org.guru.web.services;

import bee.org.guru.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().id(id.randomUUID())
                .name("Shoaib")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto beerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public CustomerDto updateCustomer(UUID beerId, CustomerDto beerDto) {
        return null;
    }

    @Override
    public void deleteCustomer(UUID id) {
        log.debug("Deleteing the element......");
    }
}

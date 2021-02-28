package bee.org.guru.web.services;


import bee.org.guru.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);
    CustomerDto saveCustomer(CustomerDto beerDto);
    CustomerDto updateCustomer(UUID beerId, CustomerDto beerDto);

    void deleteCustomer(UUID id);
}

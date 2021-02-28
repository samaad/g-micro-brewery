package bee.org.guru.web.mappers;

import bee.org.guru.domain.Customer;
import bee.org.guru.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customer);
}

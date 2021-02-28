package bee.org.guru.web.client;

import bee.org.guru.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;


    @Test
    void getCustomerById() {
        CustomerDto customerId = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerId);
    }

    @Test
    void saveCustomer() {
        CustomerDto customer = CustomerDto.builder().name("shoaib").build();
        URI uri = customerClient.saveCustomer(customer);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateCustomer() {
        CustomerDto customer = CustomerDto.builder().name("shoaib").build();
        customerClient.updateCustomer(UUID.randomUUID(), customer);
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}
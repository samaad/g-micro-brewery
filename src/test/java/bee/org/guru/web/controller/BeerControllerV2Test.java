package bee.org.guru.web.controller;

import bee.org.guru.web.controller.v2.BeerControllerV2;
import bee.org.guru.web.model.BeerDtoV2;
import bee.org.guru.web.model.BeerStyleEnum;
import bee.org.guru.web.services.v2.BeerServiceV2;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringRunner.class)
@WebMvcTest(BeerControllerV2.class)
class BeerControllerV2Test {

    @MockBean
    BeerServiceV2 beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDtoV2 validBeer;

    @BeforeEach
    public void setUp() {
        validBeer = BeerDtoV2.builder()
                .beerName("Beer1")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .price(new BigDecimal("1.00"))
                .upc(123456789012L)
                .build();
    }

    @Test
    public void getBeerById() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

        mockMvc.perform(get("/api/v2/beer/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName", is("Beer1")));
    }

//    @Test
    public void handlePost() throws Exception {
        //given
//        BeerDtoV2 beerDto = validBeer;
        BeerDtoV2 savedDto = BeerDtoV2.builder()
                    .beerName("Beer1")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .price(new BigDecimal("1.00"))
                .upc(123456789012L)
                .build();
        String beerDtoJson = objectMapper.writeValueAsString(savedDto);

//        given(beerService.saveBeerDto(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v2/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());

    }

//    @Test
    public void handleUpdate() throws Exception {
        //given
        BeerDtoV2 beerDto = validBeer;
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        //when
        mockMvc.perform(put("/api/v2/beer/" + validBeer.getId())
//                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());

        then(beerService).should().updateBear(any(), any());

    }
}
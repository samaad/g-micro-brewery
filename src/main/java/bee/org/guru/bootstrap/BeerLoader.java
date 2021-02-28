package bee.org.guru.bootstrap;

import bee.org.guru.domain.Beer;
import bee.org.guru.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerObject();
    }

    private void loadBeerObject() {
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                    .beerName("demo")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHnd(12)
                    .upc(3213213322L)
                    .price(new BigDecimal(12.95))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_IPA")
                    .quantityToBrew(200)
                    .minOnHnd(12)
                    .upc(323211122L)
                    .price(new BigDecimal(11.95))
                    .build());
        }

        System.out.println("Load Beer " + beerRepository.count());
    }
}

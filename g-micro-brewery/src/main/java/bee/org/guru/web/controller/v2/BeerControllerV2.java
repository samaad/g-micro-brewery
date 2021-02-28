package bee.org.guru.web.controller.v2;

import bee.org.guru.web.model.BeerDtoV2;
import bee.org.guru.web.services.v2.BeerServiceV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated
@RequestMapping("/api/v2/beer")
@RestController
@RequiredArgsConstructor
@Slf4j
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeerById(@NotNull @PathVariable("beerId") UUID beerId){
        return new ResponseEntity<BeerDtoV2>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDtoV2> saveNewBeer(@Valid @RequestBody BeerDtoV2 beerDto){
        val saveDto = beerService.saveBeerDto(beerDto);
        log.debug("save object", saveDto.toString());
        val headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer"+saveDto.getId().toString());
        log.debug("in handle post");
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> updateBeerById(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto){
        beerService.updateBear(beerId, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeer(beerId);
    }

    /*@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }*/
}

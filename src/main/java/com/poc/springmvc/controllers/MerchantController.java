package com.poc.springmvc.controllers;

import com.poc.springmvc.converters.MerchantConverter;
import com.poc.springmvc.domain.Merchant;
import com.poc.springmvc.domain.MerchantPayload;
import com.poc.springmvc.services.MerchantService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luram Archanjo / 20180819
 */
@RestController
@RequestMapping("/merchants")
@AllArgsConstructor
@Slf4j
public class MerchantController {

  private final MerchantService merchantService;

  @GetMapping
  public ResponseEntity<?> get() {
    log.info("Received a get request");

    return ResponseEntity.status(HttpStatus.OK).body(merchantService.getAll());
  }

  @PostMapping
  public ResponseEntity<?> post(@Valid @RequestBody MerchantPayload merchantPayload) {
    log.info("Received a post request with payload {}", merchantPayload);

    Merchant merchant = MerchantConverter.builder()
        .merchantPayload(merchantPayload)
        .build()
        .convert();

    merchantService.createMerchant(merchant);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> put(@PathVariable(name = "id") String id,
      @Valid @RequestBody MerchantPayload merchantPayload) {
    log.info("Received a delete request");

    Merchant merchant = MerchantConverter.builder()
        .merchantPayload(merchantPayload)
        .build()
        .convert();

    merchantService.updateMerchant(id, merchant);

    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable(name = "id") String id) {
    log.info("Received a delete request");

    merchantService.deleteMerchant(id);

    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
  }

}
package com.poc.springmvc.services;

import com.poc.springmvc.domain.Merchant;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Luram Archanjo / 20180819
 */
@Service
@Slf4j
public class MerchantService {

  // It is just a poc, in production use other way to persist the data etc..
  private Map<String, Merchant> mapOfMerchant = new ConcurrentHashMap<>();

  public Collection<Merchant> getAll() {
    log.info("Getting all {}", Merchant.class.getSimpleName());
    return mapOfMerchant.values();
  }

  public Merchant createMerchant(@NonNull Merchant merchant) {
    log.info("Creating new {}", merchant);
    return mapOfMerchant.put(merchant.getId(), merchant);
  }

  public Merchant updateMerchant(String id, @NonNull Merchant merchant) {
    log.info("Updating {} with id {}", Merchant.class.getSimpleName(), id);
    return mapOfMerchant.put(id, merchant);
  }

  public Merchant deleteMerchant(String id) {
    log.info("Removing {} with id {}", Merchant.class.getSimpleName(), id);
    return mapOfMerchant.remove(id);
  }

}
package com.poc.springmvc.converters;

import com.poc.springmvc.domain.Merchant;
import com.poc.springmvc.domain.MerchantPayload;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Luram Archanjo / 20180819
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class MerchantConverter implements Converter<Merchant> {

  private MerchantPayload merchantPayload;

  @Override
  public Merchant convert() {
    Merchant merchant = null;

    log.info("Converting {} to {}", merchantPayload, Merchant.class.getSimpleName());
    if (Objects.nonNull(merchantPayload)) {
      merchant = Merchant.builder()
          .name(merchantPayload.getName())
          .address(merchantPayload.getAddress())
          .build();
    }

    return merchant;
  }
}

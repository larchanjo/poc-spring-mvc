package com.poc.springmvc.domain;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Luram Archanjo / 20180819
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {

  private final String id = UUID.randomUUID().toString();

  @NotBlank(message = "Name must not be blank")
  private String name;

  @NotBlank(message = "Address must not be blank")
  private String address;

}

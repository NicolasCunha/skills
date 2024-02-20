package com.nfcunha.portfolio.healthcheck;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HealthCheckDto {

  private HealthCheckStatus status;

}

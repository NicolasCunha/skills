package com.nfcunha.portfolio.healthcheck;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class HealthCheckController {

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HealthCheckDto> performHealthCheck() {
    return ResponseEntity.ok(HealthCheckDto.builder().status(HealthCheckStatus.UP).build());
  }

}

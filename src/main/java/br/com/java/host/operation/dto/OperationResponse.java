package br.com.java.host.operation.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class OperationResponse {

    private Long id;
    private String description;
    private BigDecimal value;
}

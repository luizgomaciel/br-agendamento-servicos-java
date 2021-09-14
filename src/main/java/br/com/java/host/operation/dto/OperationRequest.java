package br.com.java.host.operation.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OperationRequest {

    private String description;
    private BigDecimal value;
}

package br.com.java.host.scheduled.dto;

import br.com.java.host.client.dto.ClientResponse;
import br.com.java.host.operation.dto.OperationResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleResponse {

    private Long id;
    private LocalDateTime dateHour;
    private ClientResponse client;
    private OperationResponse operation;
}

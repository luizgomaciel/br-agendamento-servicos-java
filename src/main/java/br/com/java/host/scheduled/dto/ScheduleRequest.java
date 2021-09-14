package br.com.java.host.scheduled.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleRequest {

    private Long clientCode;
    private Long opertationCode;

}

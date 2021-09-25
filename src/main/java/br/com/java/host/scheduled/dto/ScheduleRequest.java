package br.com.java.host.scheduled.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleRequest {

    private String clientCode;
    private String opertationCode;
    private LocalDateTime dateHour;
    private String description;

}

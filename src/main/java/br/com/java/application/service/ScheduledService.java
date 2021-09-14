package br.com.java.application.service;

import br.com.java.host.scheduled.dto.ScheduleRequest;
import br.com.java.host.scheduled.dto.ScheduleResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ScheduledService {

    public ScheduleResponse include(ScheduleRequest schedule);

    public List<ScheduleResponse> searchlistAll();

    public ScheduleResponse update(String number, ScheduleRequest schedule);

    public List<ScheduleResponse> searchListFilter(LocalDate date, BigDecimal value);
}

package br.com.java.application.service.impl;

import br.com.java.application.service.ScheduledService;
import br.com.java.host.scheduled.dto.ScheduleRequest;
import br.com.java.host.scheduled.dto.ScheduleResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduledServiceImpl implements ScheduledService {

    @Override
    public ScheduleResponse include(ScheduleRequest schedule) {
        return null;
    }

    @Override
    public List<ScheduleResponse> searchlistAll() {
        return null;
    }

    @Override
    public ScheduleResponse update(String number, ScheduleRequest schedule) {
        return null;
    }

    @Override
    public List<ScheduleResponse> searchListFilter(LocalDate date, BigDecimal value) {
        return null;
    }
}

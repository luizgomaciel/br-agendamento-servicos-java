package br.com.java.application.service.impl;

import br.com.java.application.exception.NoContentException;
import br.com.java.application.service.ScheduledService;
import br.com.java.application.service.mapper.ScheduledServiceMapper;
import br.com.java.domain.client.Client;
import br.com.java.domain.client.ClientRepository;
import br.com.java.domain.operation.Operation;
import br.com.java.domain.operation.OperationRepository;
import br.com.java.domain.scheduled.Schedule;
import br.com.java.domain.scheduled.ScheduleRepository;
import br.com.java.host.scheduled.dto.ScheduleRequest;
import br.com.java.host.scheduled.dto.ScheduleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduledServiceImpl implements ScheduledService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ScheduledServiceMapper sdcheduledServiceMapper;

    @Override
    public ScheduleResponse include(ScheduleRequest schedule) {
        Optional<Client> cl = clientRepository.findById(schedule.getClientCode());
        Optional<Operation> op = operationRepository.findById(schedule.getOpertationCode());

        Schedule sc = new Schedule();
        sc.setClient(cl.get());
        sc.setOperation(op.get());
        sc.setDateHour(schedule.getDateHour());
        sc.setDescription(schedule.getDescription());

        Schedule scr = scheduleRepository.save(sc);
        return sdcheduledServiceMapper.toScheduleResponse(scr);
    }

    @Override
    public List<ScheduleResponse> searchlistAll() {
        return sdcheduledServiceMapper.toListScheduleResponse(scheduleRepository.findAll());
    }

    @Override
    public ScheduleResponse update(String number, ScheduleRequest schedule) {
        Optional<Schedule> scr = scheduleRepository.findById(number);
        if (!scr.isPresent()) {
            throw new NoContentException();
        }

        Optional<Client> cl = clientRepository.findById(schedule.getClientCode());
        Optional<Operation> op = operationRepository.findById(schedule.getOpertationCode());
        scr.get().setClient(cl.get());
        scr.get().setOperation(op.get());
        scr.get().setDateHour(schedule.getDateHour());
        scr.get().setDescription(schedule.getDescription());

        return sdcheduledServiceMapper.toScheduleResponse(scheduleRepository.save(scr.get()));
    }

    @Override
    public List<ScheduleResponse> searchListFilter(LocalDate date, BigDecimal value) {
        return null;
    }
}

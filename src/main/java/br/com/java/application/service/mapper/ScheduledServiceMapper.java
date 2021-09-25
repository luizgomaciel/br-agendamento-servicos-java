package br.com.java.application.service.mapper;

import br.com.java.domain.scheduled.Schedule;
import br.com.java.host.scheduled.dto.ScheduleResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ScheduledServiceMapper {
    ScheduleResponse toScheduleResponse(Schedule scr);

    List<ScheduleResponse> toListScheduleResponse(List<Schedule> all);
}

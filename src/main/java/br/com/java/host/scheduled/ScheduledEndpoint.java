package br.com.java.host.scheduled;

import br.com.java.application.service.ScheduledService;
import br.com.java.host.scheduled.dto.ScheduleRequest;
import br.com.java.host.scheduled.dto.ScheduleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Api(tags = "Agendamento")
@RestController
@RequestMapping(path = "/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class ScheduledEndpoint {

    @Autowired
    private ScheduledService scheduledService;

    @ApiOperation(value = "Incluir agendamento", notes = "Incluir agendamento")
    @PostMapping(value = "/schedules")
    public ResponseEntity<ScheduleResponse> include(@RequestBody final ScheduleRequest schedule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduledService.include(schedule));
    }

    @ApiOperation(value = "Lista agendamentos", notes = "Lista agendamentos")
    @GetMapping(value = "/schedules")
    public ResponseEntity<List<ScheduleResponse>> searchlistAll() {
        return ResponseEntity.ok(scheduledService.searchlistAll());
    }

    @ApiOperation(value = "Remarcar agendamento", notes = "Remarcar agendamento")
    @PutMapping(value = "/schedules/{number}")
    public ResponseEntity<ScheduleResponse> reschedule(
            @ApiParam(name = "number", value = "Número do agendamento", required = true)
            @PathVariable(required = true, name = "number") final String number,
            @RequestBody final ScheduleRequest schedule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduledService.update(number, schedule));
    }

    @ApiOperation(value = "Listar agendamento por filtro", notes = "Listar agendamento por filtro")
    @GetMapping(value = "/schedules/{date}/{value}")
    public ResponseEntity<List<ScheduleResponse>> searchListFilter(
            @ApiParam(name = "date", value = "Data do agendamento", required = true)
            @PathVariable(required = true, name = "date") final LocalDate date,
            @ApiParam(name = "value", value = "Valor do agendamento", required = true)
            @PathVariable(required = true, name = "value") final BigDecimal value) {
        return ResponseEntity.ok(scheduledService.searchListFilter(date, value));
    }
}

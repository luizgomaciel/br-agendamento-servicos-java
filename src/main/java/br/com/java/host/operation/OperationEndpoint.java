package br.com.java.host.operation;

import br.com.java.application.service.OperationService;
import br.com.java.host.operation.dto.OperationRequest;
import br.com.java.host.operation.dto.OperationResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Serviço")
@RestController
@RequestMapping(path = "/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class OperationEndpoint {

    @Autowired
    private OperationService operationService;

    @ApiOperation(value = "Incluir serviço", notes = "Incluir serviço")
    @PostMapping(value = "/operations")
    public ResponseEntity<OperationResponse> include(@RequestBody final OperationRequest operation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(operationService.include(operation));
    }

    @ApiOperation(value = "Lista serviço", notes = "Lista serviço")
    @GetMapping(value = "/operations")
    public ResponseEntity<List<OperationResponse>> searchList() {
        return ResponseEntity.ok(operationService.searchList());
    }

    @ApiOperation(value = "atualizar serviço", notes = "atualizar serviço")
    @PutMapping(value = "/operations/{number}")
    public ResponseEntity<OperationResponse> update(
            @ApiParam(name = "number", value = "Número do serviço", required = true)
            @PathVariable(required = true, name = "number") final String number,
            @RequestBody final OperationRequest operation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(operationService.update(number, operation));
    }

    @ApiOperation(value = "Excluir serviço", notes = "Excluir serviço")
    @DeleteMapping(value = "/operations/{number}")
    public ResponseEntity<OperationResponse> delete(
            @ApiParam(name = "number", value = "Número do serviço", required = true)
            @PathVariable(required = true, name = "number") final String number) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(operationService.delete(number));
    }
}

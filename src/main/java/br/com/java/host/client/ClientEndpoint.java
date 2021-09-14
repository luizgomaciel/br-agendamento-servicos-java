package br.com.java.host.client;

import br.com.java.application.service.ClientService;
import br.com.java.host.client.dto.ClientRequest;
import br.com.java.host.client.dto.ClientResponse;
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

@Api(tags = "Cliente")
@RestController
@RequestMapping(path = "/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class ClientEndpoint {

    @Autowired
    private ClientService clientService;

    @ApiOperation(value = "Incluir cliente", notes = "Incluir cliente")
    @PostMapping(value = "/clients")
    public ResponseEntity<ClientResponse> include(@RequestBody final ClientRequest client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.include(client));
    }

    @ApiOperation(value = "Lista cliente", notes = "Lista cliente")
    @GetMapping(value = "/clients")
    public ResponseEntity<List<ClientResponse>> searchList() {
        return ResponseEntity.ok(clientService.searchList());
    }

    @ApiOperation(value = "atualizar cliente", notes = "atualizar cliente")
    @PutMapping(value = "/clients/{number}")
    public ResponseEntity<ClientResponse> update(
            @ApiParam(name = "number", value = "Número do cliente", required = true)
            @PathVariable(required = true, name = "number") final String number,
            @RequestBody final ClientRequest client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.update(number, client));
    }

    @ApiOperation(value = "Excluir cliente", notes = "Excluir cliente")
    @DeleteMapping(value = "/clients/{number}")
    public ResponseEntity delete(
            @ApiParam(name = "number", value = "Número do cliente", required = true)
            @PathVariable(required = true, name = "number") final String number) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientService.delete(number));
    }
}

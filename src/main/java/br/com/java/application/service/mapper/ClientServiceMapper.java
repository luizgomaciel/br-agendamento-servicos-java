package br.com.java.application.service.mapper;

import br.com.java.domain.client.Client;
import br.com.java.host.client.dto.ClientRequest;
import br.com.java.host.client.dto.ClientResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientServiceMapper {

    Client toClient(ClientRequest client);

    ClientResponse toClientResponse(Client c);

    List<ClientResponse> toListClientResponse(List<Client> all);
}

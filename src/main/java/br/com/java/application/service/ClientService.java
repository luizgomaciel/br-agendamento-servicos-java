package br.com.java.application.service;

import br.com.java.host.client.dto.ClientRequest;
import br.com.java.host.client.dto.ClientResponse;

import java.util.List;

public interface ClientService {

    public ClientResponse include(ClientRequest client);

    public List<ClientResponse> searchList();

    public ClientResponse update(String number, ClientRequest client);

    public ClientResponse delete(String number);
}

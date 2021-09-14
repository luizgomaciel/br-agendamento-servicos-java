package br.com.java.application.service.impl;

import br.com.java.application.service.ClientService;
import br.com.java.application.service.mapper.ClientServiceMapper;
import br.com.java.domain.client.Client;
import br.com.java.domain.client.ClientRepository;
import br.com.java.host.client.dto.ClientRequest;
import br.com.java.host.client.dto.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientServiceMapper mapper;

    @Override
    public ClientResponse include(ClientRequest client) {
        Client c = repository.save(mapper.toClient(client));
        return mapper.toClientResponse(c);
    }

    @Override
    public List<ClientResponse> searchList() {
        return mapper.toListClientResponse(repository.findAll());
    }

    @Override
    public ClientResponse update(String number, ClientRequest client) {
        Optional<Client> opt = repository.findById(number);
        if (opt.isPresent()) {
            opt.get().setCpf(client.getCpf());
            opt.get().setName(client.getName());
        }
        return mapper.toClientResponse(opt.get());
    }

    @Override
    public ClientResponse delete(String number) {
        Optional<Client> opt = repository.findById(number);
        if (opt.isPresent()) {
            repository.delete(opt.get());
        }
        return mapper.toClientResponse(opt.get());
    }
}

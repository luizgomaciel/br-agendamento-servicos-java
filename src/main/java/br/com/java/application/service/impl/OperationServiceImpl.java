package br.com.java.application.service.impl;

import br.com.java.application.service.OperationService;
import br.com.java.application.service.mapper.OperationServiceMapper;
import br.com.java.domain.operation.Operation;
import br.com.java.domain.operation.OperationRepository;
import br.com.java.host.operation.dto.OperationRequest;
import br.com.java.host.operation.dto.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository repository;

    @Autowired
    private OperationServiceMapper mapper;

    @Override
    public OperationResponse include(OperationRequest operation) {
        Operation o = repository.save(mapper.toOperation(operation));
        return mapper.toOperationResponse(o);
    }

    @Override
    public List<OperationResponse> searchList() {
        return mapper.toListOperationResponse(repository.findAll());
    }

    @Override
    public OperationResponse update(String number, OperationRequest operation) {
        Optional<Operation> opt = repository.findById(number);
        if (opt.isPresent()) {
            opt.get().setDescription(operation.getDescription());
            opt.get().setValue(operation.getValue());
        }
        return mapper.toOperationResponse(opt.get());
    }

    @Override
    public OperationResponse delete(String number) {
        Optional<Operation> opt = repository.findById(number);
        if (opt.isPresent()) {
            repository.delete(opt.get());
        }
        return mapper.toOperationResponse(opt.get());
    }
}

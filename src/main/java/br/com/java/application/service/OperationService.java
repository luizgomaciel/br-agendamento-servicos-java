package br.com.java.application.service;

import br.com.java.host.operation.dto.OperationRequest;
import br.com.java.host.operation.dto.OperationResponse;

import java.util.List;

public interface OperationService {
    public OperationResponse include(OperationRequest operation);

    public List<OperationResponse> searchList();

    public OperationResponse update(String number, OperationRequest operation);

    public OperationResponse delete(String number);
}

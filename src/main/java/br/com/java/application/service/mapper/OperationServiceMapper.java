package br.com.java.application.service.mapper;

import br.com.java.domain.operation.Operation;
import br.com.java.host.operation.dto.OperationRequest;
import br.com.java.host.operation.dto.OperationResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OperationServiceMapper {
    Operation toOperation(OperationRequest operation);

    OperationResponse toOperationResponse(Operation o);

    List<OperationResponse> toListOperationResponse(List<Operation> all);
}

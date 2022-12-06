package sn.isi.mapping;

import org.mapstruct.Mapper;
import sn.isi.dto.Operation;
import sn.isi.entities.OperationEntity;

@Mapper
public interface OperationMapper {
    Operation toOperation(OperationEntity operationEntity);
    OperationEntity fromOperation(Operation operation);
}

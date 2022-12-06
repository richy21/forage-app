package sn.isi.service;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dao.IOperationRepository;
import sn.isi.dto.Operation;
import sn.isi.dao.exception.EntityNotFoundException;
import sn.isi.dao.exception.RequestException;
import sn.isi.mapping.OperationMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class OperationService {

    private IOperationRepository iOperationRepository;
    private OperationMapper operationMapper;
    MessageSource messageSource;

    public OperationService(IOperationRepository iOperationRepository, OperationMapper operationMapper, MessageSource messageSource){
        this.iOperationRepository = iOperationRepository;
        this.operationMapper = operationMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<Operation> getOperation() {
        return StreamSupport.stream(iOperationRepository.findAll().spliterator(), false)
                .map(operationMapper::toOperation)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Operation getOperation(int id) {
        return operationMapper.toOperation(iOperationRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("operation.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public Operation createOperation(Operation operation) {
        return operationMapper.toOperation(iOperationRepository.save(operationMapper.fromOperation(operation)));
    }

    @Transactional
    public Operation updateOperation(int id, Operation operation) {
        return iOperationRepository.findById(id)
                .map(entity -> {
                    operation.setId(id);
                    return operationMapper.toOperation(
                            iOperationRepository.save(operationMapper.fromOperation(operation)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("operation.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteOperation(int id) {
        try {
            iOperationRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("operation.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}

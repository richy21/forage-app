package sn.isi.service;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dao.IClientRepository;
import sn.isi.dto.Client;
import sn.isi.dao.exception.EntityNotFoundException;
import sn.isi.dao.exception.RequestException;
import sn.isi.mapping.ClientMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ClientService {

    private IClientRepository iClientRepository;
    private ClientMapper clientMapper;
    MessageSource messageSource;

    public ClientService(IClientRepository iClientRepository, ClientMapper clientMapper, MessageSource messageSource){
        this.iClientRepository = iClientRepository;
        this.clientMapper = clientMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<Client> getClient() {
        return StreamSupport.stream(iClientRepository.findAll().spliterator(), false)
                .map(clientMapper::toClient)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Client getClient(int id) {
        return clientMapper.toClient(iClientRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("client.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public Client createClient(Client client) {
        return clientMapper.toClient(iClientRepository.save(clientMapper.fromClient(client)));
    }

    @Transactional
    public Client updateClient(int id, Client client) {
        return iClientRepository.findById(id)
                .map(entity -> {
                    client.setId(id);
                    return clientMapper.toClient(
                            iClientRepository.save(clientMapper.fromClient(client)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("client.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteClient(int id) {
        try {
            iClientRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("client.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}

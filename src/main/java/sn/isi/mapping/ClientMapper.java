package sn.isi.mapping;

import org.mapstruct.Mapper;
import sn.isi.dto.Client;
import sn.isi.entities.ClientEntity;

@Mapper
public interface ClientMapper {
    Client toClient(ClientEntity clientEntity);
    ClientEntity fromClient(Client client);
}

package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.ClientEntity;

public interface IClientRepository extends JpaRepository<ClientEntity, Integer> {
}

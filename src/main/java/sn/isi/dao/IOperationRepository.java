package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.OperationEntity;

public interface IOperationRepository extends JpaRepository<OperationEntity, Integer> {
}

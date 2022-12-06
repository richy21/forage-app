package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.FactureEntity;

public interface IFactureRepository extends JpaRepository<FactureEntity, Integer> {
}

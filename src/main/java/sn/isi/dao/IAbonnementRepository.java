package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.AbonnementEntity;

public interface IAbonnementRepository extends JpaRepository<AbonnementEntity, Integer> {
}

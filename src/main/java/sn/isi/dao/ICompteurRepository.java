package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.CompteurEntity;

public interface ICompteurRepository extends JpaRepository<CompteurEntity, Integer> {
}

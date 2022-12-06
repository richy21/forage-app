package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.VillageEntity;

public interface IVillageRepository extends JpaRepository<VillageEntity, Integer> {
}

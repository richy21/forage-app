package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.RolesEntity;

public interface IRolesRepository extends JpaRepository<RolesEntity, Integer> {
}

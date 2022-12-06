package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.UsersEntity;

public interface IUsersRepository extends JpaRepository<UsersEntity, Integer> {
    UsersEntity findByEmail(String email);
}

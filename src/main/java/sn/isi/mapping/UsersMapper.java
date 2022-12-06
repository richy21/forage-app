package sn.isi.mapping;

import org.mapstruct.Mapper;
import sn.isi.dto.Users;
import sn.isi.entities.UsersEntity;

@Mapper
public interface UsersMapper {
    Users toUsers(UsersEntity usersEntity);
    UsersEntity fromUsers(Users users);
}

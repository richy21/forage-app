package sn.isi.mapping;


import sn.isi.dto.Roles;
import sn.isi.entities.RolesEntity;

public interface RolesMapper {
    Roles toRoles(RolesEntity rolesEntity);
    RolesEntity fromRoles(Roles roles);
}

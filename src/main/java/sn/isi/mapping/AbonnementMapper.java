package sn.isi.mapping;

import org.mapstruct.Mapper;
import sn.isi.dto.Abonnement;
import sn.isi.entities.AbonnementEntity;

@Mapper
public interface AbonnementMapper {
    Abonnement toAbonnement(AbonnementEntity abonnementEntity);
    AbonnementEntity fromAbonnement(Abonnement abonnement);
}

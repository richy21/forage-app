package sn.isi.mapping;

import org.mapstruct.Mapper;
import sn.isi.dto.Compteur;
import sn.isi.entities.CompteurEntity;

@Mapper
public interface CompteurMapper {
    Compteur toCompteur(CompteurEntity compteurEntity);
    CompteurEntity fromCompteur(Compteur compteur);
}

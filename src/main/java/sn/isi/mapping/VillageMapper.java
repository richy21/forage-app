package sn.isi.mapping;

import sn.isi.dto.Village;
import sn.isi.entities.VillageEntity;

public interface VillageMapper {
    Village toVillage(VillageEntity villageEntity);
    VillageEntity fromVillage(Village village);
}

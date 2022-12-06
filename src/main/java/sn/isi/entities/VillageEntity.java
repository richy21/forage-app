package sn.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VillageEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(length=100,nullable=false)
    private String chef_village;
    @Column(length=100,nullable=false)
    private String nom_village;
    @OneToMany(mappedBy= "villageEntity")
    private List<ClientEntity> clientEntities;

}

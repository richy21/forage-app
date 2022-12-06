package sn.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length=100,nullable=false)
    private String nom_complet;
    @Column(length=100,nullable=false)
    private String adresse;
    @Column(length=100,nullable=false)
    private int telephone;
    @ManyToOne
    private UsersEntity user;
    @ManyToOne
    private VillageEntity villageEntity;
    @OneToOne
    @PrimaryKeyJoinColumn
    private AbonnementEntity abonnementEntity;
}

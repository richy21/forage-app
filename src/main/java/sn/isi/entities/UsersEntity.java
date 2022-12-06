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
public class UsersEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length=150,nullable=false)
    private String nom;
    @Column(length=100,nullable=false, unique = true)
    private String email;
    @Column(length=100,nullable=false)
    private int telephone;
    @Column(length=150,nullable=false)
    private String password;
    @ManyToMany
    private List<RolesEntity> roles;
    @OneToMany(mappedBy="user")
    private List<ClientEntity> clientEntities;

    @OneToMany(mappedBy="user")
    private List<AbonnementEntity> abonnementEntities;

    @OneToMany(mappedBy="user")
    private List<FactureEntity> factureEntities;

    @OneToMany(mappedBy="user")
    private List<CompteurEntity> compteurEntities;

}

package sn.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteurEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length=5,nullable=false)
    private int numero_cpt;
    @Column(length=5,nullable=false)
    private int index;

    @OneToOne(mappedBy= "compteurEntity")
    @Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private AbonnementEntity abonnementEntity;

    @OneToMany(mappedBy= "compteurEntity")
    private List<OperationEntity> operationEntities;
    @ManyToOne
    private UsersEntity user;





}

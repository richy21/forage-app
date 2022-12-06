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
public class OperationEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length=100,nullable=false)
    private int nv_cumul;
    @Column(length=100,nullable=false)
    private int prix_litre;
    @OneToMany(mappedBy= "operationEntity")
    private List<FactureEntity> factureEntities;
    @ManyToOne
    private CompteurEntity compteurEntity;
}

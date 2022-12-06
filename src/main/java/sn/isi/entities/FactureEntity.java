package sn.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactureEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length=100,nullable=false)
    private int conso_mensuelle;
    @Column(length=100,nullable=false)
    private int montant;
    @Column(length=100,nullable=false)
    private Date date_fac;
    @Column(length=100,nullable=false)
    private int etat;
    @ManyToOne
    private UsersEntity user;
    @ManyToOne
    private OperationEntity operationEntity;
}

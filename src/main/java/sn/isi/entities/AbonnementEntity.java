package sn.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbonnementEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length=100,nullable=false)
    private Date date;
    @Column(length=100,nullable=false)
    private int numero_ab;
    @Column(length=100,nullable=false)
    private String description;
    @OneToOne(mappedBy= "abonnementEntity")
    @Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private ClientEntity clientEntity;
    @ManyToOne
    private UsersEntity user;
    @OneToOne
    @PrimaryKeyJoinColumn
    private CompteurEntity compteurEntity;
}

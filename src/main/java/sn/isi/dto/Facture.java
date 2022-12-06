package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facture {
    private int id;
    @NotNull
    private int conso_mensuelle;
    @NotNull
    private int montant;
    @NotNull
    private Date date_fac;
    @NotNull
    private int etat;

}

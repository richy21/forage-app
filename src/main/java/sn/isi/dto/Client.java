package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private int id;
    @NotNull
    private String nom_complet;
    @NotNull
    private String adresse;
    @NotNull
    private int telephone;

}

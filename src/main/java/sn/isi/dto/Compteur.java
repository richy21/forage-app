package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compteur {
    private int id;
    @NotNull
    private int numero_cpt;
    @NotNull
    private int index;







}

package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Village {
    private int id;
    @NotNull
    private String chef_village;
    @NotNull
     private String nom_village;


}

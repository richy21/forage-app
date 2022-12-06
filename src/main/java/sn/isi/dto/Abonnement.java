package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;


import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Abonnement {
    private int id;
    @NotNull
    private Date date;
    @NotNull
    private int numeroAb;
    @NotNull
    private String description;

}

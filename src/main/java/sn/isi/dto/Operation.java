package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
    private int id;
    @NotNull
    private int nv_cumul;
    @NotNull
    private int prix_litre;

}

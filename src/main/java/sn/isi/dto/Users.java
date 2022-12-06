package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private int id;
    @NotNull
    private String nom;
    @NotNull
    private String email;
    @NotNull
    private int telephone;
    @NotNull
    private String password;


}

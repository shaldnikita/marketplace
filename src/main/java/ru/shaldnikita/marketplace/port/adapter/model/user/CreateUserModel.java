package ru.shaldnikita.marketplace.port.adapter.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserModel {

    @NotNull
    private String name;

    @NotNull
    private String login;

    @NotNull
    private String email;

    @NotNull
    private String password;
}

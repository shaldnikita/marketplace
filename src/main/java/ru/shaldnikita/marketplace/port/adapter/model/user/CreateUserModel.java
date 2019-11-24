package ru.shaldnikita.marketplace.port.adapter.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserModel {

    private String name;

    private String login;

    private String email;

    private String passwordBase64Encoded;
}

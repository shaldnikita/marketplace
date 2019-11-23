package ru.shaldnikita.marketplace.port.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String name;

    private String login;

    private String email;

}

package ru.shaldnikita.marketplace.port.adapter.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String userId;

    private String name;

    private String login;

    private String email;
}

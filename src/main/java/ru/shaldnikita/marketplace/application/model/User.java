package ru.shaldnikita.marketplace.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String userId;

    private String name;

    private String login;

    private String email;

    private String passwordBase64Encoded;
}

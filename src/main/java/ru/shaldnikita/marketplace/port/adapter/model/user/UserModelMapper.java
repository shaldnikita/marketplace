package ru.shaldnikita.marketplace.port.adapter.model.user;

import ru.shaldnikita.marketplace.application.model.User;

public class UserModelMapper {

    public static User map(CreateUserModel createUser) {
        return new User(
                null,
                createUser.getName(),
                createUser.getLogin(),
                createUser.getEmail(),
                createUser.getPassword()
        );
    }

    public static UserModel unmap(User user) {
        return new UserModel(
                user.getUserId(),
                user.getName(),
                user.getLogin(),
                user.getEmail()
        );
    }
}

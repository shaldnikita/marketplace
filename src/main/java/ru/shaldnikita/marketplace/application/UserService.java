package ru.shaldnikita.marketplace.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shaldnikita.marketplace.application.exceptions.UserNotFoundException;
import ru.shaldnikita.marketplace.application.model.User;
import ru.shaldnikita.marketplace.domain.repo.UserRepository;

import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll().stream().map(user ->
                new User(
                        user.getUserId(),
                        user.getName(),
                        user.getLogin(),
                        user.getEmail(),
                        user.getPasswordHash()
                )).collect(Collectors.toList());
    }

    public User findByUserId(String userId) {
        ru.shaldnikita.marketplace.domain.User user = userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return new User(
                user.getUserId(),
                user.getName(),
                user.getLogin(),
                user.getEmail(),
                user.getPasswordHash()
        );
    }

    public User createUser(User createUser) {
        var userId = UUID.randomUUID().toString();
        userRepository.save(
                new ru.shaldnikita.marketplace.domain.User(
                        userId,
                        createUser.getName(),
                        createUser.getLogin(),
                        createUser.getEmail(),
                        new String(Base64.getEncoder().encode(createUser.getPasswordBase64Encoded().getBytes()))
                )
        );
        createUser.setUserId(userId);
        return createUser;
    }

}

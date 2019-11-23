package ru.shaldnikita.marketplace.port.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shaldnikita.marketplace.domain.User;
import ru.shaldnikita.marketplace.domain.UserRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserHandler {

    private final UserRepository repository;

    @GetMapping("users")
    public List<User> findAll() {
        return repository.findAll();
    }

    @GetMapping("users/{id}")
    public User findOne(@PathVariable("id") String userId) {
        return repository.findByUserId(userId);
    }

    @PostMapping("users")
    public String create(@RequestParam("login") String login,
                         @RequestParam("email") String email,
                         @RequestParam("name") String name) {
        return repository.save(
                new User(
                        UUID.randomUUID().toString(),
                        name,
                        login,
                        email
                )
        ).getUserId();
    }
}

package ru.shaldnikita.marketplace.port.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shaldnikita.marketplace.application.UserService;
import ru.shaldnikita.marketplace.port.adapter.model.user.CreateUserModel;
import ru.shaldnikita.marketplace.port.adapter.model.user.UserModel;
import ru.shaldnikita.marketplace.port.adapter.model.user.UserModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserHandler {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserModel> findAll() {
        return userService.findAll().stream().map(UserModelMapper::unmap).collect(Collectors.toList());
    }

    @GetMapping("/users/{id}")
    public UserModel findOne(@PathVariable("id") String userId) {
        return UserModelMapper.unmap(userService.findByUserId(userId));
    }

    @PostMapping("/users")
    public UserModel create(@RequestBody CreateUserModel user) {
        return UserModelMapper.unmap(userService.createUser(UserModelMapper.map(user)));
    }
}

package ru.shaldnikita.marketplace.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import ru.shaldnikita.marketplace.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @NonNull
    Optional<User> findByUserId(String userId);
}

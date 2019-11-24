package ru.shaldnikita.marketplace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    private long id;

    private String userId;

    private String name;

    private String login;

    private String email;

    private String passwordHash;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> commentsIds;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> itemsIds;


    public User(String userId, String name, String login, String email, String passwordHash, List<String> commentsIds, List<String> itemsIds) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.email = email;
        this.passwordHash = passwordHash;
        this.commentsIds = commentsIds;
        this.itemsIds = itemsIds;
    }

    public User(String userId, String name, String login, String email, String passwordHash) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.email = email;
        this.passwordHash = passwordHash;
    }
}

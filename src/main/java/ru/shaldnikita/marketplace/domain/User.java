package ru.shaldnikita.marketplace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "author")
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "owner")
    private List<Item> items;

    public User(String userId, String name, String login, String email, List<Comment> comments, List<Item> items) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.email = email;
        this.comments = comments;
        this.items = items;
    }

    public User(String userId, String name, String login, String email) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.email = email;
    }
}

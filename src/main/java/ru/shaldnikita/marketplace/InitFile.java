package ru.shaldnikita.marketplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.shaldnikita.marketplace.domain.*;
import ru.shaldnikita.marketplace.domain.repo.CommentRepository;
import ru.shaldnikita.marketplace.domain.repo.ItemRepository;
import ru.shaldnikita.marketplace.domain.repo.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Component
public class InitFile implements CommandLineRunner {


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) {
        User user = new User(
                UUID.randomUUID().toString(),
                "Vasya",
                "vasua1",
                "vasya1@mail.ru"
        );
        userRepository.save(user);

        User user2 = new User(
                UUID.randomUUID().toString(),
                "Alewa",
                "alewa1",
                "alewa1@mail.ru"
        );
        userRepository.save(user2);

        User author = new User(
                UUID.randomUUID().toString(),
                "Maxim",
                "Maxim1",
                "maxim1@mail.ru"
        );
        userRepository.save(author);


        Comment comment = new Comment(
                UUID.randomUUID().toString(),
                "huevo",
                LocalDateTime.now(),
                "Вообще ок, но не ок.",
                1,
                200,
                new byte[]{});
        commentRepository.save(comment);

        Comment comment1 = new Comment(
                UUID.randomUUID().toString(),
                "Kruto",
                LocalDateTime.now(),
                "TOP",
                5,
                1,
                new byte[]{});
        commentRepository.save(comment1);


        Item item1 = new Item(
                UUID.randomUUID().toString(),
                "Item1",
                ItemCategory.APPLICATION,
                "Item1 description",
                100000,
                0,
                List.of(comment, comment1),
                author,
                new byte[]{1, 2, 3}
        );


        Item item2 = new Item(
                UUID.randomUUID().toString(),
                "Item2",
                ItemCategory.SERVICE,
                "Item2 description",
                200000,
                5,
                List.of(comment, comment1),
                author,
                new byte[]{1, 2, 3}
        );

        Item item3 = new Item(
                UUID.randomUUID().toString(),
                "Item3",
                ItemCategory.APPLICATION,
                "Item3 description",
                300000,
                3,
                List.of(comment, comment1),
                author,
                new byte[]{1, 2, 3}
        );

        Item item4 = new Item(
                UUID.randomUUID().toString(),
                "Item4",
                ItemCategory.SERVICE,
                "Item4 description",
                400000,
                4,
                List.of(comment, comment1),
                author,
                new byte[]{1, 2, 3}
        );

        item1.setOwner(author);
        item2.setOwner(author);
        item3.setOwner(author);
        item4.setOwner(author);

        item1.setComments(List.of(comment1, comment));
        item2.setComments(List.of(comment1, comment));
        item3.setComments(List.of(comment1, comment));
        item4.setComments(List.of(comment1, comment));

        comment.setAuthor(user);
        comment1.setAuthor(user2);

        author.setItems(List.of(item1, item2, item3, item4));


        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);
    }
}

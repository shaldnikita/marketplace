package ru.shaldnikita.marketplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.shaldnikita.marketplace.domain.Comment;
import ru.shaldnikita.marketplace.domain.Item;
import ru.shaldnikita.marketplace.domain.ItemCategory;
import ru.shaldnikita.marketplace.domain.User;
import ru.shaldnikita.marketplace.domain.repo.CommentRepository;
import ru.shaldnikita.marketplace.domain.repo.ItemRepository;
import ru.shaldnikita.marketplace.domain.repo.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
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
                "vasya1@mail.ru",
                new String(Base64.getDecoder().decode("password".getBytes()))
        );
        userRepository.save(user);

        User user1 = new User(
                UUID.randomUUID().toString(),
                "Alewa",
                "alewa1",
                "alewa1@mail.ru",
                new String(Base64.getDecoder().decode("password".getBytes()))
        );
        userRepository.save(user1);

        User author = new User(
                UUID.randomUUID().toString(),
                "Maxim",
                "Maxim1",
                "maxim1@mail.ru",
                new String(Base64.getDecoder().decode("password".getBytes()))
        );
        userRepository.save(author);


        Item item1 = new Item(
                UUID.randomUUID().toString(),
                author.getUserId(),
                "Item1",
                ItemCategory.APPLICATION,
                "Item1 description",
                100000,
                1,
                null,
                new ArrayList<>()
        );
        var item1Comments = List.of(
                generateBadComment(item1.getItemId(), user.getUserId()),
                generateGoodComment(item1.getItemId(), user1.getUserId())
        );
        item1.setCommentIds(item1Comments);
        itemRepository.save(item1);


        Item item2 = new Item(
                UUID.randomUUID().toString(),
                author.getUserId(),
                "Item2",
                ItemCategory.SERVICE,
                "Item2 description",
                200000,
                5,
                null,
                new ArrayList<>()
        );
        var item2Comments = List.of(
                generateBadComment(item2.getItemId(), user.getUserId()),
                generateGoodComment(item2.getItemId(), user1.getUserId())
        );
        item2.setCommentIds(item2Comments);
        itemRepository.save(item2);

        Item item3 = new Item(
                UUID.randomUUID().toString(),
                author.getUserId(),
                "Item3",
                ItemCategory.APPLICATION,
                "Item3 description",
                300000,
                3,
                null,
                new ArrayList<>()
        );
        var item3Comments = List.of(
                generateBadComment(item3.getItemId(), user.getUserId()),
                generateGoodComment(item3.getItemId(), user1.getUserId())
        );
        item3.setCommentIds(item3Comments);
        itemRepository.save(item3);

        Item item4 = new Item(
                UUID.randomUUID().toString(),
                author.getUserId(),
                "Item4",
                ItemCategory.SERVICE,
                "Item4 description",
                400000,
                4,
                null,
                new ArrayList<>()
        );
        var item4Comments = List.of(
                generateBadComment(item4.getItemId(), user.getUserId()),
                generateGoodComment(item4.getItemId(), user1.getUserId())
        );
        item4.setCommentIds(item4Comments);
        itemRepository.save(item4);
    }

    private String generateGoodComment(String itemId, String authorId) {
        return commentRepository.save(new Comment(
                UUID.randomUUID().toString(),
                "Kruto",
                LocalDateTime.now(),
                "TOP",
                5,
                1,
                null,
                itemId,
                authorId
        )).getCommentId();
    }

    private String generateBadComment(String itemId, String authorId) {
        return commentRepository.save(new Comment(
                UUID.randomUUID().toString(),
                "Huevo",
                LocalDateTime.now(),
                "O4en ploho",
                1,
                400,
                null,
                itemId,
                authorId
        )).getCommentId();
    }
}

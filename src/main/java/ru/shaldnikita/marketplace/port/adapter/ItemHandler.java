package ru.shaldnikita.marketplace.port.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shaldnikita.marketplace.domain.ItemRepository;

@RestController("/")
@RequiredArgsConstructor
public class ItemHandler {

    private ItemRepository repository;


    @GetMapping("records")
    public void getRecords() {
        repository.findAll();
    }

}

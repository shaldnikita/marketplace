package ru.shaldnikita.marketplace.port.adapter.model.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentModel {

    private String name;

    private String content;

    @Nullable
    private Byte[] image;

    private String itemId;

    private String authorId;

}

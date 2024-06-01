package az.websuper.logistics.dtos.article;


import az.websuper.logistics.enums.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCreateDto {
    private String photoUrl;
    private CategoryEnum category;
    private List<ArticleLanguageCreateDto> articleLanguages = new ArrayList<>();
}

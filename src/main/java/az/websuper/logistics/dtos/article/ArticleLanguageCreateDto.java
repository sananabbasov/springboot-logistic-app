package az.websuper.logistics.dtos.article;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLanguageCreateDto {
    private String title;
    private String description;
    private String langCode;
}

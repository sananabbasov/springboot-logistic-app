package az.websuper.logistics.dtos.article;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLanguageDto {
    private Long id;
    private String title;
    private String langCode;
    private Long articleId;
}

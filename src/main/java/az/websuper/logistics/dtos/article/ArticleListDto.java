package az.websuper.logistics.dtos.article;

import az.websuper.logistics.models.Article;
import az.websuper.logistics.models.ArticleLanguage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleListDto {
    private Long id;
    private String photoUrl;
    private ArticleLanguageDto articleLanguage;
    private Date createdDate;
}

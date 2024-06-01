package az.websuper.logistics.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "article_languages")
public class ArticleLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String seoUrl;
    private String langCode;

    @ManyToOne
    private Article article;
}

package az.websuper.logistics.models;


import az.websuper.logistics.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// Test comment
@Getter
@Setter
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photoUrl;
    private Date createdDate;
    private CategoryEnum category;


    @OneToMany(mappedBy = "article")
    private List<ArticleLanguage> articleLanguages = new ArrayList<>();

}

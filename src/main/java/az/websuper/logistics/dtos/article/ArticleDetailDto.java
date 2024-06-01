package az.websuper.logistics.dtos.article;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailDto {
    private Long id;
    private String photoUrl;
    private String title;
    private String description;
    private Date createdDate;
}

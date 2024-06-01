package az.websuper.logistics.repositories;

import az.websuper.logistics.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}

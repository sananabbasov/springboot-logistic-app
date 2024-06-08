package az.websuper.logistics.repositories;

import az.websuper.logistics.models.ArticleLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleLanguageRepository extends JpaRepository<ArticleLanguage, Long> {

    List<ArticleLanguage> getByLangCode(String langCode);
    List<ArticleLanguage> getByArticleId(Long id);
}

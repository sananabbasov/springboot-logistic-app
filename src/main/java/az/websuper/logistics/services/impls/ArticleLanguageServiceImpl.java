package az.websuper.logistics.services.impls;

import az.websuper.logistics.dtos.article.ArticleLanguageCreateDto;
import az.websuper.logistics.dtos.article.ArticleLanguageUpdateDto;
import az.websuper.logistics.models.Article;
import az.websuper.logistics.services.ArticleLanguageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleLanguageServiceImpl implements ArticleLanguageService {
    @Override
    public void createArticleLanguage(List<ArticleLanguageCreateDto> articleLanguages, Article article) {

    }

    @Override
    public void updateArticleLanguage(Long id, ArticleLanguageUpdateDto articleLanguage) {

    }
}

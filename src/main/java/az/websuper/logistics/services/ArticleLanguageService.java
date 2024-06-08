package az.websuper.logistics.services;

import az.websuper.logistics.dtos.article.ArticleLanguageCreateDto;
import az.websuper.logistics.dtos.article.ArticleLanguageDto;
import az.websuper.logistics.dtos.article.ArticleLanguageUpdateDto;
import az.websuper.logistics.models.Article;

import java.util.List;

public interface ArticleLanguageService {
    void createArticleLanguage(List<ArticleLanguageCreateDto> articleLanguages, Article article);
    void updateArticleLanguage(Long id, ArticleLanguageUpdateDto articleLanguage);
    List<ArticleLanguageDto> getByLangCode(String langCode);

    ArticleLanguageDto findByLang(String langCode, Long id);
}

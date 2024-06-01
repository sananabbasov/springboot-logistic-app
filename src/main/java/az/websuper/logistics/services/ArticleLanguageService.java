package az.websuper.logistics.services;

import az.websuper.logistics.dtos.article.ArticleLanguageCreateDto;
import az.websuper.logistics.dtos.article.ArticleLanguageUpdateDto;
import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.banner.BannerLanguageCreateDto;
import az.websuper.logistics.dtos.banner.BannerLanguageUpdateDto;
import az.websuper.logistics.models.Article;
import az.websuper.logistics.models.Banner;

import java.util.List;

public interface ArticleLanguageService {
    void createArticleLanguage(List<ArticleLanguageCreateDto> articleLanguages, Article article);
    void updateArticleLanguage(Long id, ArticleLanguageUpdateDto articleLanguage);
}

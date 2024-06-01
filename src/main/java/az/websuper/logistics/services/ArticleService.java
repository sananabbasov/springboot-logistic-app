package az.websuper.logistics.services;

import az.websuper.logistics.dtos.article.ArticleCreateDto;
import az.websuper.logistics.dtos.article.ArticleListDto;
import az.websuper.logistics.dtos.article.ArticleUpdateDto;
import az.websuper.logistics.enums.CategoryEnum;
import az.websuper.logistics.payloads.PaginationResponse;

import java.util.List;

public interface ArticleService {
    ArticleCreateDto createArticle(ArticleCreateDto createArticle);
    void updateArticle(ArticleUpdateDto updateArticle);
    List<ArticleListDto> getRelatedArticlesByCategory(CategoryEnum categoryEnum, int size);
    List<ArticleListDto> getHomeNews();
    List<ArticleListDto> getHomeActivities();
    PaginationResponse<ArticleListDto> getArticlesActivities(int pageNo);
    PaginationResponse<ArticleListDto>  getArticlesNews(int pageNo);

}

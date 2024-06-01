package az.websuper.logistics.services.impls;

import az.websuper.logistics.dtos.article.ArticleCreateDto;
import az.websuper.logistics.dtos.article.ArticleListDto;
import az.websuper.logistics.dtos.article.ArticleUpdateDto;
import az.websuper.logistics.enums.CategoryEnum;
import az.websuper.logistics.payloads.PaginationResponse;
import az.websuper.logistics.services.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public ArticleCreateDto createArticle(ArticleCreateDto createArticle) {
        return null;
    }

    @Override
    public void updateArticle(ArticleUpdateDto updateArticle) {

    }

    @Override
    public List<ArticleListDto> getRelatedArticlesByCategory(CategoryEnum categoryEnum, int size) {
        return null;
    }

    @Override
    public List<ArticleListDto> getHomeNews() {
        return null;
    }

    @Override
    public List<ArticleListDto> getHomeActivities() {
        return null;
    }

    @Override
    public PaginationResponse<ArticleListDto> getArticlesActivities(int pageNo) {
        return null;
    }

    @Override
    public PaginationResponse<ArticleListDto> getArticlesNews(int pageNo) {
        return null;
    }
}
